package org.greatworksinc.tictactoe;

import java.io.InputStream;
import java.util.Scanner;

import com.google.common.annotations.VisibleForTesting;

public class UserInterface {

	enum UserableChar {
		O, X;
	}

	private static final char SPACE = ' ';
	private final Scanner scanner;
	private UserableChar playerChar;
	private UserableChar computerChar;
	private Grid grid;

	public UserInterface() {
		scanner = new Scanner(System.in);
	}

	@VisibleForTesting
	UserInterface(String input) {
		scanner = new Scanner(input);
	}

	public void play() {
		int size = 0;
		while (!Grid.isValidSize(size)) {
			System.out.println(
					String.format("How large should the board be? Please enter a value from %d to %d (inclusive)",
							Grid.getMinSize(), Grid.getMaxSize()));
			size = Integer.parseInt(scanner.nextLine());
		}
		grid = new Grid(size);
		while (playerChar == null) {
			System.out.println("Which character (O or X) would you like to play?");
			String input = scanner.nextLine();
			playerChar = validatePlayerChar(input);
		}
		switch (playerChar) {
		case O:
			computerChar = UserableChar.X;
			break;
		case X:
			computerChar = UserableChar.O;
			break;
		default:
			throw new UnsupportedOperationException(
					String.format("Player Character value (%s) not allowed", playerChar));
		}

		while (!grid.checkForVictory(playerChar) && !grid.checkForVictory(computerChar) && !grid.isFull()) {
			if (!playerMove()) {
				break;
			}
			if (!grid.checkForVictory(playerChar) && !grid.isFull()) {
				computerMove();
			}
		}
		grid.printBoard();
		if (grid.checkForVictory(playerChar)) {
			System.out.println("Player Wins");
		} else if (grid.checkForVictory(computerChar)) {
			System.out.println("Computer Wins");
		} else if (grid.isFull()) {
			System.out.println("It's a tie");
		} else {
			System.out.println("Quitting Game");
		}
	}

	@VisibleForTesting
	boolean playerMove() {
		grid.printBoard();
		String input;
		do {
			System.out.println();
			System.out.println("Enter coordinate:");
			// Input can be two numbers seperated by a space or comma, uppercase
			// Q, or lowercase q
			input = scanner.nextLine();
			if (input.equalsIgnoreCase("Q")) {
				return false;
			}

		} while (!grid.setCellAt(Location.with(input), playerChar));
		return true;
	}

	@VisibleForTesting
	boolean computerMove() {
		for (int x = 0; x < grid.size(); x++) {
			for (int y = 0; y < grid.size(); y++) {
				Location location = Location.with(x, y);
				if (grid.setCellAt(location, computerChar)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Return the enum if valid, otherwise return null
	 * 
	 * @param input
	 * @return
	 */
	@VisibleForTesting
	static UserableChar validatePlayerChar(String input) {
		if (input.length() == 1) {
			String upperChar = input.toUpperCase();
			if (upperChar.equals("O") || upperChar.equals("X")) {
				return UserableChar.valueOf(upperChar);
			}
		}
		return null;
	}

	@VisibleForTesting
	UserableChar getPlayerChar() {
		return playerChar;
	}

	@VisibleForTesting
	UserableChar getComputerChar() {
		return computerChar;
	}

	@VisibleForTesting
	int getGridSize() {
		return grid.size();
	}
	
	@VisibleForTesting
	UserableChar getWinner() {
		if (grid.checkForVictory(playerChar)) {
			return playerChar;
		}
		if (grid.checkForVictory(computerChar)) {
			return computerChar;
		}
		return null;
	}
}
