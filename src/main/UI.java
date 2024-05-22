package main;

import java.awt.BasicStroke;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import object.OBJ_Heart;
import object.SuperObject;

public class UI {
	GamePanel gp;
	Graphics2D g2;
	BufferedImage heart_full, heart_half, heart_blank;
	Font Bitmap_40, Bitmap_80B, Retro_Gaming, Perfect_DOS_VGA;
	


	public UI (GamePanel gp) {
		this.gp = gp;
	
		try{
			InputStream is = getClass().getResourceAsStream("/font/Retro Gaming.ttf");
			Retro_Gaming= Font.createFont(Font.TRUETYPE_FONT, is);

			InputStream is = getClass().getResourceAsStream("/font/Perfect DOS VGA.ttf");
			Perfect_DOS_VGA= Font.createFont(Font.TRUETYPE_FONT, is);
		}
		catch(FontFormatException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}

		// Criando objeto do hud
		SuperObject heart = new OBJ_Heart(gp);
		heart_full = heart.image;
		heart_half = heart.image2;
		heart_blank = heart.image3;
	}
	
	public void draw(Graphics2D g2) {
		this.g2 = g2;

		g2.setFont(Retro_Gaming);
		g2.setColor(Color.black);
		
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
