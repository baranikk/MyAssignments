package week4.day2;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicateLetters {

	public static void main(String[] args) {
		String com = "PayPal India";
		char[] charArr = com.toCharArray();
		Set<Character> charSet = new LinkedHashSet<Character>();
		Set<Character> dupCharSet = new LinkedHashSet<Character>();
		for (char ch : charArr)
			if (charSet.contains(ch))
				dupCharSet.add(ch);
			else
				charSet.add(ch);
		System.out.println("After removing " + dupCharSet + " from " + charSet);
		charSet.removeAll(dupCharSet);
		System.out.println(charSet);
		for (char ch : charSet)
			if (ch != ' ')
				System.out.print(ch);

	}

}