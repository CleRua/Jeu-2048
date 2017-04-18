package jeu_2048.game;

import static org.junit.Assert.*;

import org.junit.Test;

public class EngineTest {

	@Test
	public void testEngine() {

		Engine engine = new Engine();
		assertEquals(engine.width * engine.high - 2, engine.getNumberOfFreeCells());
	}
	

	@Test
	public void testGetNumberOfFreeCells() {
		int[][] vals = {{0,2,0,0},{2,4,0,8},{0,0,0,2},{16,4,0,16}};
		Engine engine = new Engine(vals);
		assertEquals(8, engine.getNumberOfFreeCells());
	}
	@Test
	public void testRotate(){
		int[][] vals = {{0,2,0,0},{2,4,0,8},{0,0,0,2},{16,4,0,16}};
		//0 2 0 0      16 0 2 0
		//2 4 0 8	   4  0 4 2
		//0 0 0 2	   0  0 0 0
		//16 4 0 16    16 2 8 0
		int[][] ex = {{16,0,2,0},{4,0,4,2},{0,0,0,0},{16,2,8,0}};
		Engine engine = new Engine(vals);
		engine.rotate();
		assertEquals(engine.getVals(),ex );
	}
	
	@Test
	public void testRight(){
		int[][] vals = {{2,2,2,2},{2,2,2,2},{2,2,4,4},{2,4,2048,2048}};
		//2 2 2 2           0 0 4 4
		//2 2 2 2	        0 0 4 4
		//2 2 4 4	        0 0 4 8
		//2 4 2048 2048     0 2 4 4096
		int[][] ex = {{0,0,4,4},{0,0,4,4},{0,0,4,8},{0,2,4,4096}};
		Engine engine = new Engine(vals);
		engine.right();
		assertEquals(engine.getVals(),ex );
	}
	@Test
	public void testLeft(){
		int[][] vals = {{2,2,2,2},{2,2,2,2},{2,2,4,4},{2,4,2048,2048}};
		//2 2 2 2            4 4 0 0
		//2 2 2 2	         4 4 0 0
		//2 2 4 4	         4 8 0 0
		//2 4 2048 2048      2 4 4096 0
		int[][] ex = {{4,4,0,0},{4,4,0,0},{4,8,0,0},{2,4,4096,0}};
		Engine engine = new Engine(vals);
		engine.left();
		assertEquals(engine.getVals(),ex );
	}
	@Test
	public void TestScore(){
		int[][] vals = {{2,2,2,2},{2,2,2,2},{2,2,4,4},{2,4,2048,2048}};
		Engine engine = new Engine(vals);
		assertEquals(engine.score(),2048);
	}
	
	@Test
	public void testIsOver() {
		int[][] vals = {{2,4,2,4},{4,2,16,2},{2,16,4,8},{4,32,1024,2048}};
		Engine engine = new Engine(vals);
		engine.isOver();
		assertEquals(engine.over,true);
	}
	
	@Test
	public void testGetNumberOfSameAdjacentValues() {
	    //  2  2  0  8
	    //  2  4  0  8
	    //  0  4  0 16
	    //  4  4  0 16
	    int[][] vals = {{2,2,0,8},{2,4,0,8},{0,4,0,16},{4,4,0,16}};
	    int[][] vals2 = {{2,2,2,2},{2,2,2,2},{2,2,2,2},{2,2,2,2}};
	    Engine engine = new Engine(vals);
	    Engine engine2 = new Engine(vals2);
	    assertEquals(7, engine.getNumberOfSameAdjacentValues());
	    assertEquals(24, engine2.getNumberOfSameAdjacentValues());
	}
	
	@Test
	public void testMonotonicite() {
	    //  32  16  8  4
	    //  16  8   4  0
	    //  8  4    0  0
	    //  4  0    0  0
	    int[][] vals = {{32,16,8,4},{16,8,4,0},{8,4,0,0},{4,0,0,0}};
	    int[][] vals2 = {{128,64,32,16},{64,32,16,8},{32,16,8,4},{16,8,4,2}};
	    Engine engine = new Engine(vals);
	    Engine engine2 = new Engine(vals2);
	    assertEquals(-18, engine.monotonicite());
	    assertEquals(-24, engine2.monotonicite());
	}
	
	@Test
	public void testEvaluate() {
	    int[][] vals = {{128,64,32,16},{64,32,16,8},{32,16,8,4},{16,8,4,2}};
	    Engine engine = new Engine(vals);
	    assertEquals(-0.4, engine.evaluate(0.3,0.3,0.4),0.000001);
	}
}
