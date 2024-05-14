package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Chest extends SuperObject{
	
	public OBJ_Chest() {
		
		name = "chest";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/chestTile.png"));
		}catch(IOException e) {
			e.printStackTrace();
			
		}
	
	
	}
		
	

}

