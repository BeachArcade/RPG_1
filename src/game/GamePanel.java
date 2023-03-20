package game;

import entities.Player;
import tiles.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GamePanel extends JPanel implements Runnable{
    int tile1x;
    int tile1y;
    int tile2y;
    int tile2x;
    BufferedImage red;

    // Screen settings
    public final int ORIGINAL_TILE_SIZE = 32;  // tiles.Tile set size 32x32
    public final int SCALE = 2;    // Scale by 2x
    public final int TILE_SIZE = ORIGINAL_TILE_SIZE * SCALE;
    public final int SCREEN_COL = 16; // max screen col
    public final int SCREEN_ROW = 12; // max screen row
    public final int SCREEN_HEIGHT = TILE_SIZE * SCREEN_ROW; // max screen size in px
    public final int SCREEN_WIDTH = TILE_SIZE * SCREEN_COL; // max screen width in px

    // fps
    public final int FPS = 60;
    public final Boolean showFPS = true;

    // World settings
    public final int WORLD_COL = 50; // max world col
    public final int WORLD_ROW = 50; // max world rows
    public final int WORLD_WIDTH = TILE_SIZE * WORLD_COL;
    public final int WORLD_HEIGHT = TILE_SIZE * WORLD_ROW;

    // Key components
    public KeyHandler keyHandler = new KeyHandler();
    public Thread gameThread;
    public Player player = new Player(this, keyHandler);
    public TileManager tileManager = new TileManager(this);
    public CollisionCheck collisionCheck = new CollisionCheck(this);

    public GamePanel(){
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
        try{
            red = ImageIO.read(getClass().getResourceAsStream("/player/box.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    // start
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

//    @Override
//    public void run() {
//        // Game Loop
//        double drawInterval = 1000000000/FPS; // draws every .0166 seconds
//        double nextDrawTime = System.nanoTime() + drawInterval;
//
//        while(gameThread != null){
//            // Step 1: Update information
//            update();
//            // Step 2: Draw screen with updated info
//            repaint();
//
//            double remainingTime = nextDrawTime - System.nanoTime();
//            try{
//                remainingTime = remainingTime / 1000000;
//                if(remainingTime < 0){
//                    remainingTime = 0;
//                }
//
//                Thread.sleep((long) remainingTime);
//
//            nextDrawTime += drawInterval;
//
//            } catch (InterruptedException e){
//                e.printStackTrace();
//            }
//        }
//    }

    // Game Loop
    @Override
    public void run() {
        // set vars
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        // loop the game
        while(gameThread != null){
            // set times
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            // when it's time to draw
            if (delta >= 1) {
                update();
                repaint();
                delta--;

                //Debug
                if (showFPS) {
                  drawCount++;
                }
            }
            // Debug
            if(timer >= 1000000000 && showFPS){
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }

    }

    public void update(){
        player.update();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        tileManager.draw(g2);
        player.draw(g2);
        g2.dispose();
    }
}
