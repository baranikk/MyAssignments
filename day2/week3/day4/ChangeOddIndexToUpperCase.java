package week3.day4;

public class ChangeOddIndexToUpperCase {

	public static void main(String[] args) {

		String test = "changeme";

		// Convert the String to character array
		// find the odd index within the loop (use mod operator)

		char[] arr = test.toCharArray();
		for (int i = 0; i < arr.length; i++)
			if (i % 2 == 0)
				System.out.print(Character.toUpperCase(arr[i]));
			else
				System.out.print(arr[i]);

	}

}
