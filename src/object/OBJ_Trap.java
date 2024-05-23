package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class OBJ_Trap extends Entity {
	
	
	public OBJ_Trap(GamePanel gp) {
			
		super(gp);
		
		name = "trap";
		down1 = setup("/objects/trapTile");
			
		
		
		}
	
	}
