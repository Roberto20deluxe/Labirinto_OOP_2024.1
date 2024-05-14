package object;

import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;

public class OBJ_Heart extends SuperObject{
    GamePanel gp;
    
    public OBJ_Heart(GamePanel gp){
        this.gp = gp;

        name = "HP";
    }
}