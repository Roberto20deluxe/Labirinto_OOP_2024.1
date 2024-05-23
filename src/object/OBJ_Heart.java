package object;

import java.io.IOException;
import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class OBJ_Heart extends Entity{
    
    public OBJ_Heart(GamePanel gp){
        super(gp);
        
        name = "HP";
<<<<<<< HEAD
        
        image = setup("/objects/full_heart");
        image2 = setup("/objects/Half_heart");
        image3 = setup("/objects/Empty_heart");
        
        
        
=======
        try {
        	image = ImageIO.read(getClass().getResourceAsStream("/objects/full_heart.png"));
        	image2 = ImageIO.read(getClass().getResourceAsStream("/objects/Half_heart.png"));
        	image3 = ImageIO.read(getClass().getResourceAsStream("/objects/Empty_heart.png"));
        	/*image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        	image2 = uTool.scaleImage(image2, gp.tileSize, gp.tileSize);
        	image3 = uTool.scaleImage(image3, gp.tileSize, gp.tileSize);*/
        }catch(IOException e) {
        	e.printStackTrace();
        }
>>>>>>> 75e8e2f098e51d9d65d799b9506c035d52ef88a8
    }
}