package object;

import java.io.IOException;
import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class OBJ_Heart extends Entity{
    
    public OBJ_Heart(GamePanel gp){
        super(gp);
        
        name = "HP";
        
        image = setup("/objects/full_heart");
        image2 = setup("/objects/Half_heart");
        image3 = setup("/objects/Empty_heart");
        
        
        
    }
}