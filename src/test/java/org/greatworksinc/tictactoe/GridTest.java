package org.greatworksinc.tictactoe;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.greatworksinc.tictactoe.UserInterface.UserableChar;
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
		assertThat(grid.getCellAt(Location.with(0, 0))).isNull();
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void getCellAt_columnOutOfBounds() {
		grid.getCellAt(Location.with(0, 3));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void getCellAt_rowOutOfBounds() {
		grid.getCellAt(Location.with(3, 0));
	}
	
	@Test
	public void setCellAt() {
		assertTrue(grid.setCellAt(Location.with(0, 0), UserableChar.X));
	}
	
	@Test
	public void setCellAt_nonEmptyLocation() {
		assertTrue(grid.setCellAt(Location.with(0, 0), UserableChar.O));
		assertFalse(grid.setCellAt(Location.with(0, 0), UserableChar.X));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setCellAt_columnOutOfBounds() {
		grid.getCellAt(Location.with(0, 3));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setCellAt_rowOutOfBounds() {
		grid.getCellAt(Location.with(3, 0));
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
		grid.setCellAt(Location.with(0, 0), UserableChar.X);
		grid.setCellAt(Location.with(0, 1), UserableChar.X);
		assertTrue(grid.checkForHorizontalVictory(UserableChar.X));
	}
	
	@Test
	public void checkForHorizontalVictory_wrongChar() {
		grid.setCellAt(Location.with(0, 0), UserableChar.O);
		grid.setCellAt(Location.with(0, 1), UserableChar.O);
		assertFalse(grid.checkForHorizontalVictory(UserableChar.X));
	}
	
	@Test
	public void checkForHorizontalVictory_wrongAlignment() {
		grid.setCellAt(Location.with(0, 0), UserableChar.X);
		grid.setCellAt(Location.with(1, 0), UserableChar.X);
		assertFalse(grid.checkForHorizontalVictory(UserableChar.X));
	}
	

	@Test
	public void checkForHorizontalVictory_oneO_oneX() {
		grid.setCellAt(Location.with(0, 0), UserableChar.O);
		grid.setCellAt(Location.with(0, 1), UserableChar.X);
		assertFalse(grid.checkForHorizontalVictory(UserableChar.X));
	}
	

	@Test
	public void checkForHorizontalVictory_oneX_oneO() {
		grid.setCellAt(Location.with(0, 0), UserableChar.X);
		grid.setCellAt(Location.with(0, 1), UserableChar.O);
		assertFalse(grid.checkForHorizontalVictory(UserableChar.X));
	}
	
	@Test
	public void checkForVerticalVictory() {
		grid.setCellAt(Location.with(0, 0), UserableChar.X);
		grid.setCellAt(Location.with(1, 0), UserableChar.X);
		assertTrue(grid.checkForVerticalVictory(UserableChar.X));
	}
	
	@Test
	public void checkForVerticalVictory_wrongChar() {
		grid.setCellAt(Location.with(0, 0), UserableChar.O);
		grid.setCellAt(Location.with(1, 0), UserableChar.O);
		assertFalse(grid.checkForVerticalVictory(UserableChar.X));
	}
	
	@Test
	public void checkForVerticalVictory_wrongAlignment() {
		grid.setCellAt(Location.with(0, 0), UserableChar.X);
		grid.setCellAt(Location.with(0, 1), UserableChar.X);
		assertFalse(grid.checkForVerticalVictory(UserableChar.X));
	}
	

	@Test
	public void checkForVerticalVictory_oneO_oneX() {
		grid.setCellAt(Location.with(0, 0), UserableChar.O);
		grid.setCellAt(Location.with(1, 0), UserableChar.X);
		assertFalse(grid.checkForVerticalVictory(UserableChar.X));
	}
	

	@Test
	public void checkForVerticalVictory_oneX_oneO() {
		grid.setCellAt(Location.with(0, 0), UserableChar.X);
		grid.setCellAt(Location.with(1, 0), UserableChar.O);
		assertFalse(grid.checkForVerticalVictory(UserableChar.X));
	}
	
	@Test
	public void checkForDiagonalVictoryBackSlash() {
		grid.setCellAt(Location.with(0, 0), UserableChar.X);
		grid.setCellAt(Location.with(1, 1), UserableChar.X);
		assertTrue(grid.checkForDiagonalVictoryBackSlash(UserableChar.X));
	}
	
	@Test
	public void checkForDiagonalVictoryBackSlash_wrongChar() {
		grid.setCellAt(Location.with(0, 0), UserableChar.O);
		grid.setCellAt(Location.with(1, 1), UserableChar.O);
		assertFalse(grid.checkForDiagonalVictoryBackSlash(UserableChar.X));
	}
	
	@Test
	public void checkForDiagonalVictoryBackSlash_wrongAlignment() {
		grid.setCellAt(Location.with(1, 0), UserableChar.X);
		grid.setCellAt(Location.with(0, 1), UserableChar.X);
		assertFalse(grid.checkForDiagonalVictoryBackSlash(UserableChar.X));
	}
	

	@Test
	public void checkForDiagonalVictoryBackSlash_oneO_oneX() {
		grid.setCellAt(Location.with(0, 0), UserableChar.O);
		grid.setCellAt(Location.with(1, 1), UserableChar.X);
		assertFalse(grid.checkForDiagonalVictoryBackSlash(UserableChar.X));
	}
	

	@Test
	public void checkForDiagonalVictoryBackSlash_oneX_oneO() {
		grid.setCellAt(Location.with(0, 0), UserableChar.X);
		grid.setCellAt(Location.with(1, 1), UserableChar.O);
		assertFalse(grid.checkForDiagonalVictoryBackSlash(UserableChar.X));
	}
	
	@Test
	public void checkForDiagonalVictoryForwardSlash() {
		grid.setCellAt(Location.with(0, 1), UserableChar.X);
		grid.setCellAt(Location.with(1, 0), UserableChar.X);
		assertTrue(grid.checkForDiagonalVictoryForwardSlash(UserableChar.X));
	}
	
	@Test
	public void checkForDiagonalVictoryForwardSlash_wrongChar() {
		grid.setCellAt(Location.with(0, 1), UserableChar.O);
		grid.setCellAt(Location.with(1, 0), UserableChar.O);
		assertFalse(grid.checkForDiagonalVictoryForwardSlash(UserableChar.X));
	}
	
	@Test
	public void checkForDiagonalVictoryForwardSlash_wrongAlignment() {
		grid.setCellAt(Location.with(0, 0), UserableChar.X);
		grid.setCellAt(Location.with(1, 1), UserableChar.X);
		assertFalse(grid.checkForDiagonalVictoryForwardSlash(UserableChar.X));
	}
	

	@Test
	public void checkForDiagonalVictoryForwardSlash_oneO_oneX() {
		grid.setCellAt(Location.with(0, 1), UserableChar.O);
		grid.setCellAt(Location.with(1, 0), UserableChar.X);
		assertFalse(grid.checkForDiagonalVictoryForwardSlash(UserableChar.X));
	}
	

	@Test
	public void checkForDiagonalVictoryForwardSlash_oneX_oneO() {
		grid.setCellAt(Location.with(0, 1), UserableChar.X);
		grid.setCellAt(Location.with(1, 0), UserableChar.O);
		assertFalse(grid.checkForDiagonalVictoryForwardSlash(UserableChar.X));
	}
	
	@Test
	public void checkForVictory_allFilled() {
		grid = new Grid(3);
		grid.checkForVictory(null);
	}
	
	@Test
	public void checkForVictory_allEmpty() {
		grid = new Grid(3);
		grid.checkForVictory(UserableChar.O);
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
