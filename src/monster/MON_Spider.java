package monster;

import java.util.Random;
import java.awt.Rectangle;

import entity.Entity;
import main.GamePanel;

public class MON_Spider extends Entity {

    public MON_Spider(GamePanel gp) {
        super(gp);
        
        type = 2;
        name = "Spider";
        speed = 2;
        maxLife = 4;
        life = maxLife;

        hitBox = new Rectangle(8, 6, 32, 42);
        hitBoxDefaultX = hitBox.x;
        hitBoxDefaultY = hitBox.y;

        getImage();
    }

    public void getImage() {
        up1 = setup("/monster/spider1up");
        up2 = setup("/monster/spider2up");
        down1 = setup("/monster/spider1down");
        down2 = setup("/monster/spider2down");
        left1 = setup("/monster/spider1left");
        left2 = setup("/monster/spider2left");
        right1 = setup("/monster/spider1right");
        right2 = setup("/monster/spider2right");
    }

    public void setAction() {
        actionLockCounter++;

        int directionChangeSpeed = 100;
        if (actionLockCounter >= directionChangeSpeed) {
            Random random = new Random();
            int i = random.nextInt(100) + 1;

            if (i <= 25) {
                direction = "up";
            } else if (i <= 50) {
                direction = "down";
            } else if (i <= 75) {
                direction = "left";
            } else if (i <= 100) {
                direction = "right";
            }

            actionLockCounter = 0;
        }
    }

    @Override
    public void update() {
        setAction(); 

        
        switch (direction) {
            case "up":
                worldY -= speed;
                break;
            case "down":
                worldY += speed;
                break;
            case "left":
                worldX -= speed;
                break;
            case "right":
                worldX += speed;
                break;
        }

        
        hitBox.x = worldX + hitBoxDefaultX;
        hitBox.y = worldY + hitBoxDefaultY;

       
        gp.cChecker.checkPlayer(this);
        gp.cChecker.checkObject(this, collision);
        
        spriteCounter++;
        if (spriteCounter > 12) {
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
    }
}
