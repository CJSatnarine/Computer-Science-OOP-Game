package App;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import java.util.Random;

public class Panel extends JPanel implements Runnable {

    //Screen settings.
    final int originalTileSize = 16;
    final int scale = 3;

    final int tileSize = originalTileSize * scale;

    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    //FPS
    int FPS = 60;

    KeyHandler keyH = new KeyHandler();
    MouseMovement mouseMove = new MouseMovement();
    Player player;
    Slug enemy;
    Thread gameThread;
    Random rand = new Random();
    double mouseX = mouseMove.getX(mouseMove);
    double mouseY = mouseMove.getY(mouseMove);

    //Player's settings. 
    int playerX = 20;
    int playerY = 20;
    int playerSpeed = 4;
    double angle = Math.atan2(mouseY - (playerY + tileSize / 2), mouseX - (playerX + tileSize / 2));

    //Enemy position and speed
    int enemyX = screenWidth;
    int enemyY = rand.nextInt(screenHeight - tileSize);
    int enemySpeed = 2;

    Panel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true); //If set to true, all the drawings from this component will be done in an offscreen painting buffer. Enabling this can improve the game's rendering performance.
        this.addMouseListener(mouseMove);
        this.addMouseMotionListener(mouseMove);
        this.addKeyListener(keyH);

        this.setFocusable(true);

        player = new Player(playerX, playerY, tileSize, playerSpeed, keyH, mouseMove);
        enemy = new Slug(enemyX, enemyY, tileSize, tileSize, enemySpeed);

        
        System.out.println(enemyY);
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
        Graphics2D playerGraphics = (Graphics2D) g;
        Graphics2D enemyGraphics = (Graphics2D) g;

        player.draw(playerGraphics);
        enemy.draw(enemyGraphics, 2);

        repaint();
    }
}
