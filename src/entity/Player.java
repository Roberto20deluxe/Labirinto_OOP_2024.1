package entity;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;
import main.KeyHandler;




public class Player extends Entity {
	
	KeyHandler keyH;
	
	public final int screenX;
	public final int screenY;
	public int openChest = 0;
	public int hasKey = 0;

	
	public Player(GamePanel gp, KeyHandler keyH) {
		
		super(gp);
		this.gp = gp;
		this.keyH = keyH;
		
		screenX = gp.screenWidth/2 - (gp.tileSize/2);
		screenY = gp.screenHeight/2 - (gp.tileSize/2);
		
		
		
		hitBox = new Rectangle(); 
		hitBox.x = 8;
		hitBox.y = 16;
		hitBoxDefaultX = hitBox.x;
		hitBoxDefaultY = hitBox.y;
		hitBox.width = 32;
		hitBox.height = 32;
		
		
		defaultValues();
		getPlayerImage();
	}
	public void defaultValues() {
		
		worldX = gp.tileSize*70;
		worldY = gp.tileSize*71;
		speed = 2;
		direction = "down";
		
		// STATUS DO JOGADOR
		maxLife = 6+1;
		life = maxLife;
		
	}
	
	public void getPlayerImage() {
	
		
		up1 = setup("/player/Sprite up");
		up2 = setup("/player/Sprite up 2");
		left1 = setup("/player/new_left_1");
		left2 = setup("/player/new_left_2");
		down1 = setup("/player/Sprite down (1)");
		down2 = setup("/player/Sprite down (2)");
		right1 = setup("/player/new_right_1");
		right2 = setup("/player/new_right_2");
		
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
			
			// Checar colisão objeto
			int objIndex = gp.cChecker.checkObject(this, true);
			pickUpObject(objIndex);
						
			
			
			//checar colisao do monster
			int monsterIndex=gp.cChecker.checkEntity(this, gp.monster);
			contactMonster(monsterIndex);
			
			
			
			// CHECAR EVENTO
			gp.eHandler.checkEvent();
			
			
			
			
			// CHECAR EVENTO
			gp.eHandler.checkEvent();
			
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
		
		if(invincible){
			invincibleCounter++;
			if(invincibleCounter>6000){
				invincible=false;
				invincibleCounter=0;
			}
		}
		
	}
	
	boolean isAtCenterOfTile(int x, int y, int tileSize) {
	    int tileCenterX = (x / tileSize) * tileSize + tileSize / 2;
	    int tileCenterY = (y / tileSize) * tileSize + tileSize / 2;
	    return Math.abs(x + hitBox.width / 2 - tileCenterX) < speed && Math.abs(y + hitBox.height / 2 - tileCenterY) < speed;
    }

	
	public void pickUpObject(int i) {
		
		if(i != 999) {
			
			String objectName = gp.obj[i].name;
			
			
			switch(objectName) {
			
			case"key":
				hasKey++;
				gp.obj[i] = null;
				gp.ui.currentDialogue = "You got a key!";
				gp.gameState = gp.dialogueState;
				break;
			
			case "chest":
				openChest++;
				gp.obj[i] = null;
				gp.ui.currentDialogue = "You have oppened a chest!";
				gp.gameState = gp.dialogueState;
				break;
			
			case "door":
				if(hasKey > 0) {
					gp.obj[i] = null;
					hasKey--;
					gp.ui.currentDialogue = "Door unlocked";
					gp.gameState = gp.dialogueState;
				}else {
					gp.ui.currentDialogue = "You need a key";
					gp.gameState = gp.dialogueState;
				}
					break;
				
			case "speedChest":
				speed = (int) (speed*1.5);
				gp.obj[i] = null;
				gp.ui.currentDialogue = "Speed Chest Opened!";
				gp.gameState = gp.dialogueState;
				break;  
			
			case"trap":
			    gp.ui.currentDialogue = "You stepped on a spike!";
				gp.gameState = gp.dialogueState;
				gp.player.life--;
				break;  
				
			}
		}
		
	}
	
	
	public void contactMonster(int i){
		if(i!=999){
			if(!invincible){
				life--;
				invincible=true;
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
		
		/*if(invincible){
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
		}*/
		
		g2.drawImage(image, screenX, screenY, null);
		
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
	
	}
}

		
	
	