package org.greatworksinc.tictactoe;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
	
	@Test
	public void checkForHorizontalVictory() {
		grid.setCellAt(0, 0, 'x');
		grid.setCellAt(0, 1, 'x');
		assertTrue(grid.checkForHorizontalVictory('x'));
	}
	
	@Test
	public void checkForHorizontalVictory_wrongChar() {
		grid.setCellAt(0, 0, 'o');
		grid.setCellAt(0, 1, 'o');
		assertFalse(grid.checkForHorizontalVictory('x'));
	}
	
	@Test
	public void checkForHorizontalVictory_wrongAlignment() {
		grid.setCellAt(0, 0, 'x');
		grid.setCellAt(1, 0, 'x');
		assertFalse(grid.checkForHorizontalVictory('x'));
	}
	

	@Test
	public void checkForHorizontalVictory_oneO_oneX() {
		grid.setCellAt(0, 0, 'o');
		grid.setCellAt(0, 1, 'x');
		assertFalse(grid.checkForHorizontalVictory('x'));
	}
	

	@Test
	public void checkForHorizontalVictory_oneX_oneO() {
		grid.setCellAt(0, 0, 'x');
		grid.setCellAt(0, 1, 'o');
		assertFalse(grid.checkForHorizontalVictory('x'));
	}
	
	@Test
	public void checkForVerticalVictory() {
		grid.setCellAt(0, 0, 'x');
		grid.setCellAt(1, 0, 'x');
		assertTrue(grid.checkForVerticalVictory('x'));
	}
	
	@Test
	public void checkForVerticalVictory_wrongChar() {
		grid.setCellAt(0, 0, 'o');
		grid.setCellAt(1, 0, 'o');
		assertFalse(grid.checkForVerticalVictory('x'));
	}
	
	@Test
	public void checkForVerticalVictory_wrongAlignment() {
		grid.setCellAt(0, 0, 'x');
		grid.setCellAt(0, 1, 'x');
		assertFalse(grid.checkForVerticalVictory('x'));
	}
	

	@Test
	public void checkForVerticalVictory_oneO_oneX() {
		grid.setCellAt(0, 0, 'o');
		grid.setCellAt(1, 0, 'x');
		assertFalse(grid.checkForVerticalVictory('x'));
	}
	

	@Test
	public void checkForVerticalVictory_oneX_oneO() {
		grid.setCellAt(0, 0, 'x');
		grid.setCellAt(1, 0, 'o');
		assertFalse(grid.checkForVerticalVictory('x'));
	}
	
	@Test
	public void checkForDiagonalVictoryBackSlash() {
		grid.setCellAt(0, 0, 'x');
		grid.setCellAt(1, 1, 'x');
		assertTrue(grid.checkForDiagonalVictoryBackSlash('x'));
	}
	
	@Test
	public void checkForDiagonalVictoryBackSlash_wrongChar() {
		grid.setCellAt(0, 0, 'o');
		grid.setCellAt(1, 1, 'o');
		assertFalse(grid.checkForDiagonalVictoryBackSlash('x'));
	}
	
	@Test
	public void checkForDiagonalVictoryBackSlash_wrongAlignment() {
		grid.setCellAt(1, 0, 'x');
		grid.setCellAt(0, 1, 'x');
		assertFalse(grid.checkForDiagonalVictoryBackSlash('x'));
	}
	

	@Test
	public void checkForDiagonalVictoryBackSlash_oneO_oneX() {
		grid.setCellAt(0, 0, 'o');
		grid.setCellAt(1, 1, 'x');
		assertFalse(grid.checkForDiagonalVictoryBackSlash('x'));
	}
	

	@Test
	public void checkForDiagonalVictoryBackSlash_oneX_oneO() {
		grid.setCellAt(0, 0, 'x');
		grid.setCellAt(1, 1, 'o');
		assertFalse(grid.checkForDiagonalVictoryBackSlash('x'));
	}
	
	@Test
	public void checkForDiagonalVictoryForwardSlash() {
		grid.setCellAt(0, 1, 'x');
		grid.setCellAt(1, 0, 'x');
		assertTrue(grid.checkForDiagonalVictoryForwardSlash('x'));
	}
	
	@Test
	public void checkForDiagonalVictoryForwardSlash_wrongChar() {
		grid.setCellAt(0, 1, 'o');
		grid.setCellAt(1, 0, 'o');
		assertFalse(grid.checkForDiagonalVictoryForwardSlash('x'));
	}
	
	@Test
	public void checkForDiagonalVictoryForwardSlash_wrongAlignment() {
		grid.setCellAt(0, 0, 'x');
		grid.setCellAt(1, 1, 'x');
		assertFalse(grid.checkForDiagonalVictoryForwardSlash('x'));
	}
	

	@Test
	public void checkForDiagonalVictoryForwardSlash_oneO_oneX() {
		grid.setCellAt(0, 1, 'o');
		grid.setCellAt(1, 0, 'x');
		assertFalse(grid.checkForDiagonalVictoryForwardSlash('x'));
	}
	

	@Test
	public void checkForDiagonalVictoryForwardSlash_oneX_oneO() {
		grid.setCellAt(0, 1, 'x');
		grid.setCellAt(1, 0, 'o');
		assertFalse(grid.checkForDiagonalVictoryForwardSlash('x'));
	}
	
	@Test
	public void checkForVictory_allFilled() {
		grid = new Grid(3);
		grid.checkForVictory(' ');
	}
	
	@Test
	public void checkForVictory_allEmpty() {
		grid = new Grid(3);
		grid.checkForVictory('o');
	}
	
	@Test
	public void isValidSize_positiveInput() {
		assertThat(Grid.isValidSize((Grid.getMaxSize() - Grid.getMinSize()) / 2 + Grid.getMinSize())).isTrue();
	}
	
	@Test
	public void isValidSize_smallInput() {
		assertThat(Grid.isValidSize(Grid.getMinSize() - 1)).isFalse();
	}
	
	@Test
	public void isValidSize_bigInput() {
		assertThat(Grid.isValidSize(Grid.getMaxSize() + 1)).isFalse();
	}
	
	

}
