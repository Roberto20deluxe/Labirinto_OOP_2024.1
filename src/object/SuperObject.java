package object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class SuperObject {
	
<<<<<<< HEAD
	public BufferedImage image;
=======
	public boolean collision = false;
	public BufferedImage image, image2, image3;
>>>>>>> 0642ec38f32e19ca80f1576233cefe1292bf5c23
	public String name;
	public boolean collision = false;
	public int worldX, worldY;
	public Rectangle hitBox = new Rectangle(0, 0, 48, 48);
	public int hitBoxDefaultX = 0;
	public int hitBoxDefaultY = 0;
	
	public void draw(Graphics2D g2, GamePanel gp) {
		
		int screenX = worldX - gp.player.worldX + gp.player.screenX;
		int screenY = worldY - gp.player.worldY + gp.player.screenY;
		
		if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX && 
		   worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
		   worldY + gp.tileSize > gp.player.worldY - gp.player.screenY && 
		   worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
			
			g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
		}
		
	}
}
