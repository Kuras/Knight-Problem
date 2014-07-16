package test.model;

import static org.junit.Assert.*;
import main.model.Destination;

import org.junit.Test;

public class DestinationTest {

	@Test
	public void testhasMove() {
		Destination destination = Destination.TOP_RIGHT;
		assertTrue(destination.hasNext());
		destination = Destination.RIGHT_TOP;
		assertTrue(destination.hasNext());
		destination = Destination.RIGHT_DOWN;
		assertTrue(destination.hasNext());
		destination = Destination.DOWN_RIGHT;
		assertTrue(destination.hasNext());
		destination = Destination.DOWN_LEFT;
		assertTrue(destination.hasNext());
		destination = Destination.LEFT_DOWN;
		assertTrue(destination.hasNext());
		destination = Destination.LEFT_TOP;
		assertTrue(destination.hasNext());
		
		destination = Destination.TOP_LEFT;
		assertFalse(destination.hasNext());
		
	}
	
	@Test
	public void testGetTopLeft(){
		Destination destination = Destination.TOP_RIGHT;
		assertEquals(-2, destination.getTop());
		assertEquals(1, destination.getLeft());
		
		destination = Destination.TOP_LEFT;
		assertEquals(-2, destination.getTop());
		assertEquals(-1, destination.getLeft());
		
		destination = Destination.RIGHT_TOP;
		assertEquals(-1, destination.getTop());
		assertEquals(2, destination.getLeft());
		
		destination = Destination.RIGHT_DOWN;
		assertEquals(1, destination.getTop());
		assertEquals(2, destination.getLeft());
		
		destination = Destination.DOWN_RIGHT;
		assertEquals(2, destination.getTop());
		assertEquals(1, destination.getLeft());
		
		destination = Destination.DOWN_LEFT;
		assertEquals(2, destination.getTop());
		assertEquals(-1, destination.getLeft());
		
		destination = Destination.LEFT_DOWN;
		assertEquals(1, destination.getTop());
		assertEquals(-2, destination.getLeft());
		
		destination = Destination.LEFT_TOP;
		assertEquals(-1, destination.getTop());
		assertEquals(-2, destination.getLeft());
		
	}

}
