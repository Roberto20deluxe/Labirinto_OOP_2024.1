package main;

<<<<<<< HEAD
import java.awt.Font;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

import object.OBJ_Heart;
import object.OBJ_Key;
=======
import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import object.OBJ_Heart;
>>>>>>> 0642ec38f32e19ca80f1576233cefe1292bf5c23
import object.SuperObject;

public class UI {
	GamePanel gp;
	Graphics2D g2;
<<<<<<< HEAD
	BufferedImage keyImage, heart_full, heart_half, heart_blank;
	Font Bitmap_40, Bitmap_80B;
	public boolean messageOn = false;
	public String message = "";
	int messageCounter = 0;
	public Boolean gameFinished = false;
	
	double playTime;
	DecimalFormat dformat = new DecimalFormat("#0.00");

	public UI (GamePanel gp) {
		this.gp = gp;
		
		Bitmap_40 = new Font("Bitmap", Font.PLAIN, 40);
		Bitmap_80B = new Font("Bitmap", Font.BOLD, 80);
		OBJ_Key key = new OBJ_Key();
		keyImage = key.image;
		
		// Criando objeto do hud
		//SuperObject heart = new OBJ_Heart(gp);
		//heart_full = HP.image;
		//heart_half = HP.image2;
		//heart_blank = HP.image3;
	}
	
	public void showMessage(String text) {
		
		message = text;
		messageOn = true;
	}
	
	public void draw(Graphics2D g2) {
		if(gameFinished == true){
			
			String text;
			int textLenght;
			int x;
			int y;
			
			text = "The End";
			textLenght = (int) g2.getFontMetrics().getStringBounds(text,g2).getWidth();
			
			x = gp.screenWidth/2 - textLenght/2;
			y = gp.screenHeight/2 - (gp.tileSize*5);
			g2.drawString(text, x, y);
			
			g2.setFont(Bitmap_80B);
			g2.setColor(Color.black);
			
			text = "That´s all folks, play time: " + dformat.format(playTime) + "!";
			textLenght = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			x = gp.screenWidth/2 - textLenght/2;
			y = gp.screenHeight/2 - (gp.tileSize*5);
			g2.drawString(text, x, y);
			
			g2.setFont(Bitmap_80B);
			g2.setColor(Color.black);
		}
		
		else {
		
		g2.setFont(Bitmap_40);
		g2.setColor(Color.white);
		
		//TIME
		//playTime += (double)1/60;
		//g2.drawString("Time: " + dformat.format(playTime), gp.tileSize/2, gp.tileSize*2);
		
		
		//MESSAGE
		if(messageOn == true) {
			
			g2.setFont(g2.getFont().deriveFont(30F));
			
			
			messageCounter++;
			
			
			if(messageCounter > 120)//120 a.k.a 2 frames a.k.a 2 seconds
				{
				messageCounter = 0;
				messageOn = false;
			}
		}
		}
		
		
		//g2.drawImage(keyImage, gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize, null);
		//g2.drawString("Key = "+ gp.player.hasKey,74,50);
		//g2.drawString("CHEST OPENED "/*/+ gp.player.openChest/*/,400,50);
		
		//this.g2 = g2;
		
		//if (gp.gameState == gp.playState) {
			//drawPlayerLife();
		//}
		
		//if (gp.gameState == gp.pauseState) {
			//drawPlayerLife();
			//drawPauseScreen();
		//}
		
		//if (gp.gamesState == gp.dialogueState) {
			//drawPlayerLife();
			//drawDialogueScree();
		//}
=======
	BufferedImage heart_full, heart_half, heart_blank;
	


	public UI (GamePanel gp) {
		this.gp = gp;
	
		// Criando hud do projeto
		SuperObject heart = new OBJ_Heart(gp);
		heart_full = heart.image;
		heart_half = heart.image2;
		heart_blank = heart.image3;
	}
	
	/*public void draw(Graphics2D g2) {
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
	}*/

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
>>>>>>> 0642ec38f32e19ca80f1576233cefe1292bf5c23
	}
}