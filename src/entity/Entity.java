package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;

public class Entity {
	
	public int worldX, worldY;
	public int speed;
	
	public BufferedImage up1, up2, down1, down2, right1, right2, left1, left2;
	public String direction;
	public int spriteCounter = 0;
	public int spriteNum = 1;
	public Rectangle hitBox;
	public boolean collisionOn = false;
	
	public boolean invincible=false;
	public int invincibleCounter=0;

	public int type; //0=player, 2=monster

	public int maxLife;
	public int life;

	public void update(){
		
		gp.cChecker.checkEntity(this, gp.monster);

		boolean contactPlayer=gp.cChecker.checkPlayer(this)
		
		if(this.type==2 && contactPlayer){
			if(!gp.player.invincible){
				gp.player.life-=1;
				gp.player.invincible=true;
			}
		}

	}

}
