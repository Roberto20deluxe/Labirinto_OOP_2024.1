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
	
		// Criando hud do projeto
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

	public void drawPlayerLife(){
		int x = gp.tileSize/2;
		int y = gp.tileSize/2;
		int i = 0;

		// Desenha o coração vazio
		while (i < gp.player.maxLife/2){
			g2.drawImage(heart_blank, x, y , null);
			i++;
			x += gp.tileSize;
		}

		// Reset das variaveis;

		x = gp.tileSize/2;
		y = gp.tileSize/2;
		i = 0;

		while (i < gp.player.life){
			g2.drawImage(heart_half, x, y, null);
			i++;
			
			if(i < gp.player.life){
				g2.drawImage(heart_full, x, y, null);
			}
			i++;
			x += gp.tileSize;
		}
	}
}