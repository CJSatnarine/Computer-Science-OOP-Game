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
    private ArrayList<Enemy> enemyList;
    private ArrayList<AdvancedEnemy> advancedEnemyList;
    private ArrayList<Projectiles> orbList;
    private KeyHandler keyH = new KeyHandler();
    private MouseMovement mouseMove = new MouseMovement();
    private Player player;
    private Random rand = new Random();
    private Thread gameThread;

    //Player's variables. 
    private double angle;
    public int playerX = 20;
    public int playerY = 20;
    private int playerSpeed = 4;

    //Projectile variables.
    public int projectileX = playerX;
    public int projectileY = playerY;
    public int projectileWidth = 30;
    public int projectileHeight = 30;
    public int projectileSpeed = 2;
    public int projectileCount;
    

    //Enemy variables.
    private int enemyX = rand.nextInt(screenWidth - tileSize);
    private int enemyY = rand.nextInt(screenHeight - tileSize);
    private int enemySpeed = 3;
    private int numOfEnemies = 20;

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

        //Creates an arraylist of enemies.
        enemyList = new ArrayList<Enemy>();
        for(int i = 0; i < numOfEnemies; i++) {
          enemyList.add(new Enemy(enemyX, enemyY, tileSize, tileSize, enemySpeed));
          enemyX = rand.nextInt(screenWidth - tileSize);
          enemyY = rand.nextInt(screenHeight - tileSize);
        }

        //Creates an arraylist of advanced enemies. 
        advancedEnemyList = new ArrayList<AdvancedEnemy>();
        for(int i = 0; i < numOfAdvancedEnemies; i++) {
            advancedEnemyList.add(new AdvancedEnemy(advancedEnemyX, advancedEnemyY, tileSize, tileSize, advancedEnemySpeed));
            advancedEnemyX = rand.nextInt(screenWidth - tileSize);
            advancedEnemyY = rand.nextInt(screenHeight - tileSize);
        }

        //Creates an arraylist of balls.
        orbList = new ArrayList<Projectiles>();

            for (int i = 0; i < projectileCount; i++){
                orbList.add(new Projectiles(projectileX, projectileY, projectileWidth, projectileHeight, projectileSpeed));
                System.out.println(projectileCount);
            }

        player = new Player(playerX, playerY, tileSize, playerSpeed, angle, keyH, mouseMove);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start(); 
    }

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

    public void update() {
        player.move();
        
        for (int i = 0; i < projectileCount; i++){
            orbList.get(i).move();
        }

        //Moves each advanced enemy in the array list. 
        for (int i = 0; i < numOfAdvancedEnemies; i++){
            advancedEnemyList.get(i).move(player);
        }

        //Moves each enemy in the array list. 
        for (int i = 0; i < numOfEnemies; i++){
            enemyList.get(i).move();
        }
    }

    //Standard method to draw things on JPanel
    @Override
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        for (int i = 0; i < projectileCount; i++){
            orbList.get(i).draw(g2d);
        }

        //Draws each advanced enemy in the array list.
        for (int i = 0; i < numOfAdvancedEnemies; i++){
            advancedEnemyList.get(i).draw(g2d);
        }

        //Draws each enemy in the array list.
        for (int i = 0; i < numOfEnemies; i++){
            enemyList.get(i).draw(g2d);
        }

        player.draw(g2d);
        g2d.dispose();
    }
} 