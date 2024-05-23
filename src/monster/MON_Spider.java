package monster;

import java.awt.Rectangle;
import java.util.Random;

import entity.Entity;
import main.GamePanel;

public class MON_Spider extends Entity {

    public MON_Spider(GamePanel gp) {
        super(gp);

        name = "Spider";
        speed = 1;
        maxLife = 4;
        life = maxLife;
        
        
        hitBox = new Rectangle();
        hitBox.x = 8;
        hitBox.x = 16;
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

    @Override
    public void update() {
        super.update(); // Call the parent class update method

 
        if (actionLockCounter >= 120) {
            Random random = new Random();
            int i = random.nextInt(100) + 1; // pick a number from 1 to 100

            if (i <= 25) {
                direction = "up";
            } else if (i  <= 50) {
                direction = "down";
            } else if (i <= 75) {
                direction = "left";
            } else {
                direction = "right";
            }

            actionLockCounter = 0;
        }

        actionLockCounter++; 
    }
}
