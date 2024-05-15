package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Trap extends SuperObject {
	
public OBJ_Trap() {
		
		name = "trap";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/trapTile.png"));
		}catch(IOException e) {
			e.printStackTrace();
			
		}
	
	
	}

}
