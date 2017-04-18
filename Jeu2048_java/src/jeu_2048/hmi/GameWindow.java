/**
 * 
 */
package jeu_2048.hmi;

import javax.swing.JFrame;


import java.awt.event.KeyListener;
import jeu_2048.control.GameController;
import java.awt.event.KeyEvent;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author nannan_max
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class GameWindow extends JFrame implements KeyListener {
	
	private GamePanel gamePanel;
	private GameController gameController;


	public GameWindow(GameController gameController) {
		this.gameController= gameController;
		this.gamePanel= new GamePanel(this.gameController);
		this.add(this.gamePanel);
		this.addKeyListener(this);
		this.gamePanel.repaint(0,0,200,200);
	}

	public void keyPressed(KeyEvent keyEvent) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}


	public void keyReleased(KeyEvent keyEvent) {
		char c = keyEvent.getKeyChar();
		this.gameController.updateEngine(c);
		
		this.gamePanel.repaint(0,0,200,200);
	}


	public void keyTyped(KeyEvent keyEvent) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}
}