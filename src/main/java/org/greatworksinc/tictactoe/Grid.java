package org.greatworksinc.tictactoe;

public class Grid {

	private final char[][] board;
	private static final int MIN_SIZE = 2;
	private static final int MAX_SIZE = 5;

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
	}

	public char getCellAt(int row, int col) {
		validate(row, col);
		return board[row][col];
	}

	public boolean setCellAt(int row, int col, char value) {
		validate(row, col);
		if (board[row][col] == ' ') {
			board[row][col] = value;
			return true;
		}
		return false;
	}

	public void printBoard() {
		for (char[] row : board) {
			for (char col : row) {
				System.out.print(col);
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

}
