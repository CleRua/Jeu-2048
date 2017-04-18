/**
 * 
 */
package jeu_2048.game;

import java.util.ArrayList;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author nannan_max
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class Engine {

	public Cell[][] cell = null;
	int width = 4;
	int high = 4;
	public Boolean over = false;

	public Engine() {
		this.cell = new Cell[this.high][this.width];
		for (int i = 0; i < this.high; i++) {
			for (int j = 0; j < this.width; j++) {
				this.cell[i][j] = new Cell(0);
			}
		}
		this.ajoutCase();
		this.ajoutCase();
	}
	
	public Engine(int[][] vals) {
		this.cell = new Cell[this.high][this.width];
		for (int i = 0; i < this.high; i++) {
			for (int j = 0; j < this.width; j++) {
				this.cell[i][j] = new Cell(vals[i][j]);
			}
		}
	}
	public int[][] getVals(){
		int[][] vals = new int[this.high][this.width];
		for (int i = 0; i < this.high; i++) {
			for (int j = 0; j < this.width; j++) {
				vals[i][j]=this.cell[i][j].getCell();
			}}
		return vals;
	}

	public void left() {
		this.rotate();
		this.rotate();
		this.right();
		this.rotate();
		this.rotate();
	}

	public void right() {
		this.moveRight();
		this.fuseRight();
		this.moveRight();
	}

	public void up() {
		this.rotate();
		this.right();
		this.rotate();
		this.rotate();
		this.rotate();
	}

	public void down() {
		this.rotate();
		this.rotate();
		this.rotate();
		this.right();
		this.rotate();
	}

	public void isOver() {
		this.over = true;
		for (int i = 0; i < this.high; i++) {
			for (int j = 0; j < this.width; j++) {
				if ((i > 0) && (this.cell[i][j].getCell() == this.cell[i - 1][j]
								.getCell())) {
					this.over = false;
				}
				if ((j > 0)
						&& (this.cell[i][j].getCell() == this.cell[i][j - 1]
								.getCell())) {
					this.over = false;
				}
				if ((i < this.high - 1)
						&& (this.cell[i][j].getCell() == this.cell[i + 1][j]
								.getCell())) {
					this.over = false;
				}
				if ((j < this.width - 1)
						&& (this.cell[i][j].getCell() == this.cell[i][j + 1]
								.getCell())) {
					this.over = false;
				}
				if (this.cell[i][j].getCell() == 0) {
					this.over = false;
				}
			}
		}
	}

	public Void rotate() {
		Cell[][] valTab = new Cell[this.width][this.high];
		for (int i = 0; i < this.high; i++) {
			for (int j = 0; j < this.width; j++) {
				valTab[i][j] = this.cell[this.high - 1 - j][i];
			}
		}
		this.cell = valTab;
		return null;
		// end-user-code
	}

	public Void moveRight() {
		for (int i = 0; i < this.high; i++) {
			for (int j = this.width - 1; j >= 0; j--) {
				int k = j;
				while ((k + 1 < this.width)
						&& (this.cell[i][k + 1].getCell() == 0)) {
					this.cell[i][k + 1].setCell(this.cell[i][k].getCell());
					this.cell[i][k].setCell(0);
					k++;
				}
			}
		}
		return null;
	}

	public Void fuseRight() {
		for (int i = 0; i < this.high; i++) {
			for (int j = this.width - 1; j >= 0; j--) {
				if ((j + 1 < this.width)
						&& (this.cell[i][j + 1].getCell() == this.cell[i][j]
								.getCell())) {
					this.cell[i][j + 1].setCell(this.cell[i][j].getCell() * 2);
					this.cell[i][j].setCell(0);
				}
			}
		}
		return null;
	}

	public Void ajoutCase() {
		ArrayList<Cell> valVide = this.vide();
		int n = valVide.size();
		if (n != 0) {
			double rnd = Math.random() * 0.999999999999;
			int rnd_case = (int) (rnd * n);
			double rnd_val = Math.random();
			if (rnd_val < 0.8) {
				valVide.get(rnd_case).setCell(2);
			} else {
				valVide.get(rnd_case).setCell(4);
			}
		}
		return null;
	}


	public ArrayList<Cell> vide() {
		ArrayList<Cell> valVide = new ArrayList<Cell> ();
		for(int i=0 ; i<this.high ; i++){
			for(int j=0 ; j<this.width ; j++){
				if(this.cell[i][j].getCell()==0){
					valVide.add(this.cell[i][j]);
				}
			}
		}
		return(valVide);
	}

	
	
	public int score(){
		int score_max = 0;
		for(int i=0 ; i<this.high ; i++){
			for(int j=0 ; j<this.width ; j++){
				if(score_max<this.cell[i][j].getCell()){
					score_max = this.cell[i][j].getCell();
				}
			}
		}
		return(score_max);
	}

	public int getNumberOfSameAdjacentValues(){
		int val = 0 ;
		for (int i = 0; i < this.high; i++) {
			for (int j = 0; j < this.width; j++) {
				if (this.cell[i][j].getCell() != 0){
					if ((i > 0) && (this.cell[i][j].getCell() == this.cell[i - 1][j].getCell())) {
						val += 1;
					}
					if ((j > 0) && (this.cell[i][j].getCell() == this.cell[i][j - 1].getCell())) {
						val += 1;
					}
					if ((i < this.high - 1) && (this.cell[i][j].getCell() == this.cell[i + 1][j].getCell())) {
						val += 1;
					}
					if ((j < this.width - 1) && (this.cell[i][j].getCell() == this.cell[i][j + 1].getCell())) {
						val += 1;
					}
				}
			}
		}
		
		return(val/2);
	}
	public int monotonicite(){
		int val = 0 ;
		for (int i = 0; i < this.high; i++) {
			for (int j = 0; j < this.width; j++) {
				if (this.cell[i][j].getCell() != 0){
					if ((i < this.high - 1) && (this.cell[i][j].getCell() > this.cell[i + 1][j].getCell())) {
						val -= 1;
					}
					if ((i < this.high - 1) && (this.cell[i][j].getCell() < this.cell[i + 1][j].getCell())) {
						val += 1;
					}
					if ((j < this.width - 1) && (this.cell[i][j].getCell() > this.cell[i][j + 1].getCell())) {
						val -= 1;
					}
					if ((j < this.width - 1) && (this.cell[i][j].getCell() < this.cell[i][j + 1].getCell())) {
						val += 1;
					}
				}
			}
		}
		return(val);
	}
	
	public double evaluate(double d, double e, double f){
		double valVide = this.getNumberOfFreeCells()/16.0;
		double valMon = this.monotonicite()/24.0;
		double valAdj = this.getNumberOfSameAdjacentValues()/24.0;
		double numPond = d*valVide + e*valAdj + f*valMon ;
		return(numPond);
	}
	
	
	public void nextAutomaticStep(){
		double x = 0.4;
		double y = 0.4;
		double z = 0.2;
		int [][] vals = this.getVals();
		Engine engineR = new Engine(vals);
		engineR.right();
		Engine engineD = new Engine(vals);
		engineD.down();
		Engine engineL = new Engine(vals);
		engineL.left();
		Engine engineU = new Engine(vals);
		engineU.up();
		double evR = engineR.evaluate(x, y, z);
		double evD = engineD.evaluate(x,y,z);
		double evL = engineL.evaluate(x,y,z);
		double evU = engineU.evaluate(x,y,z);
		double max=evD;
		char c ='d';
		if(max<evL){
			max=evL;
			c='l';
		}
		else if(max<evU){
			max=evU;
			c='u';
		}
		else if(max<evR){
			max=evR;
			c='r';
		}
		
		if (c == 'u'){
			this.up();
		}
		else if (c == 'l'){
			this.left();
		}
		else if (c == 'd'){
			this.down();
		}
		else if (c== 'r'){
			this.right();
		}
		
	}
	
	public void automaticGame(){
		while(!this.over){
			this.nextAutomaticStep();
			this.isOver();
			this.ajoutCase();
		}
	}

	
	
	public int getNumberOfFreeCells() {
		int casesVides = 0;
		for(int i=0 ; i<this.high ; i++){
			for(int j=0 ; j<this.width ; j++){
				if(this.cell[i][j].getCell() == 0){
					casesVides = casesVides + 1 ;
				}
			}
		}
		return(casesVides);
	}
}