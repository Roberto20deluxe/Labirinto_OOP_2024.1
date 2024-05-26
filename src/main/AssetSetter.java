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
        gp.obj[1].worldX = 28 * gp.tileSize;
        gp.obj[1].worldY = 12 * gp.tileSize;

        gp.obj[2] = new OBJ_Chest(gp);
        gp.obj[2].worldX = 138 * gp.tileSize;
        gp.obj[2].worldY = 5 * gp.tileSize;

        gp.obj[3] = new OBJ_Trap(gp);
        gp.obj[3].worldX = 31 * gp.tileSize;
        gp.obj[3].worldY = 18 * gp.tileSize;

        gp.obj[4] = new OBJ_Door(gp);
        gp.obj[4].worldX = 140 * gp.tileSize;
        gp.obj[4].worldY = 5 * gp.tileSize;

        gp.obj[5] = new OBJ_Key(gp);
        gp.obj[5].worldX = 4 * gp.tileSize;
        gp.obj[5].worldY = 12 * gp.tileSize;

        gp.obj[6] = new OBJ_SpeedChest(gp);
        gp.obj[6].worldX = 31 * gp.tileSize;
        gp.obj[6].worldY = 131 * gp.tileSize;

        gp.obj[7] = new OBJ_Chest(gp);
        gp.obj[7].worldX = 120 * gp.tileSize;
        gp.obj[7].worldY = 60 * gp.tileSize;

        gp.obj[8] = new OBJ_Chest(gp);
        gp.obj[8].worldX = 99 * gp.tileSize;
        gp.obj[8].worldY = 28 * gp.tileSize;

        gp.obj[9] = new OBJ_Trap(gp);
        gp.obj[9].worldX = 122 * gp.tileSize;
        gp.obj[9].worldY = 130 * gp.tileSize;

        gp.obj[10] = new OBJ_Trap(gp);
        gp.obj[10].worldX = 1 * gp.tileSize;
        gp.obj[10].worldY = 1 * gp.tileSize;

        gp.obj[11] = new OBJ_Trap(gp);
        gp.obj[11].worldX = 29 * gp.tileSize;
        gp.obj[11].worldY = 127 * gp.tileSize;

        gp.obj[12] = new OBJ_Trap(gp);
        gp.obj[12].worldX = 96 * gp.tileSize;
        gp.obj[12].worldY = 35 * gp.tileSize;

        gp.obj[13] = new OBJ_Trap(gp);
        gp.obj[13].worldX = 97 * gp.tileSize;
        gp.obj[13].worldY = 35 * gp.tileSize;

        gp.obj[14] = new OBJ_Trap(gp);
        gp.obj[14].worldX = 30 * gp.tileSize;
        gp.obj[14].worldY = 18 * gp.tileSize;


        gp.obj[15] = new OBJ_Chest(gp);
        gp.obj[15].worldX = 44 * gp.tileSize;
        gp.obj[15].worldY = 52 * gp.tileSize;

        gp.obj[16] = new OBJ_Trap(gp);
        gp.obj[16].worldX = 73 * gp.tileSize;
        gp.obj[16].worldY = 126 * gp.tileSize;

        gp.obj[17] = new OBJ_Trap(gp);
        gp.obj[17].worldX = 45 * gp.tileSize;
        gp.obj[17].worldY = 56 * gp.tileSize;

        gp.obj[18] = new OBJ_Trap(gp);
        gp.obj[18].worldX = 90 * gp.tileSize;
        gp.obj[18].worldY = 45 * gp.tileSize;

        gp.obj[19] = new OBJ_SpeedChest(gp);
        gp.obj[19].worldX = 53 * gp.tileSize;
        gp.obj[19].worldY = 20 * gp.tileSize;

        gp.obj[20] = new OBJ_Trap(gp);
        gp.obj[20].worldX = 50 * gp.tileSize;
        gp.obj[20].worldY = 38 * gp.tileSize;

        gp.obj[21] = new OBJ_Trap(gp);
        gp.obj[21].worldX = 50 * gp.tileSize;
        gp.obj[21].worldY = 37 * gp.tileSize;

        gp.obj[22] = new OBJ_Chest(gp);
        gp.obj[22].worldX = 60 * gp.tileSize;
        gp.obj[22].worldY = 40 * gp.tileSize;

        gp.obj[23] = new OBJ_Trap(gp);
        gp.obj[23].worldX = 61 * gp.tileSize;
        gp.obj[23].worldY = 40 * gp.tileSize;

        gp.obj[24] = new OBJ_Trap(gp);
        gp.obj[24].worldX = 60 * gp.tileSize;
        gp.obj[24].worldY = 41 * gp.tileSize;

        gp.obj[25] = new OBJ_Trap(gp);
        gp.obj[25].worldX = 30 * gp.tileSize;
        gp.obj[25].worldY = 127 * gp.tileSize;
        
        gp.obj[26] = new OBJ_Door(gp);
        gp.obj[26].worldX = 140 * gp.tileSize;
        gp.obj[26].worldY = 4 * gp.tileSize;
        
        gp.obj[27] = new OBJ_Chest(gp);
        gp.obj[27].worldX = 28 * gp.tileSize;
        gp.obj[27].worldY = 28 * gp.tileSize;
        
        gp.obj[28] = new OBJ_Chest(gp);
        gp.obj[28].worldX = 137 * gp.tileSize;
        gp.obj[28].worldY = 21 * gp.tileSize;
        
        gp.obj[29] = new OBJ_Chest(gp);
        gp.obj[29].worldX = 4 * gp.tileSize;
        gp.obj[29].worldY = 80 * gp.tileSize;
        
        gp.obj[30] = new OBJ_Chest(gp);
        gp.obj[30].worldX = 12 * gp.tileSize;
        gp.obj[30].worldY = 96 * gp.tileSize;
        
        gp.obj[31] = new OBJ_Chest(gp);
        gp.obj[31].worldX = 12 * gp.tileSize;
        gp.obj[31].worldY = 28 * gp.tileSize;
        
        gp.obj[32] = new OBJ_Chest(gp);
        gp.obj[32].worldX = 1 * gp.tileSize;
        gp.obj[32].worldY = 1 * gp.tileSize;
        
        gp.obj[33] = new OBJ_Chest(gp);
        gp.obj[33].worldX = 114 * gp.tileSize;
        gp.obj[33].worldY = 120 * gp.tileSize;
        
        gp.obj[34] = new OBJ_Chest(gp);
        gp.obj[34].worldX = 120 * gp.tileSize;
        gp.obj[34].worldY = 138 * gp.tileSize;
        
        
        
        
    }

    public void setMonster() {
        
        gp.monster[0] = new MON_Spider(gp);
        gp.monster[0].worldX = gp.tileSize * 10;
        gp.monster[0].worldY = gp.tileSize * 6;

        gp.monster[1] = new MON_Spider(gp);
        gp.monster[1].worldX = gp.tileSize * 77;
        gp.monster[1].worldY = gp.tileSize * 70;

       
        gp.monster[2] = new MON_Spider(gp);
        gp.monster[2].worldX = gp.tileSize * 20;
        gp.monster[2].worldY = gp.tileSize * 20;

        gp.monster[3] = new MON_Spider(gp);
        gp.monster[3].worldX = gp.tileSize * 47;
        gp.monster[3].worldY = gp.tileSize * 40;

        gp.monster[4] = new MON_Spider(gp);
        gp.monster[4].worldX = gp.tileSize * 74;
        gp.monster[4].worldY = gp.tileSize * 60;

        gp.monster[5] = new MON_Spider(gp);
        gp.monster[5].worldX = gp.tileSize * 80;
        gp.monster[5].worldY = gp.tileSize * 80;

        gp.monster[6] = new MON_Spider(gp);
        gp.monster[6].worldX = gp.tileSize * 30;
        gp.monster[6].worldY = gp.tileSize * 50;

        gp.monster[7] = new MON_Spider(gp);
        gp.monster[7].worldX = gp.tileSize * 37;
        gp.monster[7].worldY = gp.tileSize * 60;

        gp.monster[8] = new MON_Spider(gp);
        gp.monster[8].worldX = gp.tileSize * 90;
        gp.monster[8].worldY = gp.tileSize * 70;

        gp.monster[9] = new MON_Spider(gp);
        gp.monster[9].worldX = gp.tileSize * 129;
        gp.monster[9].worldY = gp.tileSize * 17;
        
        gp.monster[10] = new MON_Spider(gp);
        gp.monster[10].worldX = gp.tileSize * 12;
        gp.monster[10].worldY = gp.tileSize * 17;
        
        gp.monster[11] = new MON_Spider(gp);        
        gp.monster[11].worldX = gp.tileSize * 9;   
        gp.monster[11].worldY = gp.tileSize * 21;   
        
        gp.monster[12] = new MON_Spider(gp);        
        gp.monster[12].worldX = gp.tileSize * 4;   
        gp.monster[12].worldY = gp.tileSize * 15;  
                   
        gp.monster[13] = new MON_Spider(gp);        
        gp.monster[13].worldX = gp.tileSize * 4;   
        gp.monster[13].worldY = gp.tileSize * 18;  
        
        gp.monster[14] = new MON_Spider(gp);        
        gp.monster[14].worldX = gp.tileSize * 44;   
        gp.monster[14].worldY = gp.tileSize * 15;  
        
        gp.monster[15] = new MON_Spider(gp);        
        gp.monster[15].worldX = gp.tileSize * 29;   
        gp.monster[15].worldY = gp.tileSize * 32;  
        
        gp.monster[16] = new MON_Spider(gp);        
        gp.monster[16].worldX = gp.tileSize * 24;   
        gp.monster[16].worldY = gp.tileSize * 71; 
                    
        gp.monster[17] = new MON_Spider(gp);        
        gp.monster[17].worldX = gp.tileSize * 61;   
        gp.monster[17].worldY = gp.tileSize * 55;
        
        gp.monster[18] = new MON_Spider(gp);        
        gp.monster[18].worldX = gp.tileSize * 72;   
        gp.monster[18].worldY = gp.tileSize * 102;
        
        gp.monster[19] = new MON_Spider(gp);        
        gp.monster[19].worldX = gp.tileSize * 65;   
        gp.monster[19].worldY = gp.tileSize * 112;
        
        gp.monster[20] = new MON_Spider(gp);        
        gp.monster[20].worldX = gp.tileSize * 72;   
        gp.monster[20].worldY = gp.tileSize * 129;
        
        gp.monster[21] = new MON_Spider(gp);        
        gp.monster[21].worldX = gp.tileSize * 81;   
        gp.monster[21].worldY = gp.tileSize * 129;
    }
    
}
