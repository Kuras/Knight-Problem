package test.model;

import static org.junit.Assert.*;

import main.model.ChessBoard;
import main.model.Destination;
import main.model.Knight;

import org.junit.Test;

public class KnightTest {

	@Test
	public void testIfMoveIsLegal() {
		ChessBoard cBoard = new ChessBoard();
		Knight knight = new Knight(2, 2);
		cBoard.setKnight(knight);
		
		assertTrue (knight.nextMoveLegal(cBoard, Destination.TOP_RIGHT));
		
		knight.setLeft(4);
		cBoard.setKnight(knight);
		assertFalse (knight.nextMoveLegal(cBoard, Destination.TOP_RIGHT));
		
		knight.setLeft(0);
		knight.setTop(0);
		cBoard.setKnight(knight);
		assertFalse (knight.nextMoveLegal(cBoard, Destination.TOP_RIGHT));
		Destination destination = Destination.TOP_RIGHT;
		destination = destination.next();
		assertFalse (knight.nextMoveLegal(cBoard, destination));
		
		destination = destination.next();
		assertFalse (knight.nextMoveLegal(cBoard, destination));
		
		destination = destination.next();
		assertFalse (knight.nextMoveLegal(cBoard, destination));
		
		destination = destination.next();
		assertTrue (knight.nextMoveLegal(cBoard, destination));
		knight.move(Destination.RIGHT_DOWN);
		cBoard.setKnight(knight);
	
		destination = Destination.TOP_RIGHT;
		assertFalse (knight.nextMoveLegal(cBoard, destination));
		destination = destination.next();
		assertFalse (knight.nextMoveLegal(cBoard, destination));
		destination = destination.next();
		assertTrue (knight.nextMoveLegal(cBoard, destination));
		destination = destination.next();
		assertTrue (knight.nextMoveLegal(cBoard, destination));
		destination = destination.next();
		assertFalse (knight.nextMoveLegal(cBoard, destination));
		destination = destination.next();
		assertTrue (knight.nextMoveLegal(cBoard, destination));
		destination = destination.next();
		assertTrue (knight.nextMoveLegal(cBoard, destination));
		destination = destination.next();
		assertFalse (knight.nextMoveLegal(cBoard, destination));
		
		
//		cBoard.show();
		
	}
	
	@Test 
	public void testMove(){
		ChessBoard cBoard = new ChessBoard();
		Knight knight = new Knight(2, 2);
		cBoard.setKnight(knight);
		Destination destination = Destination.TOP_RIGHT;
		
		knight.move(destination);
		cBoard.setKnight(knight);
		int top = knight.getTop();
		int left= knight.getLeft();
		
		assertEquals(0, top);
		assertEquals(3, left);

		destination = destination.next();
		destination = destination.next();
		knight.move(destination);
		cBoard.setKnight(knight);
		assertEquals(1, knight.getTop());
		assertEquals(1, knight.getLeft());
		assertEquals(Destination.LEFT_DOWN, destination);
		
		destination = destination.next();
		knight.move(destination);
		cBoard.setKnight(knight);
		assertEquals(0, knight.getTop());
		assertEquals(3, knight.getLeft());
		assertEquals(Destination.RIGHT_TOP, destination);
		
		cBoard.show();

	}
		
}
