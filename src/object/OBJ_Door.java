package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Door extends SuperObject {
public OBJ_Door() {
		
		name = "door";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/doorTile.png"));
		}catch(IOException e) {
			e.printStackTrace();
			
		}
		collision = true;
	}

}

