package main;

import entity.Entity;
import entity.Player;

public class CollisionChecker {

    GamePanel gp;

    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }

    public void checkTile(Entity entity) {
        int entityLeftWorldX = entity.worldX + entity.hitBox.x;
        int entityRightWorldX = entity.worldX + entity.hitBox.x + entity.hitBox.width;
        int entityTopWorldY = entity.worldY + entity.hitBox.y;
        int entityBottomWorldY = entity.worldY + entity.hitBox.y + entity.hitBox.height;

        int entityLeftCol = entityLeftWorldX / gp.tileSize;
        int entityRightCol = entityRightWorldX / gp.tileSize;
        int entityTopRow = entityTopWorldY / gp.tileSize;
        int entityBottomRow = entityBottomWorldY / gp.tileSize;

        int tileNum1, tileNum2;

        switch (entity.direction) {
            case "up":
                entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                break;
            case "left":
                entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                break;
            case "down":
                entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                break;
            case "right":
                entityRightCol = (entityRightWorldX + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                break;
        }
    }

    public int checkObject(Entity entity, boolean player) {
        int index = 999;

        for (int i = 0; i < gp.obj.length; i++) {
            if (gp.obj[i] != null) {

                // Get entity's hitbox position
                entity.hitBox.x = entity.worldX + entity.hitBoxDefaultX;
                entity.hitBox.y = entity.worldY + entity.hitBoxDefaultY;
                // Get object hitbox position
                gp.obj[i].hitBox.x = gp.obj[i].worldX + gp.obj[i].hitBoxDefaultX;
                gp.obj[i].hitBox.y = gp.obj[i].worldY + gp.obj[i].hitBoxDefaultY;

                switch (entity.direction) {
                    case "up":
                        entity.hitBox.y -= entity.speed; break;
                    case "left":
                        entity.hitBox.x -= entity.speed; break;
                    case "down":
                        entity.hitBox.y += entity.speed; break;
                    case "right":
                        entity.hitBox.x += entity.speed; break;
                }
                if (entity.hitBox.intersects(gp.obj[i].hitBox)) {
                    entity.collisionOn = true;
                    index = i;
                }
                // Reset hitBox coordinates
                entity.hitBox.x = entity.hitBoxDefaultX;
                entity.hitBox.y = entity.hitBoxDefaultY;
                gp.obj[i].hitBox.x = gp.obj[i].hitBoxDefaultX;
                gp.obj[i].hitBox.y = gp.obj[i].hitBoxDefaultY;
            }
        }
        return index;
    }

    public int checkEntity(Entity entity, Entity[] target) {
        int index = 999;

        for (int i = 0; i < target.length; i++) {
            if (target[i] != null && target[i] != entity) {
                // Get entity's hitbox position
                entity.hitBox.x = entity.worldX + entity.hitBoxDefaultX;
                entity.hitBox.y = entity.worldY + entity.hitBoxDefaultY;
                // Get target entity hitbox position
                target[i].hitBox.x = target[i].worldX + target[i].hitBoxDefaultX;
                target[i].hitBox.y = target[i].worldY + target[i].hitBoxDefaultY;

                switch (entity.direction) {
                    case "up":
                        entity.hitBox.y -= entity.speed; break;
                    case "left":
                        entity.hitBox.x -= entity.speed; break;
                    case "down":
                        entity.hitBox.y += entity.speed; break;
                    case "right":
                        entity.hitBox.x += entity.speed; break;
                }

                if (entity.hitBox.intersects(target[i].hitBox)) {
                    entity.collisionOn = true;
                    index = i;
                }

                // Reset hitBox coordinates
                entity.hitBox.x = entity.hitBoxDefaultX;
                entity.hitBox.y = entity.hitBoxDefaultY;
                target[i].hitBox.x = target[i].hitBoxDefaultX;
                target[i].hitBox.y = target[i].hitBoxDefaultY;
            }
        }

        return index;
    }

    public boolean checkPlayer(Entity entity) {
        boolean contactPlayer = false;

        if (entity.hitBox.intersects(gp.player.hitBox)) {
            entity.collisionOn = true;
            contactPlayer = true;
        }

        return contactPlayer;
    }
}
