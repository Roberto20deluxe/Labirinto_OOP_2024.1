package object;

import java.io.IOException;

import javax.imageio.ImageIO;



public class OBJ_Key extends SuperObject {
	
	public OBJ_Key() {
		
		name = "key";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/keyTile.png"));
		}catch(IOException e) {
			e.printStackTrace();
			
		}
	
	
	}
		
	

}
