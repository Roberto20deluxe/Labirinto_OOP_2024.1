package main;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;

import object.OBJ_Heart;
import object.OBJ_Key;
import entity.Entity;

public class UI {
	GamePanel gp;
	Graphics2D g2;
	BufferedImage heart_full, heart_half, heart_blank;
	Font Retro_Gaming, Perfect_DOS_VGA;
	public boolean messageOn = false;
	public String message = "";
	int messageCounter = 0;
	public Boolean gameFinished = false;
	public String currentDialogue = "";
	public int commandNum = 0;
	
	
	double playTime;
	DecimalFormat dformat = new DecimalFormat("#0.00");

	public UI (GamePanel gp) {
		this.gp = gp;
		
		try {
            
            InputStream is = getClass().getResourceAsStream("/font/Retro Gaming.ttf");
            if (is != null) {
                try {
                    Retro_Gaming = Font.createFont(Font.TRUETYPE_FONT, is);
                } finally {
                    is.close();  
                }
            } else {
                System.err.println("Retro Gaming font not found at /font/Retro Gaming.ttf");
            }

            
            InputStream is2 = getClass().getResourceAsStream("/font/Perfect DOS VGA 437.ttf");
            if (is2 != null) {
                try {
                    Perfect_DOS_VGA = Font.createFont(Font.TRUETYPE_FONT, is2);
                } finally {
                    is2.close();  
                }
            } else {
                System.err.println("Perfect DOS VGA font not found at /font/Perfect DOS VGA.ttf");
            }
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
   
		
		Entity heart = new OBJ_Heart(gp); {
			
			heart_full = heart.image;
			heart_half = heart.image2;
			heart_blank = heart.image3;
		}
}

	
	
	public void showMessage(String text) {
		
		message = text;
		messageOn = true;
	}
	
	public void draw(Graphics2D g2) {
<<<<<<< HEAD
	    this.g2 = g2;
	    g2.setFont(Retro_Gaming);
	    g2.setColor(Color.white);
	    
	    if (gp.gameState == gp.titleState) {
	        drawTitleScreen();
	    } else if (gp.gameState == gp.playState) {
	        drawPlayerLife();
	    } else if (gp.gameState == gp.pauseState) {
	        drawPlayerLife();
	        drawPauseScreen();
	    } else if (gp.gameState == gp.dialogueState) {
	        drawPlayerLife();
	        drawDialogueScreen();
	    }
	}
=======
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
>>>>>>> 75e8e2f098e51d9d65d799b9506c035d52ef88a8

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
	
	private void drawTitleScreen() {
		// TITLE NAME
		g2.setFont(g2.getFont().deriveFont(Font.BOLD,58F));
		String text = "Labyrinth of leaves";
		int x =  getXforCenteredText(text);
		int y = gp.tileSize*3;
		
		//SHADOW
		g2.setColor(Color.black);
		g2.drawString(text, x+5, y+5);
		
		//SHADOW++
		g2.setColor(Color.black);
		g2.drawString(text, x+10, y+10);
		
		//MAIN COLOR
		g2.setColor(Color.white);
		g2.drawString(text, x, y);
		
		// ELE MESMO O G
		x = gp.screenWidth/2 - (gp.tileSize);
		y += gp.tileSize*2;
		g2.drawImage(gp.player.down2, x, y, gp.tileSize*2, gp.tileSize*2, null);
		
		//MENU
		g2.setFont(g2.getFont().deriveFont(Font.BOLD,38F));
		
		text = "START";
		x = getXforCenteredText(text);
		y += gp.tileSize*3.5;
		g2.drawString(text, x, y);
		if(commandNum == 0) {
			g2.drawString(">", x-gp.tileSize+20, y);
		}
		
		text = "CONTINUE";
		x = getXforCenteredText(text);
		y += gp.tileSize;
		g2.drawString(text, x, y);
		if(commandNum == 1) {
			g2.drawString(">", x-gp.tileSize+20, y);
		}
		
		text = "QUIT";
		x = getXforCenteredText(text);
		y += gp.tileSize;
		g2.drawString(text, x, y);
		if(commandNum == 2) {
			g2.drawString(">", x-gp.tileSize+20, y);
		}
		
	}

	public void drawPauseScreen() {
		
		
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN,80F));
		String text  ="PAUSADO";
		int x = getXforCenteredText(text);
		
		
		int y = gp.screenHeight/2;
		
		g2.drawString(text, x, y);
	}
	
	public void drawDialogueScreen() {
	    // Draw window
	    int x = gp.tileSize / 2;
	    int y = gp.tileSize * 2;
	    int width = gp.screenWidth - (gp.tileSize * 4);
	    int height = gp.tileSize * 5;

	    drawSubWindow(x, y, width, height);

	    
	    if (Retro_Gaming != null) {
	        g2.setFont(Retro_Gaming.deriveFont(Font.PLAIN, 28f));
	    } else {
	        g2.setFont(new Font("Arial", Font.PLAIN, 28));
	    }
	    g2.setColor(Color.white);

	    x += gp.tileSize;
	    y += gp.tileSize + 30; 

	    

	    for (String line : currentDialogue.split("\n")) {
	        g2.drawString(line, x, y);
	        y += 40; 
	    }
	}

	
	public void drawSubWindow(int x, int y, int width, int height) {
		
		Color c = new Color(0,0,0,155);
		g2.setColor(c);
		g2.fillRoundRect(x, y, width, height, 35, 35);
		
		c = new Color(255,255,255);
		g2.setStroke(new BasicStroke(5));
		g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
	}
	
	public int getXforCenteredText(String text) {

		int lenght = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		int x = gp.screenWidth/2 - lenght/2;
		return x;
	}
}