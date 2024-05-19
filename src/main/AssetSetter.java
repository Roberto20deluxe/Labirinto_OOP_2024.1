package main;

import monster.MON_Spider;
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

	public void setMonster(){
		gp.mosnter[0]=new MON_Spider(gp);
		gp.monster[0].worldX=gp.tileSize*23;
		gp.monster[0].worldY=gp.tileSize*36;

		gp.mosnter[1]=new MON_Spider(gp);
		gp.monster[1].worldX=gp.tileSize*23;
		gp.monster[1].worldY=gp.tileSize*37;
	}

}
