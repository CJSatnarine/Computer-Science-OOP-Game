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
    Enemy enemy;
    Thread gameThread;
    Random rand = new Random();
    double mouseX = mouseMove.returnX();
    double mouseY = mouseMove.returnY();

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
        //angle = 0;
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true); //If set to true, all the drawings from this component will be done in an offscreen painting buffer. Enabling this can improve the game's rendering performance.
        this.addMouseListener(mouseMove);
        this.addMouseMotionListener(mouseMove);
        this.addKeyListener(keyH);

        this.setFocusable(true);

        player = new Player(playerX, playerY, tileSize, playerSpeed, angle, keyH, mouseMove);
        enemy = new Enemy(enemyX, enemyY, tileSize, tileSize, enemySpeed);

        
        System.out.println(angle);
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


        player.drawPlayer(g2d);
        enemy.drawSlug(g2d, 7);
        g2d.dispose();
    }
}
