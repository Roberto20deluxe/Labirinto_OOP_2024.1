package main;

import javax.swing.JFrame;

public class main {

	public static void main(String[] args) {
		
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Fechar aba quando apertar x
		window.setResizable(false);
		window.setTitle("Labyrinth of leaves"); //Titulo do jogo
		
		GamePanel gamePanel = new GamePanel();
		window.add(gamePanel);
		
		window.pack(); //pack causes the window to be sized to fit the preferred size and layouts of its subcomponents
		
		window.setLocationRelativeTo(null); //Inicar janela no meio
		window.setVisible(true); //Permite ver a janela
		
		gamePanel.setupGame();
		gamePanel.startGameThread();
		
		
	}
}
