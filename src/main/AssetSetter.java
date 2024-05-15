package main;

import object.OBJ_Chest;
import object.OBJ_Door;
import object.OBJ_Key;
import object.OBJ_SpeedChest;
import object.OBJ_Trap;

public class AssetSetter {
	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
		
		
	}
	
	public void setObject() {
		
		gp.obj[0] = new OBJ_Chest();
		gp.obj[0].worldX = 6 * gp.tileSize;
		gp.obj[0].worldY = 6 * gp.tileSize;
		
		gp.obj[1] = new OBJ_Chest();
		gp.obj[1].worldX = 55 * gp.tileSize;
		gp.obj[1].worldY = 55 * gp.tileSize;
		
		gp.obj[2] = new OBJ_Chest();
		gp.obj[2].worldX = 122 * gp.tileSize;
		gp.obj[2].worldY = 122 * gp.tileSize;
		
		gp.obj[3] = new OBJ_Trap();
		gp.obj[3].worldX = 10 * gp.tileSize;
		gp.obj[3].worldY = 5 * gp.tileSize;
		
		gp.obj[4] = new OBJ_Door();
		gp.obj[4].worldX = 69 * gp.tileSize;
		gp.obj[4].worldY = 69 * gp.tileSize;
		
		gp.obj[5] = new OBJ_Key();
		gp.obj[5].worldX = 70 * gp.tileSize;
		gp.obj[5].worldY = 72 * gp.tileSize;
		
		gp.obj[6] = new OBJ_SpeedChest();
		gp.obj[6].worldX = 74 * gp.tileSize;
		gp.obj[6].worldY = 72 * gp.tileSize;
		
		
		
	}

}
