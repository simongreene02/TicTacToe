package org.greatworksinc.tictactoe;


import static com.google.common.truth.Truth.assertThat;

import org.greatworksinc.tictactoe.UserInterface.UserableChar;
import org.junit.Test;

public class UserInterfaceTest {

	@Test
	public void validatePlayerChar_emptyInput() {
		assertThat(UserInterface.validatePlayerChar("")).isNull();
	}

	@Test
	public void validatePlayerChar_fiveChars() {
		assertThat(UserInterface.validatePlayerChar("ABCDE")).isNull();
	}

	@Test
	public void validatePlayerChar_upperO() {
		assertThat(UserInterface.validatePlayerChar("O")).isEqualTo(UserableChar.O);
	}

	@Test
	public void validatePlayerChar_lowerO() {
		assertThat(UserInterface.validatePlayerChar("o")).isEqualTo(UserableChar.O);
	}

	@Test
	public void validatePlayerChar_upperX() {
		assertThat(UserInterface.validatePlayerChar("X")).isEqualTo(UserableChar.X);
	}

	@Test
	public void validatePlayerChar_lowerX() {
		assertThat(UserInterface.validatePlayerChar("x")).isEqualTo(UserableChar.X);
	}

	@Test
	public void validatePlayerChar_wrongChar() {
		assertThat(UserInterface.validatePlayerChar("A")).isNull();
	}


}
