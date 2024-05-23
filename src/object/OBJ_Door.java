package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class OBJ_Door extends Entity {

	
	public OBJ_Door(GamePanel gp) {
		super(gp);
		name = "door";
		down1 = setup("/objects/doorTile");
		collision = true;
		
		hitBox.x = 0;
		hitBox.y = 16;
		hitBox.width = 48;
		hitBox.height = 32;
		hitBoxDefaultX = hitBox.x;
		hitBoxDefaultY = hitBox.y;
	}

}

