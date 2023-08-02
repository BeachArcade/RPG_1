package tiles;

import game.GamePanel;
import tiles.Tile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

// Manages the drawing of tiles
public class TileManager {
    // fields
    GamePanel gamePanel;
    public ArrayList<ArrayList<Tile>> tileMap;
    int xOffset;
    int yOffset;

   // constructor
    public TileManager(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        tileMap = makeMap("map05");
        //MapManager m = new MapManager();
        //tileMap = m.makeRandom(30,30);
        xOffset = 0;
        yOffset = 0;

    }

    // Makes a map
    public ArrayList<ArrayList<Tile>> makeMap(String mapName) {
        // 2d ArrayList
        ArrayList<ArrayList<Tile>> tileMap = new ArrayList<>();
        ArrayList<String[]> textMap = new ArrayList<>();

        // Set height
        int height = 0;

        // Create scanner
        InputStream is =
                getClass().getResourceAsStream("/maps/" + mapName + ".txt");
        Scanner sc = new Scanner(is);

        // Read map and create an array
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            height++;
           // System.out.println(height + ":\t" + line);
            textMap.add(line.split(" "));
        }
        // Parse all strings and add them to ArrayList
        for (String[] line : textMap) {
            ArrayList<Tile> mapRow = new ArrayList<>();
          for (String id : line) {
              mapRow.add(new Tile(Integer.parseInt(id)));
            System.out.print(id + " ");
          }
          System.out.println();
          tileMap.add(mapRow);
        }
        return tileMap;
    }

    // Draws all seen tiles
    public void draw(Graphics2D g){
        // map size
        int xBound = Math.min(gamePanel.WORLD_ROW, tileMap.get(0).size());
        int yBound = Math.min(gamePanel.WORLD_COL, tileMap.size());

        // Loop to draw all seen tiles
        for (int worldRow = 0; worldRow < yBound; worldRow++) {
            for (int worldCol = 0; worldCol < xBound; worldCol++) {
                // initialize
                Tile tile = tileMap.get(worldRow).get(worldCol);
                int worldX = worldCol * gamePanel.TILE_SIZE;
                int worldY = worldRow * gamePanel.TILE_SIZE;
                int screenX = worldX - gamePanel.player.worldX  + gamePanel.player.screenX;
                int screenY = worldY - gamePanel.player.worldY + gamePanel.player.screenY;

                // draw if in bounds
                if (   worldX > (gamePanel.player.worldX - gamePanel.TILE_SIZE) - gamePanel.player.screenX
                    && worldX < (gamePanel.player.worldX + gamePanel.TILE_SIZE) + gamePanel.player.screenX
                    && worldY > (gamePanel.player.worldY - gamePanel.TILE_SIZE) - gamePanel.player.screenX
                    && worldY < (gamePanel.player.worldY + gamePanel.TILE_SIZE) + gamePanel.player.screenY ) {
                  g.drawImage(tile.image, screenX, screenY, gamePanel.TILE_SIZE, gamePanel.TILE_SIZE, null);
                }
            }
        }
    }
}

