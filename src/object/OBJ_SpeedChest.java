package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_SpeedChest extends SuperObject{
	
	public OBJ_SpeedChest() {
		
		name = "speedChest";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/SpeedChestTile.png.png"));
		}catch(IOException e) {
			e.printStackTrace();
			
		}
	
	
	}
		
	

}