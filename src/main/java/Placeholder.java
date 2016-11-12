import java.util.Scanner;

import com.google.common.annotations.VisibleForTesting;

/**
 * @author JGD
 * @since 10/29/16
 */
public class Placeholder {

  private final Scanner scanner;

  public Placeholder() {
    scanner = new Scanner(System.in);
  }

  @VisibleForTesting Placeholder(String input) {
    scanner = new Scanner(input);
  }

  public String inputStringWithPrompt(String message) {
    System.out.println(message);
    return scanner.nextLine();
  }

  public String inputTwoStringsWithPrompt(String message1, String message2) {
    System.out.println(message1);
    String input1 = scanner.nextLine();
    System.out.println(message2);
    String input2 = scanner.nextLine();
    return "First input is " + input1 + ". Second input is " + input2;
  }
}
