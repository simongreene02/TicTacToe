import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		String [] arr = {"a","b"};
		Arrays.asList(arr).stream().forEach(System.out::println);

	}
	
	public static String HW() {
		return "Hello World!";
	}

}
