package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {
	
	GamePanel gp;
	KeyHandler keyH;
	
	public Player(GamePanel gp, KeyHandler keyH) {
		
		this.gp = gp;
		this.keyH = keyH;
		
		defaultValues();
		getPlayerImage();
	}
	public void defaultValues() {
		
		x = 100;
		y = 100;
		speed = 4;
		direction = "down";
		
	}
	
	public void getPlayerImage() {
		
		try {
			
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/Sprite up.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/Sprite up 2.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/new_left_1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/new_left_2.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/Sprite down (1).png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/Sprite down (2).png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/new_right_1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/new_right_2.png"));
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		
		if(keyH.upPressed == true || keyH.leftPressed == true || keyH.downPressed == true || keyH.rightPressed == true) {
			
			
			
			if(keyH.upPressed == true) {
				direction = "up";
				y -= speed;
				
			}
			
			else if(keyH.leftPressed == true) {
				direction = "left";
				x -= speed;
			}
			
			else if(keyH.rightPressed == true) {
				direction = "right";
				x += speed;
			}
			
			else if(keyH.downPressed == true) {
				direction = "down";
				y += speed;
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
		g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
	
	}
}

		
	
	
