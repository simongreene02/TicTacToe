import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;


/**
 * @author JGD
 * @since 10/29/16
 */
public class PlaceholderTest {

  @Test
  public void inputStringWithPrompt() {
    String userInput = "I am fine. Thank you.";
    Placeholder userInputProcessor = new Placeholder(userInput);
    assertThat(userInputProcessor.inputStringWithPrompt("How are you?"))
        .isEqualTo(userInput);
  }

  @Test
  public void inputTwoStringsWithPrompt() {
    String expected = "First input is I am fine. Thank you.. Second input is I am from Chicago.";
    String userInput = "I am fine. Thank you.\nI am from Chicago.";
    Placeholder userInputProcessor = new Placeholder(userInput);
    assertThat(userInputProcessor.inputTwoStringsWithPrompt("How are you?", "Where are you from?"))
        .isEqualTo(expected);
  }

}