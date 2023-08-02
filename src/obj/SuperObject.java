package obj;

import game.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperObject {
    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;
    public Rectangle solidBody = new Rectangle(0,0,32,32);
    public int solidBodyDefaultX = 0;
    public  int solidBodyDefaultY = 0;

    public void setSolidBody(){
        solidBodyDefaultX = worldX;
        solidBodyDefaultY = worldY;
        solidBody.x = worldX;
        solidBody.y = worldY;
    }
    public void draw(Graphics2D g, GamePanel gamePanel){
        // Find screen position
        int screenX = worldX - gamePanel.player.worldX + gamePanel.player.screenX;
        int screenY = worldY - gamePanel.player.worldY + gamePanel.player.screenY;

        // Draw if in screen bounds
        if (   worldX > (gamePanel.player.worldX - gamePanel.TILE_SIZE) - gamePanel.player.screenX
                && worldX < (gamePanel.player.worldX + gamePanel.TILE_SIZE) + gamePanel.player.screenX
                && worldY > (gamePanel.player.worldY - gamePanel.TILE_SIZE) - gamePanel.player.screenX
                && worldY < (gamePanel.player.worldY + gamePanel.TILE_SIZE) + gamePanel.player.screenY ) {
            g.drawImage(image, screenX, screenY, gamePanel.TILE_SIZE, gamePanel.TILE_SIZE, null);
        }
    }
}
