package game;

import entities.Entity;
import tiles.Tile;

public class CollisionCheck {
    private GamePanel gamePanel;
    public CollisionCheck(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }
    public void checkTile(Entity entity){
        // entity body points in terms of pixel location
        int entityWorldLeftX = entity.worldX; //entity.solidBody.width;
        int entityWorldRightX = entity.worldX + entity.solidBody.width;
        int entityWorldTopY = entity.worldY;// - entity.solidBody.height;
        int entityWorldBottomY = entity.worldY + entity.solidBody.height;

        // entity body points in terms of row/col location
        int entityLeftCol = entityWorldLeftX/gamePanel.TILE_SIZE;
        int entityRightCol = entityWorldRightX/gamePanel.TILE_SIZE;
        int entityTopRow = entityWorldTopY/gamePanel.TILE_SIZE;
        int entityBottomRow = entityWorldBottomY/gamePanel.TILE_SIZE;

        // reference tiles
        Tile tile1 = null;
        Tile tile2 = null;

        // check direction, if reference blocks are solid set collision to true
//        switch (entity.direction){
//            case "up" -> {
//                entityTopRow = (entityWorldTopY - entity.speed)/gamePanel.TILE_SIZE;
//                tile1 = gamePanel.tileManager.tileMap.get(entityLeftCol).get(entityTopRow);
//                tile2 = gamePanel.tileManager.tileMap.get(entityRightCol).get(entityTopRow);
//                if(tile1.collison || tile2.collison)
//                    entity.collisonOn = true;
//            }
//            case "down" -> {
//                entityBottomRow = (entityWorldBottomY - entity.speed)/gamePanel.TILE_SIZE;
//                tile1 = gamePanel.tileManager.tileMap.get(entityLeftCol).get(entityBottomRow);
//                tile2 = gamePanel.tileManager.tileMap.get(entityRightCol).get(entityBottomRow);
//                if(tile1.collison || tile2.collison)
//                    entity.collisonOn = true;
//            }
//            case "left" -> {
//                entityLeftCol = (entityWorldLeftX - entity.speed)/gamePanel.TILE_SIZE;
//                tile1 = gamePanel.tileManager.tileMap.get(entityLeftCol).get(entityTopRow);
//                tile2 = gamePanel.tileManager.tileMap.get(entityLeftCol).get(entityBottomRow);
//                if(tile1.collison || tile2.collison)
//                    entity.collisonOn = true;
//            }
//            case "right" -> {
//                entityRightCol = (entityWorldRightX + entity.speed)/gamePanel.TILE_SIZE;
//                tile1 = gamePanel.tileManager.tileMap.get(entityRightCol).get(entityTopRow);
//                tile2 = gamePanel.tileManager.tileMap.get(entityRightCol).get(entityBottomRow);
//                if(tile1.collison || tile2.collison)
//                    entity.collisonOn = true;
//            }
//        }
        switch (entity.direction){
            case "up" -> {
                entityTopRow = (entityWorldTopY - entity.speed)/gamePanel.TILE_SIZE;
                tile1 = gamePanel.tileManager.tileMap.get(entityTopRow).get(entityLeftCol);
                tile2 = gamePanel.tileManager.tileMap.get(entityTopRow).get(entityRightCol);
                if(tile1.collison || tile2.collison)
                    entity.collisonOn = true;
            }
            case "down" -> {
                entityBottomRow = (entityWorldBottomY - entity.speed)/gamePanel.TILE_SIZE;
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
        if(entity.collisonOn){
            System.out.println(entityLeftCol + " " + entityTopRow + " " + entityRightCol + " " + entityBottomRow);
        }

    }
}
