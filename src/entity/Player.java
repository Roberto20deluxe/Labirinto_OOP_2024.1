package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.KeyHandler;


public class Player extends Entity {
	
	GamePanel gp;
	KeyHandler keyH;
	
	public final int screenX;
	public final int screenY;
	
	public Player(GamePanel gp, KeyHandler keyH) {
		
		this.gp = gp;
		this.keyH = keyH;
		
		screenX = gp.screenWidth/2 - (gp.tileSize/2);
		screenY = gp.screenHeight/2 - (gp.tileSize/2);
		
		
		//Change hit box size depending on preference
		hitBox = new Rectangle(); 
		hitBox.x = 8;
		hitBox.y = 16;
		hitBox.width = 32;
		hitBox.height = 32;
		
		
		defaultValues();
		getPlayerImage();
	}
	public void defaultValues() {
		
		worldX = gp.tileSize*23;
		worldY = gp.tileSize*22;
		speed = 2;
		direction = "down";
		
	}
	
	public void getPlayerImage() {
		
		try {
			
			up1 = ImageIO.read(new File("res/player/Sprite up.png"));
			up2 = ImageIO.read(new File("res/player/Sprite up 2.png"));
			left1 = ImageIO.read(new File("res/player/new_left_1.png"));
			left2 = ImageIO.read(new File("res/player/new_left_2.png"));
			down1 = ImageIO.read(new File("res/player/Sprite down (1).png"));
			down2 = ImageIO.read(new File("res/player/Sprite down (2).png"));
			right1 = ImageIO.read(new File("res/player/new_right_1.png"));
			right2 = ImageIO.read(new File("res/player/new_right_2.png"));
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		
		if(keyH.upPressed == true || keyH.leftPressed == true || keyH.downPressed == true || keyH.rightPressed == true) {
			
			
			
			if(keyH.upPressed == true) {
				direction = "up";
				
				
			}
			
			else if(keyH.leftPressed == true) {
				direction = "left";
				
			}
			
			else if(keyH.rightPressed == true) {
				direction = "right";
				
			}
			
			else if(keyH.downPressed == true) {
				direction = "down";
				
			}
			
			//Checar colisão do tile
			collisionOn = false;
			gp.cChecker.checkTile(this);
			
			//Se colisão for falsa player pode se mover
			if(collisionOn == false) {
				
				switch(direction) {
				case "up":
					worldY -= speed;
					break;
				case "left":
					worldX -= speed;
					break;
				case "down":
					worldY += speed;
					break;
				case "right":
					worldX += speed;
					break;
				}
			}
			
			spriteCounter++;
			if (spriteCounter > 10) {
				if(spriteNum == 1) {
					spriteNum = 2;
				}
				else if(spriteNum == 2) {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}
			
		}
	}
	
	
	
	
	public void draw(Graphics2D g2){
		
		
		BufferedImage image = null;
		
		switch(direction) {
		case "up":
			if (spriteNum == 1) {
				image = up1;
			}
			if(spriteNum == 2) {
				image = up2;
			}
			break;
		case "left":
			if(spriteNum == 1) {
				image = left1;
			}
			if(spriteNum == 2) {
				image = left2;
			}
			break;
		case "right":
			if(spriteNum == 1) {
				image = right1;
			}
			if(spriteNum == 2) {
				image = right2;
			}
			break;
		case "down":
			if(spriteNum == 1) {
				image = down1;
			}
			if(spriteNum == 2) {
				image = down2;
			}
			break;
		
		
		}
		g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
	
	}
}

		
	
	