package org.greatworksinc.tictactoe;


import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class UserInterfaceTest {

	@Test
	public void validatePlayerChar_emptyInput() {
		assertThat(UserInterface.validatePlayerChar("")).isEqualTo(' ');
	}

	@Test
	public void validatePlayerChar_fiveChars() {
		assertThat(UserInterface.validatePlayerChar("ABCDE")).isEqualTo(' ');
	}

	@Test
	public void validatePlayerChar_upperO() {
		assertThat(UserInterface.validatePlayerChar("O")).isEqualTo('O');
	}

	@Test
	public void validatePlayerChar_lowerO() {
		assertThat(UserInterface.validatePlayerChar("o")).isEqualTo('o');
	}

	@Test
	public void validatePlayerChar_upperX() {
		assertThat(UserInterface.validatePlayerChar("X")).isEqualTo('X');
	}

	@Test
	public void validatePlayerChar_lowerX() {
		assertThat(UserInterface.validatePlayerChar("x")).isEqualTo('x');
	}

	@Test
	public void validatePlayerChar_wrongChar() {
		assertThat(UserInterface.validatePlayerChar("A")).isEqualTo(' ');
	}


}
