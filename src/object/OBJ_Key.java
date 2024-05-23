package object;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;



public class OBJ_Key extends Entity {
	
	public OBJ_Key(GamePanel gp) {
		super(gp);
		
		
		name = "key";
		down1 = setup("/objects/keyTile");
		
		}
	}

