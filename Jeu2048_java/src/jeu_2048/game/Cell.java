/**
 * 
 */
package jeu_2048.game;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author nannan_max
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class Cell {
	
	private int entier;


	public Cell(int n) {
		this.entier = n;
	}

	public int getCell() {
		return(this.entier);
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param valEntier
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Void setCell(int valEntier) {
		this.entier = valEntier;
		return null;
	}
}