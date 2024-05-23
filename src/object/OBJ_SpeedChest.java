package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class OBJ_SpeedChest extends Entity{
	
	public OBJ_SpeedChest(GamePanel gp) {
		
		super(gp);
		name = "speedChest";
		down1 = setup("/objects/SpeedChestTile.png");
	
	
	}
		
	

}