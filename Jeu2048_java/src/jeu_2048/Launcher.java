/**
 * 
 */
package jeu_2048;

import java.awt.Dimension;

import jeu_2048.control.GameController;
import jeu_2048.game.Engine;
import jeu_2048.hmi.GameWindow;


public class Launcher {
	
	
	public static void main(String[] args) {
		Engine engine = new Engine();
		GameController gameController = new GameController(engine);
		GameWindow fenetre = new GameWindow(gameController);
		Dimension d = new Dimension(500,500);
		fenetre.setPreferredSize(d);
		fenetre.pack();
		fenetre.setVisible(true);
	}
}