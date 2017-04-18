/**
 * 
 */
package jeu_2048.hmi;

import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import jeu_2048.control.GameController;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author nannan_max
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class GamePanel extends JPanel {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private GameController gameController;


	public GamePanel(GameController gameController) {
		this.gameController = gameController;
	}


	public void paint(Graphics g) {
		if(this.gameController.engine.over==true){
			g.setColor(new Color(255,255,255));
			g.fillRect(0, 0, 200, 200);
			g.setColor(new Color(0,0,0));
			g.setFont(new Font("TimesRoman", Font.PLAIN, 10));
			g.drawString("PERDU !!!!  VOTRE SCORE EST DE "+Integer.toString(this.gameController.engine.score()), 10, 100);
		}
		else{
			for(int i=0; i<4;i++){
				for(int j=0;j<4;j++){
					if(this.gameController.engine.cell[j][i].getCell()!=0){
						g.setColor(new Color(255,0,0));
						g.fillRect(50*i,50*j, 50, 50);
						g.setColor(new Color(255,255,255));
						g.drawString(Integer.toString(this.gameController.engine.cell[j][i].getCell()), 50*i +20,50*j +20);
					}
					else{
						g.setColor(new Color(255,255,255));
						g.fillRect(50*i,50*j, 50, 50);
					}
				}
			}
		}
	}


	public Void fin() {
		
		return null;
	}
}