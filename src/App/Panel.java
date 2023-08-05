package App;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import java.util.ArrayList;
import java.util.Random;

public class Panel extends JPanel implements Runnable {

    //Screen settings.
    private final int originalTileSize = 16;
    private final int scale = 3;

    private final int tileSize = originalTileSize * scale;

    private final int maxScreenCol = 16;
    private final int maxScreenRow = 12;
    private final int screenWidth = tileSize * maxScreenCol;
    private final int screenHeight = tileSize * maxScreenRow;

    //FPS
    private int FPS = 60;

    //Other stuff
    private ArrayList<AdvancedEnemy> advancedEnemyList;
    private ArrayList<Projectiles> projectileList;
    private KeyHandler keyH = new KeyHandler();
    private MouseMovement mouseMove = new MouseMovement();
    private Player player;
    private Random rand = new Random();
    private Thread gameThread;
    private Healthbar healthbar;

    //Player's variables. 
    private double angle;
    public int playerX = 20;
    public int playerY = 20;
    private int playerSpeed = 4;

    //Projectile variables.
    public int projectileWidth = 30;
    public int projectileHeight = 30;
    public int projectileSpeed = 2;
    public int projectileCount = 0;
    public double magnitude = 2.0;

    //Advanced enemy variables.
    private int advancedEnemyX = rand.nextInt(screenWidth - tileSize);;
    private int advancedEnemyY = rand.nextInt(screenHeight - tileSize);
    private int advancedEnemySpeed = 2;
    private int numOfAdvancedEnemies = 3;

    Panel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true); //If set to true, all the drawings from this component will be done in an offscreen painting buffer. Enabling this can improve the game's rendering performance.
        this.addMouseListener(mouseMove);
        this.addMouseMotionListener(mouseMove);
        this.addKeyListener(keyH);
        this.setFocusable(true);

        //Sets the angle.
        angle = 0;

        //Creates an arraylist of advanced enemies. 
        advancedEnemyList = new ArrayList<AdvancedEnemy>();
        for(int i = 0; i < numOfAdvancedEnemies; i++) {
            advancedEnemyList.add(new AdvancedEnemy(advancedEnemyX, advancedEnemyY, tileSize, tileSize, advancedEnemySpeed));
            advancedEnemyX = rand.nextInt(screenWidth - tileSize);
            advancedEnemyY = rand.nextInt(screenHeight - tileSize);
        }

        //Creates an arraylist of balls.
        projectileList = new ArrayList<Projectiles>();

        player = new Player(playerX, playerY, tileSize, playerSpeed, angle, keyH, mouseMove);
        healthbar = new Healthbar(player.health);
    }

    /*
     * Starts the thread.
     */

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start(); 
    }

    /*
     * Game loop.
     */
    @Override
    public void run() {
        double drawInterval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;

        //Creating the game loop.
        while(gameThread != null) {
            //Update
            update();

            //Draw/repaint
            repaint();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime /= 1000000;

                if (remainingTime < 0) {
                    remainingTime = 0;
                }
                Thread.sleep((long) remainingTime);
                nextDrawTime += drawInterval;
            } 
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //Method to draw the objects. 
    public void update() {
        player.move();

        if(keyH.spacePressed && projectileList.size() <= 100) {
            projectileList.add(new Projectiles((int) player.getX(), (int) player.getY(), projectileWidth, projectileHeight, projectileSpeed, magnitude, mouseMove));
            projectileCount++;
        }
        
        for (int i = 0; i < projectileCount; i++){
            projectileList.get(i).move();
        }

        //Moves each advanced enemy in the array list. 
        for (int i = 0; i < advancedEnemyList.size(); i++){
            advancedEnemyList.get(i).move(player);
        }

        if(projectileList.size() > 100) {
            projectileList.remove(0);
            projectileCount--;
        }
        collisionCheck();
    }

    public void collisionCheck() {
        for(int i = 0; i < advancedEnemyList.size(); i++) {
            for(int j = 0; j < projectileList.size(); j++) {
                // If projectile hits advanced enemy then the projectile will push it back.
                if(projectileList.get(j).intersects(advancedEnemyList.get(i))) {
                    advancedEnemyList.get(i).move();
                }

                // If an advanced enemy hits player then the player will lose one health.
                if(advancedEnemyList.get(i).intersects(player)) {
                    player.reduceHealth();

                    // Create the case when the game ends. 
                    /*
                     * if(player.health == 0) endGameThread or something like that. 
                     */
                }
            }
        }

        // Separate for loop for advanced enemy collisions. 
        for (int i = 1; i < advancedEnemyList.size(); i++) {
            // If an advanced enemy hits another advanced enemy then they will not merge together.  
            if(advancedEnemyList.get(i).intersects(advancedEnemyList.get(i - 1))) {
                advancedEnemyList.get(i).move();
            }
        }
    }

    //Standard method to draw things on JPanel
    @Override
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Draws each projectile. 
        for (int i = 0; i < projectileCount; i++){
            projectileList.get(i).draw(g2d);
        }

        // Draws each advanced enemy in the array list.
        for (int i = 0; i < numOfAdvancedEnemies; i++){
            advancedEnemyList.get(i).draw(g2d);  
        }

        player.draw(g2d);
        healthbar.draw(g2d);
        g2d.dispose();
    }
} 