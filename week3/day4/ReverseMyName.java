package week3.day4;

public class ReverseMyName {

	public static void main(String[] args) {
		String input = "Barani Devi";
		// convert string into charArray
		char[] ch = input.toCharArray();

		for (int i = ch.length - 1; i >= 0; i--) 
		{
			System.out.println(ch[i]);
		}

	}

}
