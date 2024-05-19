package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

import entity.Entity;
import entity.Player;
import object.SuperObject;
import tile.TileManager;


@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable {
	
	//configurações de tela
	final int originalTileSize = 16; //Tamanho 16x16 para entidades
	final int scale = 3; // 16x3 = 48 tamanho da tela
	
	public final int tileSize = originalTileSize * scale; //48x48 tiles
	public final int maxScreenColumn = 16;
	public final int maxScreenRow  =12; //Makes the ratio 4:3
	public final int screenWidth = tileSize * maxScreenColumn; //768 pixels
	public final int screenHeight = tileSize * maxScreenRow; //576 pixels
	
	//World settings
	public final int maxWorldCol = 50;
	public final int maxWorldRow = 50;
	public final int worldWidght = tileSize * maxWorldCol;
	public final int worldHeight = tileSize * maxWorldRow;
	
	
	
	int FPS = 60;
	
	TileManager tileM = new TileManager(this);
	
	Thread gameThread; 
	KeyHandler keyH = new KeyHandler();
	public CollisionChecker cChecker = new CollisionChecker(this);
	AssetSetter aSetter = new AssetSetter(this);
	public Player player = new Player(this,keyH);
	public SuperObject obj[] = new SuperObject[10];
	public Entity monster[]=new Entity[20];
	
	public GamePanel() {
		
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.green.darker().darker().darker().darker().darker());
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
		
	}
	
	public void setupGame(){
		
		aSetter.setObject();
		aSetter.setMonster();
		
		
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

		if(gameState==playState){
			player.update();

			for(int i=0;i<mosnter.lenght;i++){
				if(monster[i]!=null){
					monster[i].update();
				}
			}
		}		
		
	}
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g); //super significa que é para classe parente dessa classe a.k.a JPanel
		
		Graphics2D g2 = (Graphics2D)g;  // Graphics2D class extends the graphics class to provide more sophisticated control over gemoatry, coordiante tranformations, color menagement, and text layout.
		
		tileM.draw(g2); //Needs to be before player.draw, if it is the opposite the tiles will be drawn above the PC
		
		player.draw(g2);
		
		g2.dispose();
		
		if(gameState==titleState){

		}
		else{

			for(int i=0;i<monster.length;i++){
				if(monster[i]!=null){
					entityList.add(monster[i]);
				}
			}
			
		}
		
	}
	
}
 