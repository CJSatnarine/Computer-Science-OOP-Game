package App;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

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

    private KeyHandler keyH = new KeyHandler();
    private MouseMovement mouseMove = new MouseMovement();
    private Player player;
    private Enemy enemy;
    private AdvancedEnemy advancedEnemy;
    private Thread gameThread;
    private Random rand = new Random();

    private double mouseX = mouseMove.returnMouseX();
    private double mouseY = mouseMove.returnMouseY();

    //Player's settings. 
    public int playerX = 20;
    public int playerY = 20;
    private int playerSpeed = 4;
    private double angle;

    //Enemy position and speed
    private int enemyX = screenWidth;
    private int enemyY = rand.nextInt(screenHeight - tileSize);
    private int enemySpeed = 2;

    //Advanced enemy position and speed
    private int advancedEnemyX = screenWidth;
    private int advancedEnemyY = rand.nextInt(screenHeight - tileSize);
    private int advancedEnemySpeed = 4;

    Panel() {
        angle = 0;
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true); //If set to true, all the drawings from this component will be done in an offscreen painting buffer. Enabling this can improve the game's rendering performance.
        this.addMouseListener(mouseMove);
        this.addMouseMotionListener(mouseMove);
        this.addKeyListener(keyH);

        this.setFocusable(true);

        player = new Player(playerX, playerY, tileSize, playerSpeed, angle, keyH, mouseMove);
        enemy = new Enemy(enemyX, enemyY, tileSize, tileSize, enemySpeed);
        advancedEnemy = new AdvancedEnemy(advancedEnemyX, advancedEnemyY, tileSize, tileSize, advancedEnemySpeed);

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
        enemy.move();
    }

    //Standard method to draw things on JPanel
    @Override
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        advancedEnemy.draw(g2d);
        enemy.draw(g2d, 1);
        player.draw(g2d);
        g2d.dispose();
    }
}