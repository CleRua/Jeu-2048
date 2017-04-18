/**
 * 
 */
package jeu_2048.control;

import jeu_2048.game.Engine;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author nannan_max
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class GameController {

	public Engine engine;


	public GameController(Engine engine) {
		this.engine = engine ;
	}

	public Void updateEngine(char key) {
		if (key == '8'){
			this.engine.up();
		}
		else if (key == '4'){
			this.engine.left();
		}
		else if (key == '5'){
			this.engine.down();
		}
		else if (key == '6'){
			this.engine.right();
		}
		else if (key == 'n'){
			this.engine.nextAutomaticStep();
		}
		else if (key == 'a'){
			this.engine.automaticGame();
		}
		this.engine.ajoutCase();
		this.engine.isOver();
		return null;
		
	}
}