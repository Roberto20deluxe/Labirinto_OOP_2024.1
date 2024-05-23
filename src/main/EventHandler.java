package main;

import java.awt.Rectangle;

public class EventHandler {
    GamePanel gp;
<<<<<<< HEAD
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
            damageTrap(75, 72, gp.dialogueState);
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
=======
    Rectangle eventRect;
    int eventRectDefaultX, eventRectDefaultY;

    public EventHandler(GamePanel gp){
        this.gp = gp;

        eventRect = new Rectangle();
        eventRect.x = 23;
        eventRect.y = 23;
        eventRect.width = 2;
        eventRect.height = 2;
        eventRectDefaultX = eventRect.x;
        eventRectDefaultY = eventRect.y;
    }

    public void checkEvent(){
        if (hit(27,16, "right")){ // Primeiro valor é para coluna. Segundo valor é a linha e o terceiro valor é a direação
            damagePit(gp.dialogueStates);
        }
    }

    public boolean hit(int eventCol, int eventRow, String reqDirection){
        boolean hit = false;

        gp.player.hitBox.x = gp.player.worldX + gp.player.hitBox.x;
        gp.player.hitBox.x = gp.player.worldY + gp.player.hitBox.y;
        eventRect.x = eventCol*gp.tileSize + eventRect.x;
        eventRect.y = eventCol*gp.tileSize + eventRect.y;

        if (gp.player.hitBox.intersects(eventRect)){
            if (gp.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any")){
                hit = true;
            }
        }

        gp.player.hitBox.x = gp.player.hitBoxDefaultX;
        gp.player.hitBox.y = gp.player.hitBoxDefaultY;
        eventRect.x = eventRectDefaultX;
        eventRect.y = eventRectDefaultY;
>>>>>>> 75e8e2f098e51d9d65d799b9506c035d52ef88a8

        return hit;
    }
    
<<<<<<< HEAD
    public void damageTrap(int col, int row, int gameState){
        gp.gameState = gameState;
        gp.ui.currentDialogue = "VC FOI ARMADILHADO ÓTARIO!";
        gp.gameState = gp.dialogueState;
        gp.player.life--;
        eventRect[col][row].eventDone = true;
        
    }
    public void healingThing(int col, int row, int gameState) {
    	if(gp.keyH.enterPressed == true) {
    		gp.gameState = gameState;
    		gp.ui.currentDialogue = "Health";
    		gp.player.life = gp.player.maxLife;    	}
    }
    
=======
    public void damagePit(int gameState){
        gp.gameState = gameState;
        gp.ui.currentDialogue = "You fall into a pit!";
        gp.player.life--;
    }
>>>>>>> 75e8e2f098e51d9d65d799b9506c035d52ef88a8
}
