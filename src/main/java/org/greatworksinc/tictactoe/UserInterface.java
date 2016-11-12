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

	@VisibleForTesting UserInterface(String input) {
		scanner = new Scanner(input);
	}

	public void play() {
		int size = 0;
		while (!Grid.isValidSize(size)) {
			System.out.println(String.format(
					"How large should the board be? Please enter a value from %d to %d (inclusive)",
					Grid.getMinSize(), Grid.getMaxSize()));
			size = scanner.nextInt();
		}
		grid = new Grid(size);
		while (playerChar == null) {
			System.out.println("Which character (O or X) would you like to play?");
			String input = scanner.nextLine();

			playerChar = validatePlayerChar(input);
			System.out.println(playerChar);
		}
		switch(playerChar) {
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
		
		System.out.println("End of method (I think)");
		
//		while(noOneHasWon) {
//			if (playermove = true) {
//				break
//			}
//			if (!victory or tie) {
//				computerMoves
//			}
//		}
	}
	
	@VisibleForTesting boolean playerMove() {
		grid.printBoard();
		System.out.println();
		System.out.println("Enter coordinate:");
		//Input can be two numbers seperated by a space or comma, uppercase Q, or lowercase q
		String input = scanner.nextLine();
		if (input.equalsIgnoreCase("Q")) {
			return false;
		}
		
		grid.setCellAt(Location.with(input), playerChar);
	}

	/**
	 * Return the enum if valid, otherwise return null
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

	@VisibleForTesting UserableChar getPlayerChar() {
		return playerChar;
	}

	@VisibleForTesting UserableChar getComputerChar() {
		return computerChar;
	}

	@VisibleForTesting int getGridSize() {
		return grid.size();
	}
}
