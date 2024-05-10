package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

	public boolean upPressed, downPressed, leftPressed, rightPressed;
	
	
	//When the unicode character represented by this key is sent by the keyboard to system input. 
	public void keyTyped(KeyEvent e) 
	{
		
	}
	
	
	//When the key goes down.
	public void keyPressed(KeyEvent e) {
		
		int code = e.getKeyCode();
		
		
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
