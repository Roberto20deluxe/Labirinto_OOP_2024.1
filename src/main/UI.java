package main;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import object.OBJ_Heart;
import object.SuperObject;

public class UI {
	GamePanel gp;
	Graphics2D g2;
	BufferedImage heart_full, heart_half, heart_blank;
	


	public UI (GamePanel gp) {
		this.gp = gp;
	
		// Criando objeto do hud
		SuperObject heart = new OBJ_Heart(gp);
		heart_full = heart.image;
		heart_half = heart.image2;
		heart_blank = heart.image3;
	}
	
	public void draw(Graphics2D g2) {
		this.g2 = g2;
		
		if (gp.gameState == gp.playState) {
			drawPlayerLife();
		}
		
		if (gp.gameState == gp.pauseState) {
			drawPlayerLife();
			drawPauseScreen();
		}
		
		if (gp.gamesState == gp.dialogueState) {
			drawPlayerLife();
			drawDialogueScree();
		}
	}
}