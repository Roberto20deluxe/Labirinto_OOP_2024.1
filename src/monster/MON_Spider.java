package monster;

import java.awt.Rectangle;
import java.util.Random;

import entity.Entity;
import main.GamePanel;

public class MON_Spider extends Entity {

    public MON_Spider(GamePanel gp) {
        super(gp);

        name = "Spider";
        speed = 2;
        maxLife = 4;
        life = maxLife;

        hitBox = new Rectangle();
        hitBox.x = 8;
        hitBox.y = 6;
        hitBox.width = 32;
        hitBox.height = 42;
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
        super.update(); // Call the parent class update method

        int directionChangeSpeed = 100;
        if (actionLockCounter >= directionChangeSpeed) {
            Random random = new Random();
            int i = random.nextInt(100) + 1; // pick a number from 1 to 100

            if (i <= 25) {
                direction = "up";
            }
            if (i > 25 && i <= 50) {
                direction = "down";
            }
            if (i > 50 && i <= 75) {
                direction = "left";
            }
            if (i > 75 && i <= 100){
                direction = "right";
            }

            actionLockCounter = 0;
        }

    }
}
