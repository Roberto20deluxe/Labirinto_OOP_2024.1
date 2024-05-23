package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;

public class Entity {
	
	public int worldX, worldY;
	public int speed;
	GamePanel gp;
	public BufferedImage up1, up2, down1, down2, right1, right2, left1, left2;
	public String direction = "down";
	public int spriteCounter = 0;
	public int spriteNum = 1;
	public Rectangle hitBox = new Rectangle(0,0,48,48);
	public int hitBoxDefaultX, hitBoxDefaultY;
	public boolean collisionOn = false;
	public int actionLockCounter = 120;
	String dialogues[] = new String[20];
	int dialogueIndex = 0;
	public BufferedImage image, image2, image3;
	public String name;
	public boolean collision = false;
	
	public boolean invincible=false;
	public int invincibleCounter=0;
	
	//STATUS ENTIDADES
	public int maxLife;
	public int life;
	
	
	public Entity(GamePanel gp) {
		this.gp = gp;
	}
	
	public BufferedImage setup(String imagePath) {
	    UtilityTool uTool = new UtilityTool();
	    BufferedImage image = null;
	    try {
	        File file = new File(imagePath);
	        if (!file.exists()) {
	            String absolutePath = "res/" + imagePath + ".png";
	            file = new File(absolutePath);
	            if (!file.exists()) {
	                throw new IOException("File not found: " + imagePath);
	            }
	        }
	        image = ImageIO.read(file);
	        image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return image;
	}

	
	private void setAction() {}
	
	public void update() {
	    
	    
	    collisionOn = false; 
	    
	    gp.cChecker.checkTile(this);
	    gp.cChecker.checkObject(this, false);
	    gp.cChecker.checkEntity(this, gp.monster);
	    gp.cChecker.checkPlayer(this);

	    if (!collisionOn) { 

	        switch (direction) {
	            case "up": worldY -= speed; break;
	            case "down": worldY += speed; break;
	            case "left": worldX -= speed; break;
	            case "right": worldX += speed; break;
	        }
	    }

	   
	    spriteCounter++;
	    if (spriteCounter == 1) {
	        spriteNum = 2;
	    } else if (spriteCounter == 2) {
	        spriteNum = 1;
	        spriteCounter = 0;
	    }
	}

	
	

	public void draw(Graphics2D g2) {

	    BufferedImage image = null;
	    int screenX = worldX - gp.player.worldX + gp.player.screenX;
	    int screenY = worldY - gp.player.worldY + gp.player.screenY;

	    if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
	        worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
	        worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
	        worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {

	        switch (direction) {
	            case "up":
	                if (spriteNum == 1) {
	                    image = up1;
	                } else if (spriteNum == 2) {
	                    image = up2;
	                }
	                break;

	            case "down":
	                if (spriteNum == 1) {
	                    image = down1;
	                } else if (spriteNum == 2) {
	                    image = down2;
	                }
	                break;

	            case "left":
	                if (spriteNum == 1) {
	                    image = left1;
	                } else if (spriteNum == 2) {
	                    image = left2;
	                }
	                break;

	            case "right":
	                if (spriteNum == 1) {
	                    image = right1;
	                } else if (spriteNum == 2) {
	                    image = right2;
	                }
	                break;
	        }
	    }

	    if (image != null) {
	        g2.drawImage(image, screenX, screenY, null);
	    }
	}
	

}
