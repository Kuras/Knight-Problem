package test.model;

import static org.junit.Assert.*;
import main.model.ChessBoard;
import main.model.Destination;
import main.model.Knight;

import org.junit.Test;

public class ChessBoardThinkerTest {

	@Test
	public void testHasResolver() {
		ChessBoard cb = new ChessBoard();
		cb.setKnight(new Knight(2, 2));
		// 5 on 5 board has resolver
		assertTrue(cb.hasResolved());
		cb.show();
	}
	
	@Test
	public void testRemoveKnight() {
		ChessBoard cb = new ChessBoard();
		Knight knight = new Knight(2, 2);
		Destination destination = Destination.TOP_RIGHT;
		cb.setKnight(knight );
		knight.move(destination);
		cb.setKnight(knight);
		cb.moveBack(knight, destination);
	
		assertEquals(Destination.TOP_RIGHT, destination);
		
		destination = destination.next();
		knight.move(destination);
		cb.setKnight(knight);
		cb.moveBack(knight, destination);
		assertNotEquals(Destination.TOP_RIGHT, destination);
		
//		cb.show();
	}
	
	@Test
	public void testIsFull() {
		ChessBoard cb = new ChessBoard();

		assertFalse(cb.isFull());

		Knight knight = new Knight();
		for (int i = 0; i < cb.HEIGHT; i++) {
			for (int j = 0; j < cb.WIDTH; j++) {
				knight.setTop(i);
				knight.setLeft(j);
				cb.setKnight(knight);
			}
		}

		assertTrue(cb.isFull());

		cb.moveBack(knight, Destination.TOP_RIGHT);

		assertFalse(cb.isFull());
	}

	@Test
	public void testSetRemoveKnight() {
		ChessBoard cb = new ChessBoard();

		Knight knight = new Knight(2,2);
		cb.setKnight(knight);

		Destination destination = Destination.TOP_RIGHT;
		cb.moveBack(knight, destination );
		assertFalse(cb.fieldFulled(knight));
		
		knight = new Knight(3,4);
		cb.setKnight(knight);

		cb.moveBack(knight, destination);
		assertFalse(cb.fieldFulled(knight));
		
	//	knight = new Knight(5,5);
	//	cb.setKnight(knight);
		
	}

}
