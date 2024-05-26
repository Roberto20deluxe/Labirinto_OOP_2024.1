package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JPanel;

import entity.Entity;
import entity.Player;
import tile.TileManager;


@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable {
	
	//configurações de tela
	final int originalTileSize = 16; //Tamanho 16x16 para entidades
	final int scale = 3; // 16x3 = 48 tamanho da tela
	
	public final int tileSize = originalTileSize * scale; //48x48 tiles
	public final int maxScreenColumn = 16;
	public final int maxScreenRow  = 12; //Makes the ratio 4:3
	public final int screenWidth = tileSize * maxScreenColumn; //768 pixels
	public final int screenHeight = tileSize * maxScreenRow; //576 pixels
	
	//World settings
	public final int maxWorldCol = 144;
	public final int maxWorldRow = 144;
	public final int worldWidght = tileSize * maxWorldCol;
	public final int worldHeight = tileSize * maxWorldRow;
	private GamePanel gp;
	
	int FPS = 60;
	
	TileManager tileM = new TileManager(this);
	KeyHandler keyH = new KeyHandler(this);
	public CollisionChecker cChecker = new CollisionChecker(this);
	public AssetSetter aSetter = new AssetSetter(this);
	public UI ui = new UI(this);
	public EventHandler eHandler = new EventHandler(this);
	Thread gameThread; 
	
	public Player player = new Player(this,keyH);
	public Entity obj[] = new Entity[45];
	public Entity npc[] = new Entity[0];
	public Entity monster[] = new Entity[30];
	ArrayList<Entity> entityList = new ArrayList<>();

	public int gameState;
	public final int titleState = 0;
	public final int playState = 1;
	public final int pauseState = 2;
	public int dialogueState = 3;
	public final int gameOverState = 4;
	public final int endGameState = 5;

	
	
	public GamePanel() {
		
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.BLACK);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
		this.gp = this;
		player = new Player(this, keyH);
		
	}
	
	public void setupGame(){
		
		cChecker = new CollisionChecker(this);
		
		aSetter.setObject();
		aSetter.setMonster();
		gameState = titleState;
		
		
		
		
		
		
	}
	
	public void startGameThread() {
		
		gameThread = new Thread(this);
		gameThread.start();
		
		
	}


	public void run() {
	    double drawInterval = 1000000000 / FPS;
	    double nextDrawTime = System.nanoTime() + drawInterval;

	    while (gameThread != null) {
	        update();
	        repaint();

	        try {
	            double remainingTime = nextDrawTime - System.nanoTime();
	            remainingTime = remainingTime / 1000000;

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
	    if (gameState == playState) {
	        player.update();
	        
	        if (player.life <= 0) {
	            gameState = gameOverState;
	        }
	        
	        for (int i = 0; i < monster.length; i++) {
	            if (monster[i] != null) {
	                monster[i].update();
	            }
	        }
	    }
	    if (gameState == pauseState) {
	        // nada kkkkk
	    }
	}

		
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g); 
		
		Graphics2D g2 = (Graphics2D)g;  // Graphics2D class extends the graphics class to provide more sophisticated control over gemoetry, coordiante tranformations, color menagement, and text layout.
		
		
		
		//TITLE SCREEN
		if (gameState == titleState) {
			
			ui.draw(g2);
		}
		else {
		
			//TILE
			tileM.draw(g2); //Needs to be before player.draw, if it is the opposite the tiles will be drawn above the PC
			
			
			for(int i = 0; i < obj.length; i++) {
			    if(obj[i] != null) {
			        entityList.add(obj[i]);
			    }
			}
			
			//ENTIDADES
			entityList.add(player);
			
			
			
			
			for(int i = 0 ;i < monster.length; i++){
				if(monster[i] !=null){
					entityList.add(monster[i]);
			
				}
			}
			
			int nextX = player.worldX + player.speed;
	        int nextY = player.worldY + player.speed;

	        if (nextX >= 0 && nextX < worldWidght &&
	            nextY >= 0 && nextY < worldHeight) {
	            player.update();
	        }

	       
	          
	            
	                
	 
	
		}
		if (gameState == gameOverState) {
			g2.setFont(g2.getFont().deriveFont(Font.BOLD,90F));
	        g2.setColor(Color.white);
	        String endText = "GAME OVER";
	        int textWidth = g2.getFontMetrics().stringWidth(endText);
	        int textHeight = g2.getFontMetrics().getHeight();
	        int centerX = (screenWidth - textWidth) / 2;
	        int centerY = (screenHeight - textHeight) / 2;
	        g2.drawString(endText, centerX, centerY);
	    }
		
	
			//SORT
			Collections.sort(entityList, new Comparator<Entity>() {

				@Override
				public int compare(Entity e1, Entity e2) {
					
					int result = Integer.compare(e1.worldY, e2.worldY);
					return 0;
				}
				
				
			});
			
			//DRAW ENTITIES
			for(int i = 0; i < entityList.size(); i++) {
				entityList.get(i).draw(g2);
			}
			//EMPTY ENTITY LIST
			entityList.clear();
			
			//UI
			ui.draw(g2);
			
			//drawPlayerPosition(g2);
			
			
			
			
			
			if(gameState==titleState){

			}
			else{

				for(int i=0;i<monster.length;i++){
					if(monster[i]!=null){
						entityList.add(monster[i]);
					}
				}

			}
			
			if(gameState == endGameState) {
				ui.drawEndScreen();
				
			}
			
			g2.dispose();
		}
			
	/*public void drawPlayerPosition(Graphics2D g2) {
	    g2.setColor(Color.RED); 
	    Font originalFont = g2.getFont();
	    Font newFont = originalFont.deriveFont(20f); 
	    g2.setFont(newFont); 
	    
	    int tileX = player.worldX / tileSize;
	    int tileY = player.worldY / tileSize;
	    
	   
	    g2.drawString("Player Position: (" + tileX + ", " + tileY + ")", 10, 20);
	    
	    g2.setFont(originalFont);
	}*/



	
}

 