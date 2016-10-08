package org.greatworksinc.tictactoe;

import com.google.common.annotations.VisibleForTesting;

public class Grid {
	private static final int MIN_SIZE = 2;
	private static final int MAX_SIZE = 5;
	private final int size;
	private final char[][] board;
	

	public Grid(int size) {
		if (size < MIN_SIZE) {
			throw new IllegalArgumentException("All grids created must have a size of at least " + MIN_SIZE);
		}
		if (size > MAX_SIZE) {
			throw new IllegalArgumentException("All grids created can have a size of at most " + MAX_SIZE);
		}
		board = new char[size][size];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = ' ';
			}
		}
		this.size = size;
	}

	public char getCellAt(int row, int col) {
		validate(row, col);
		return board[row][col];
	}

	public boolean setCellAt(int row, int col, char playerChar) {
		validate(row, col);
		if (board[row][col] == ' ') {
			board[row][col] = playerChar;
			return true;
		}
		return false;
	}

	public void printBoard() {
		for (char[] row : board) {
			for (char cell : row) {
				System.out.print(cell);
			}
			System.out.println();
		}
	}

	private void validate(int row, int col) {
		if (row >= board.length || row < 0) {
			throw new IllegalArgumentException("All grids created must have a size of at least ");
		}
		if (col >= board[row].length || col < 0) {
			throw new IllegalArgumentException("All grids created can have a size of at most " + MAX_SIZE);
		}
	}
	
	public boolean checkForVictory(char playerChar) {
		return checkForDiagonalVictoryBackSlash(playerChar) 
				|| checkForDiagonalVictoryForwardSlash(playerChar)
				|| checkForHorizontalVictory(playerChar)
				|| checkForVerticalVictory(playerChar);
	}
	
	@VisibleForTesting boolean checkForHorizontalVictory(char playerChar) {
		for (char[] row : board) {
			boolean victory = true;
			for (char cell : row) {
				if (cell != playerChar) {
					victory = false;
					break;
				}
			}
			if (victory) {
				return true;
			}
			
		}
		return false;
	}
	
	@VisibleForTesting boolean checkForVerticalVictory(char playerChar) {
		for (int col = 0; col < size; col++) {
			boolean victory = true;
			for (int row = 0; row < size; row++) {
				if (board[row][col] != playerChar) {
					victory = false;
					break;
				}
			}
			if (victory) {
				return true;
			}
		}
		return false;
	}
	
	@VisibleForTesting boolean checkForDiagonalVictoryBackSlash(char playerChar) {
		for (int i = 0; i < size; i++) {
			if (board[i][i] != playerChar) {
				return false;
			}
		}
		return true;
	}
	
	@VisibleForTesting boolean checkForDiagonalVictoryForwardSlash(char playerChar) {
		for (int i = 0; i < size; i++) {
			if (board[i][size-1-i] != playerChar) {
				return false;
			}
		}
		return true;
	}

}
