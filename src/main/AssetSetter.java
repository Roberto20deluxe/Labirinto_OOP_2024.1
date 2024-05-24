package main;

import monster.MON_Spider;
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
		
		gp.obj[0] = new OBJ_Chest(gp);
		gp.obj[0].worldX = 6 * gp.tileSize;
		gp.obj[0].worldY = 6 * gp.tileSize;
		
		gp.obj[1] = new OBJ_Chest(gp);
		gp.obj[1].worldX = 55 * gp.tileSize;
		gp.obj[1].worldY = 55 * gp.tileSize;
		
		gp.obj[2] = new OBJ_Chest(gp);
		gp.obj[2].worldX = 122 * gp.tileSize;
		gp.obj[2].worldY = 122 * gp.tileSize;
		
		gp.obj[3] = new OBJ_Trap(gp);
		gp.obj[3].worldX = 10 * gp.tileSize;
		gp.obj[3].worldY = 5 * gp.tileSize;
		
		gp.obj[4] = new OBJ_Door(gp);
		gp.obj[4].worldX = 69 * gp.tileSize;
		gp.obj[4].worldY = 69 * gp.tileSize;
		
		gp.obj[5] = new OBJ_Key(gp);
		gp.obj[5].worldX = 70 * gp.tileSize;
		gp.obj[5].worldY = 72 * gp.tileSize;
		
		gp.obj[6] = new OBJ_SpeedChest(gp);
		gp.obj[6].worldX = 74 * gp.tileSize;
		gp.obj[6].worldY = 72 * gp.tileSize;
		
		gp.obj[7] = new OBJ_Trap(gp);
		gp.obj[7].worldX = 75 * gp.tileSize;
		gp.obj[7].worldY = 73 * gp.tileSize;
		
		gp.obj[8] = new OBJ_Trap(gp);
		gp.obj[8].worldX = 90 * gp.tileSize;
		gp.obj[8].worldY = 120 * gp.tileSize;
		
		gp.obj[9] = new OBJ_Trap(gp);
		gp.obj[9].worldX = 80 * gp.tileSize;
		gp.obj[9].worldY = 77 * gp.tileSize;
		
		gp.obj[10] = new OBJ_Trap(gp);
		gp.obj[10].worldX = 65 * gp.tileSize;
		gp.obj[10].worldY = 78 * gp.tileSize;
		
		gp.obj[11] = new OBJ_Trap(gp);
		gp.obj[11].worldX = 67 * gp.tileSize;
		gp.obj[11].worldY = 77 * gp.tileSize;
		
		
		gp.obj[12] = new OBJ_Trap(gp);
		gp.obj[12].worldX = 59 * gp.tileSize;
		gp.obj[12].worldY = 8 * gp.tileSize;
		
		gp.obj[13] = new OBJ_Trap(gp);
		gp.obj[13].worldX = 59 * gp.tileSize;
		gp.obj[13].worldY = 7 * gp.tileSize;
		
		
		
		
	}
	
	public void setMonster(){
		
		gp.monster[0]=new MON_Spider(gp);
		gp.monster[0].worldX=gp.tileSize*75;
		gp.monster[0].worldY=gp.tileSize*70;

		gp.monster[1]=new MON_Spider(gp);
		gp.monster[1].worldX=gp.tileSize*77;
		gp.monster[1].worldY=gp.tileSize*70;
	}

}
