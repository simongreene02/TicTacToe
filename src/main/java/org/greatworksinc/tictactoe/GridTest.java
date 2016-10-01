package org.greatworksinc.tictactoe;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GridTest {

	
	private Grid grid;
	@Before
	public void setUp() {
		grid = new Grid(2);
	}
	@Test
	public void getCellAt() {
		assertEquals(' ', grid.getCellAt(0, 0));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void getCellAt_columnOutOfBounds() {
		grid.getCellAt(0, 3);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void getCellAt_rowOutOfBounds() {
		grid.getCellAt(3, 0);
	}
	
	@Test
	public void setCellAt() {
		assertTrue(grid.setCellAt(0, 0, 'X'));
	}
	
	@Test
	public void setCellAt_nonEmptyLocation() {
		assertTrue(grid.setCellAt(0, 0, 'O'));
		assertFalse(grid.setCellAt(0, 0, 'X'));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setCellAt_columnOutOfBounds() {
		grid.getCellAt(0, 3);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setCellAt_rowOutOfBounds() {
		grid.getCellAt(3, 0);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void gridSmallSize() {
		new Grid(1);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void gridLargeSize() {
		new Grid(10);
	}
	
	
	

}
