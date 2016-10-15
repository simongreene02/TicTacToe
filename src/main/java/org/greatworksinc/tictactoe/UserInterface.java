package org.greatworksinc.tictactoe;

import java.io.InputStream;
import java.util.Scanner;

import com.google.common.annotations.VisibleForTesting;

public class UserInterface {

	private final Scanner scanner;
	private char playerChar;
	private char computerChar;
	private Grid grid;

	public UserInterface() {
		this(System.in);
	}

	public UserInterface(InputStream input) {
		scanner = new Scanner(input);
	}

	public void play() {
		playerChar = ' ';
		while (playerChar == ' ') {
			System.out.println("Which character (O or X) would you like to play?");
			String input = scanner.nextLine();

			playerChar = validatePlayerChar(input);
		}
		// if (playerChar)

	}

	@VisibleForTesting
	static char validatePlayerChar(String input) {
		if (input.length() == 1) {
			String lowerChar = input.toLowerCase();
			if (lowerChar.equals("o") || lowerChar.equals("x")) {
				return input.charAt(0);
			}
		}
		return ' ';
	}
}
