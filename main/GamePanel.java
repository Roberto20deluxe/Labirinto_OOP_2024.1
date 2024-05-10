package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import entity.Player;


public class GamePanel extends JPanel implements Runnable {
	
	//configurações de tela
	final int originalTileSize = 16; //Tamanho 16x16 para entidades
	final int scale = 3; // 16x3 = 48 tamanho da tela
	
	public final int tileSize = originalTileSize * scale; //48x48 tiles
	final int maxScreenColumn = 16;
	final int maxScreenRow  =12; //Makes the ratio 4:3
	final int screenWidth = tileSize * maxScreenColumn; //768 pixels
	final int screenHeight = tileSize * maxScreenRow; //576 pixels
	
	//FPS
	int FPS = 60;
	
	Thread gameThread; 
	KeyHandler keyH = new KeyHandler();
	Player player = new Player(this,keyH);
	
	//Posição do jogador. (Em JAVA canto superior esquerdo = x=0 e y=0)
	int playerX = 100; 
	int playerY = 100;
	int playerSpeed = 4; // 4 pixels
	
	
	
	public GamePanel() {
		
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.green.darker().darker());
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
		
	}
	
	public void startGameThread() {
		
		gameThread = new Thread(this);
		gameThread.start();
		
		
	}


	public void run() {
		
		double drawInterval = 1000000000/FPS; //0.01666... segundos
		double nextDrawTime = System.nanoTime() + drawInterval;
		
		while(gameThread != null) {
			
			long currentTime = System.nanoTime();
			
			// 1 UPDATE: update information such as character positions
			update();
			
			// 2 DRAW: draw the screen with the updated information 
			repaint();
			
		try {
			double remainingTime =  nextDrawTime - System.nanoTime();
			remainingTime = remainingTime/1000000;
			
			if (remainingTime < 0) {
				remainingTime = 0;
				
			}
			
			Thread.sleep((long) remainingTime);
			
			nextDrawTime += drawInterval;
			
		 } catch (InterruptedException e) {
				
				e.printStackTrace();
				
			}
		
		
			}
		}
	public void update() {
		
		player.update();
		
	}
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g); //super significa que é para classe parente dessa classe a.k.a JPanel
		
		Graphics2D g2 = (Graphics2D)g;  // Graphics2D class extends the graphics class to provide more sophisticated control over gemoatry, coordiante tranformations, color menagement, and text layout.
		
		player.draw(g2);
		
		g2.dispose();
		
		
	}
	
}
 
