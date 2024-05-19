package monster;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class MON_Spider extends Entity{

    public MON_Spider(GamePanel gp){
        super(gp);

        type=2;
        name="Spider"
        speed=2;
        maxLife=4;
        life=maxLife;

        hitBox = new Rectangle(); 
		hitBox.x = 8;
		hitBox.y = 16;
		hitBox.width = 32;
		hitBox.height = 32;

    }

    public void getImage(){
        try {
			
			up1 = ImageIO.read(new File("res/monster/spider/spider1up.png"));
			up2 = ImageIO.read(new File("res/monster/spider/spider2up.png"));
			left1 = ImageIO.read(new File("res/monster/spider/spider1left.png"));
			left2 = ImageIO.read(new File("res/monster/spider/spider2left.png"));
			down1 = ImageIO.read(new File("res/monster/spider/spider1down.png"));
			down2 = ImageIO.read(new File("res/monster/spider/spider2down.png"));
			right1 = ImageIO.read(new File("res/monster/spider/spider1right.png"));
			right2 = ImageIO.read(new File("res/monster/spider/spider2right.png"));
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
    }

    public void setAction(){
        actionLockCounter++;

        if(actionLockCounter==120){
            Random random =new Random();
            int i=random.nextInt(100)+1; //pick a number from  1 to 100

            if(i<=25){
                direction="up";
            }
            else if(i<=50){
                direction="down";
            }
            else if(i<=75){
                direction="left";
            }
            else{
                direction="right";
            }

            actionLockCounter=0;
        }
    }

}
