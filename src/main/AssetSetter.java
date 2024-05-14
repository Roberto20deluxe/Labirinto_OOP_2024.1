package main;

import object.OBJ_Chest;

public class AssetSetter {
	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
		
		
	}
	
	public void setObject() {
		
		gp.obj[0] = new OBJ_Chest();
		gp.obj[0].worldX = 25 * gp.tileSize;
		gp.obj[0].worldY = 25 * gp.tileSize;
	}

}
