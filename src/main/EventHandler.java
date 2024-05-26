package main;

import java.awt.Rectangle;

public class EventHandler {
    GamePanel gp;
    EventRect[][] eventRect;

    public EventHandler(GamePanel gp){
        this.gp = gp;
        
        eventRect = new EventRect[gp.maxWorldCol][gp.maxWorldRow];

        for (int col = 0; col < gp.maxWorldCol; col++) {
            for (int row = 0; row < gp.maxWorldRow; row++) {
                eventRect[col][row] = new EventRect();
                eventRect[col][row].x = 23;
                eventRect[col][row].y = 23;
                eventRect[col][row].width = 2;
                eventRect[col][row].height = 2;
                eventRect[col][row].eventRectDefaultX = eventRect[col][row].x;
                eventRect[col][row].eventRectDefaultY = eventRect[col][row].y;
            }
        }
    }

    public void checkEvent(){
        if (!eventRect[75][73].eventDone && hit(75, 73, "right")) { 
      
        }
        /*if (hit(72,72,"any") == true) {
            healingThing(72, 72, gp.dialogueState);
        }*/
    }


    public boolean hit(int col, int row, String reqDirection) {
        boolean hit = false;

      
        if (col >= 0 && col < gp.maxWorldCol && row >= 0 && row < gp.maxWorldRow) {
           
        	
            gp.player.hitBox.x = gp.player.worldX + gp.player.hitBoxDefaultX;
            gp.player.hitBox.y = gp.player.worldY + gp.player.hitBoxDefaultY;

            
            eventRect[col][row].x = col * gp.tileSize + eventRect[col][row].eventRectDefaultX;
            eventRect[col][row].y = row * gp.tileSize + eventRect[col][row].eventRectDefaultY;

            
            if (gp.player.hitBox.intersects(eventRect[col][row]) && !eventRect[col][row].eventDone) {
                if (gp.player.direction.equals(reqDirection) || reqDirection.equals("any")) {
                    hit = true;
                }
            }

           
            eventRect[col][row].x = eventRect[col][row].eventRectDefaultX;
            eventRect[col][row].y = eventRect[col][row].eventRectDefaultY;
        }

        
        gp.player.hitBox.x = gp.player.hitBoxDefaultX;
        gp.player.hitBox.y = gp.player.hitBoxDefaultY;

        return hit;
    }
    
    public void damageTrap(int col, int row, int gameState){
 
   
        
    }
    public void healingThing(int col, int row, int gameState) {
    	if(gp.keyH.enterPressed == true) {
    		gp.gameState = gameState;
    		gp.ui.currentDialogue = "Health";
    		gp.player.life = gp.player.maxLife;   
    		
    	}
    }
    
}
