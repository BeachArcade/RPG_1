package entities;

import game.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
//TODO streamline image making by renaming everything to the same thing
public class NPC extends Entity{
    String name;
    String id;
    String desc;
    boolean isEquipable;
    String wearloc;
    GamePanel gamePanel;
    public NPC(GamePanel gamePanel){
        this.gamePanel = new GamePanel();
    }
    public void getImage(){
        try{
            down1 = ImageIO.read(getClass().getResourceAsStream("/duck/front.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/duck/front2.png"));
            up1 = ImageIO.read(getClass().getResourceAsStream("/duck/down1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/duck/down2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/duck/left.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/duck/left2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/duck/right.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/duck/right2.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g){
        BufferedImage image = switch (direction) {
            case "up" -> spriteNum == 1 ? up1 : up2;
            case "down" -> spriteNum == 1 ? down1 : down2;
            case "left" -> spriteNum == 1 ? left1 : left2;
            case "right" -> spriteNum == 1 ? right1 : right2;
            default -> null;
        };
        g.drawImage(image, screenX, screenY, gamePanel.TILE_SIZE, gamePanel.TILE_SIZE, null);
        g.draw(solidBody);
    }
}
