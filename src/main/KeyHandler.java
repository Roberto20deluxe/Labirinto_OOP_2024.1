package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

	GamePanel gp;
	public boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed;
	//DEBUG
	boolean checkDrawTime = false;
	
	
	public KeyHandler(GamePanel gp) {
		this.gp = gp;
	}
	
	//When the unicode character represented by this key is sent by the keyboard to system input. 
	public void keyTyped(KeyEvent e) 
	{
		
	}
	
	
	//When the key goes down.
	public void keyPressed(KeyEvent e) {
		
		int code = e.getKeyCode();
		
		if(gp.gameState == gp.titleState) {
			
			if (code == KeyEvent.VK_UP || code == KeyEvent.VK_W){
				gp.ui.commandNum--;
				if(gp.ui.commandNum < 0) {
					gp.ui.commandNum=2;
				}
			}
			
			else if (code == KeyEvent.VK_DOWN || code == KeyEvent.VK_S){
				gp.ui.commandNum++;
				if(gp.ui.commandNum >= 3) {
					gp.ui.commandNum = 0;
				}
			}
			
			if(code == KeyEvent.VK_ENTER) {
				if(gp.ui.commandNum == 0) {
					gp.gameState = gp.playState; 
				}
				if(gp.ui.commandNum == 1) {
					//LOAD SAVED GAME
				}
				if(gp.ui.commandNum == 2) {
					System.exit(0);
				}
				
			}
		}
		
		if(gp.gameState == gp.playState) {
			if (code == KeyEvent.VK_UP || code == KeyEvent.VK_W){
				
				upPressed = true;
			}
			
			else if (code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A){
				
				leftPressed = true;
			}
			
			else if (code == KeyEvent.VK_DOWN || code == KeyEvent.VK_S){
				
				downPressed = true;
			}
			
			else if (code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D){
				
				rightPressed = true;
			}
			
			
			if(code == KeyEvent.VK_ENTER) {
				enterPressed = true;
			}
			
			else if (code == KeyEvent.VK_ESCAPE){
				if(gp.gameState == gp.playState) {
					gp.gameState = gp.pauseState;
				}
				else if(gp.gameState == gp.pauseState) {
					gp.gameState = gp.playState;
				}
			}
			
		}
		//PAUSE STATE
		else if(gp.gameState == gp.pauseState) {
			if(code == KeyEvent.VK_ESCAPE) {
				gp.gameState = gp.playState;
					
			}
			}
		
		else if(gp.gameState == gp.dialogueState);{
			if(code == KeyEvent.VK_ENTER) {
				gp.gameState = gp.playState;
			}
			
	
	
		
	
	
		
	}
	
}
	//When the key comes up 
	public void keyReleased(KeyEvent e)  
	{
		
		int code = e.getKeyCode();
		
		
		if (code == KeyEvent.VK_UP || code == KeyEvent.VK_W){
			
			upPressed = false;
		}
		
		else if(code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A){
			
			leftPressed = false;
		}
		
		else if(code == KeyEvent.VK_DOWN || code == KeyEvent.VK_S){
			
			downPressed = false;
		}
		
		else if(code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D){
			
			rightPressed = false;
		}
			
	}

}
