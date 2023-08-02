package game;

import obj.Chest;
import obj.Door;
import obj.Key;
import obj.SuperObject;

// Sets objects in the game using an array!
//? Note: might switch to array list if object limit should be unbound
public class AssetSetter {
    public GamePanel gamePanel;
    public AssetSetter(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }
    public void setObject(){
        gamePanel.objectContainer[0] = new Key();
        gamePanel.objectContainer[0].worldX = 4 * gamePanel.TILE_SIZE;
        gamePanel.objectContainer[0].worldY = 4 * gamePanel.TILE_SIZE;

        gamePanel.objectContainer[1] = new Chest();
        gamePanel.objectContainer[1].worldX = 2 * gamePanel.TILE_SIZE;
        gamePanel.objectContainer[1].worldY = 2 * gamePanel.TILE_SIZE;

        gamePanel.objectContainer[2] = new Door();
        gamePanel.objectContainer[2].worldX = 6 * gamePanel.TILE_SIZE;
        gamePanel.objectContainer[2].worldY = 6 * gamePanel.TILE_SIZE;

        gamePanel.objectContainer[3] = new Door();
        gamePanel.objectContainer[3].worldX = 17 * gamePanel.TILE_SIZE;
        gamePanel.objectContainer[3].worldY = 3 * gamePanel.TILE_SIZE;

        // set solid bodies last
        loadSolidBodies();
    }
    private void loadSolidBodies(){
        for(SuperObject o : gamePanel.objectContainer){
            if(o != null){
                o.setSolidBody();
            }
        }
    }
}
