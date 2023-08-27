package week3.day4;

public class RemoveDuplicates {

	public static void main(String[] args) {
		String text = "We learn java basics as part of java sessions in java week1";
		String[] arr = text.split(" ");
		// loop to check whether the word is there in the array and if it is available
		// then increase and count by 1.
		for (int count = 0; count < arr.length - 1; count++) {
			for (int i = count + 1; i < arr.length; i++) {
				if (arr[count].equalsIgnoreCase(arr[i]))
					arr[i] = "";
			}
		}
		// if the count > 1 then replace the word as ""
		for (int count = 0; count < arr.length; count++)
			System.out.print(arr[count] + " ");
	}

}
