package week4.day2;
import java.util.LinkedHashSet;
import java.util.Set;

public class PrintUniqChar {

	public static void main(String[] args) {
		String name = "Barani";
		char[] charArray = name.toCharArray();
		Set<Character> unique = new LinkedHashSet<Character>();
		for (Character ch : charArray) {
			if (unique.contains(ch))
				unique.remove(ch);
			else
				unique.add(ch);

		}
		System.out.println(unique);

	}

}