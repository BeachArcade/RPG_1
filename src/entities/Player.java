package entities;

import entities.Entity;
import game.GamePanel;
import game.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {
    Rectangle hitBox = new Rectangle();
    String name;
    int hp;
    int accuracy;
    int inRoom = 0;
    GamePanel gamePanel;
    KeyHandler keyHandler;
    public final int screenX;
    public final int screenY;
    public int xMovement;
    public int yMovement;

    public Player(GamePanel gamePanel, KeyHandler keyHandler){
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;

        screenX = (gamePanel.SCREEN_WIDTH/2) - (gamePanel.TILE_SIZE/2);
        screenY = (gamePanel.SCREEN_HEIGHT/2) - (gamePanel.TILE_SIZE/2);

        solidBody = new Rectangle();
        solidBody.x = (int)(gamePanel.TILE_SIZE * .25) + gamePanel.TILE_SIZE/2; // quarter of player
        solidBody.y = (int)(gamePanel.TILE_SIZE * .5) - gamePanel.TILE_SIZE/2; // half of player
        solidBody.height = (int)(gamePanel.TILE_SIZE * .8); // 60% size
        solidBody.width = (int)(gamePanel.TILE_SIZE * .3); // 60% size

        setDefaultValues();

    }
    public void setDefaultValues(){
        worldX = gamePanel.TILE_SIZE * 5;
        worldY = gamePanel.TILE_SIZE * 3;

        speed = 4;
        direction = "down";

        xMovement = 0;
        yMovement = 0;

        getPlayerImage();
    }
    public void update(){
        hitBox.height = (int)solidBody.getHeight();
        hitBox.width = (int)solidBody.getWidth();

        // set direction
        if(keyHandler.downPress || keyHandler.upPress || keyHandler.rightPress || keyHandler.leftPress){
            if(keyHandler.upPress)
                direction = "up";
            if(keyHandler.downPress)
                direction = "down";
            if(keyHandler.leftPress)
                direction = "left";
            if(keyHandler.rightPress)
                direction = "right";
            // check collision
            collisonOn = false;
            gamePanel.collisionCheck.checkTile(this);
            if(!collisonOn){
                switch (direction){
                    case "up" -> {
                        worldY -= speed;
                        yMovement += speed;
                    }
                    case "down" -> {
                        worldY += speed;
                        yMovement -= speed;
                    }
                    case "left" -> {
                        worldX -= speed;
                        xMovement += speed;
                    }
                    case "right" -> {
                        worldX += speed;
                        xMovement -= speed;
                    }
                }
            }

            // Change sprite costume
            spriteCounter++;
            if(spriteCounter > 12){
                if(spriteNum == 1){
                    spriteNum = 2;
                } else if(spriteNum == 2 ){
                    spriteNum = 1;
                }
                spriteCounter = 0;

            }
            hitBox.x = screenX + gamePanel.TILE_SIZE/3;
            hitBox.y = screenY + gamePanel.TILE_SIZE/5;
        }
    }
    public void getPlayerImage(){
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/up1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/up2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/down1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/down2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/left2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/right2.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g){
//        g.setColor(Color.decode("#ECCAD6"));
//        g.fillRect(x,y,gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);

        BufferedImage image = switch (direction) {
            case "up" -> spriteNum == 1 ? up1 : up2;
            case "down" -> spriteNum == 1 ? down1 : down2;
            case "left" -> spriteNum == 1 ? left1 : left2;
            case "right" -> spriteNum == 1 ? right1 : right2;
            default -> null;
        };
        g.drawImage(image, screenX, screenY, gamePanel.TILE_SIZE, gamePanel.TILE_SIZE, null);
        g.draw(hitBox);
        g.draw(solidBody);
    }
}
