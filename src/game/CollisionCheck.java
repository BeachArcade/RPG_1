package game;

import entities.Entity;
import obj.SuperObject;
import tiles.Tile;
public class CollisionCheck {
    private GamePanel gamePanel;
    public CollisionCheck(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }
    // Check for tile collision
    public void checkTile(Entity entity){
        // entity body points in terms of pixel location
        int entityWorldLeftX = entity.worldX + entity.solidBody.width; //entity.solidBody.width;
        int entityWorldRightX = entity.worldX + 2 * entity.solidBody.width;
        int entityWorldTopY = entity.worldY;// - entity.solidBody.height;
        int entityWorldBottomY = entity.worldY + gamePanel.TILE_SIZE;

        // entity body points in terms of row/col location
        int entityLeftCol = entityWorldLeftX/gamePanel.TILE_SIZE;
        int entityRightCol = entityWorldRightX/gamePanel.TILE_SIZE;
        int entityTopRow = entityWorldTopY/gamePanel.TILE_SIZE;
        int entityBottomRow = entityWorldBottomY/gamePanel.TILE_SIZE;

        // reference tiles
        Tile tile1 = null;
        Tile tile2 = null;

        /* check direction, if reference blocks are solid set collision to true
            reference tiles are on location + playerSpeed
         */
        switch (entity.direction){
            case "up" -> {
                entityTopRow = (entityWorldTopY - entity.speed)/gamePanel.TILE_SIZE;
                tile1 = gamePanel.tileManager.tileMap.get(entityTopRow).get(entityLeftCol);
                tile2 = gamePanel.tileManager.tileMap.get(entityTopRow).get(entityRightCol);
                if(tile1.collison || tile2.collison)
                    entity.collisonOn = true;
            }
            case "down" -> {
                entityBottomRow = (entityWorldBottomY + entity.speed)/gamePanel.TILE_SIZE;
                tile1 = gamePanel.tileManager.tileMap.get(entityBottomRow).get(entityLeftCol);
                tile2 = gamePanel.tileManager.tileMap.get(entityBottomRow).get(entityRightCol);
                if(tile1.collison || tile2.collison)
                    entity.collisonOn = true;
            }
            case "left" -> {
                entityLeftCol = (entityWorldLeftX - entity.speed)/gamePanel.TILE_SIZE;
                tile1 = gamePanel.tileManager.tileMap.get(entityTopRow).get(entityLeftCol);
                tile2 = gamePanel.tileManager.tileMap.get(entityBottomRow).get(entityLeftCol);
                if(tile1.collison || tile2.collison)
                    entity.collisonOn = true;
            }
            case "right" -> {
                entityRightCol = (entityWorldRightX + entity.speed)/gamePanel.TILE_SIZE;
                tile1 = gamePanel.tileManager.tileMap.get(entityTopRow).get(entityRightCol);
                tile2 = gamePanel.tileManager.tileMap.get(entityBottomRow).get(entityRightCol);
                if(tile1.collison || tile2.collison)
                    entity.collisonOn = true;
            }
        }
    }
    // Check for objects
    public int checkObject(Entity entity, boolean player){
        int index = 999;
        for(int i = 0; i < gamePanel.objectContainer.length; i++){
            if(gamePanel.objectContainer[i] != null){
                // find entity solid body pos
                entity.solidBody.x += entity.worldX;
                entity.solidBody.y += entity.worldY;

                // get object solid body pos
                gamePanel.objectContainer[i].solidBody.x += gamePanel.objectContainer[i].worldX;
                gamePanel.objectContainer[i].solidBody.y += gamePanel.objectContainer[i].worldY;

                // account for direction
                switch (entity.direction){
                    case "up" ->{
                        entity.solidBody.y -= entity.speed;
                    }
                    case "down" ->{
                        entity.solidBody.y += entity.speed;
                    }
                    case "left" ->{
                        entity.solidBody.x -= entity.speed;
                    }
                    case "right" ->{
                        entity.solidBody.x += entity.speed;
                    }
                }
                // debug
                String debugEntityCollisionDetection = entity.direction;
                if(checkEntityCollison(gamePanel.objectContainer[i], entity))
                    System.out.println("<[" + debugEntityCollisionDetection + "] collision detected>");

                // reset positions
                entity.solidBody.x = entity.solidBodyDefaultX;
                entity.solidBody.y = entity.solidBodyDefaultY;
                gamePanel.objectContainer[i].solidBody.x = gamePanel.objectContainer[i].solidBodyDefaultX;
                gamePanel.objectContainer[i].solidBody.y = gamePanel.objectContainer[i].solidBodyDefaultY;
            }
        }
        return index;
    }
    // Checks if an entity is colliding with a solid tile
    private boolean checkEntityCollison(SuperObject o, Entity e){
        return e.solidBody.intersects(o.solidBody);
    }
}
