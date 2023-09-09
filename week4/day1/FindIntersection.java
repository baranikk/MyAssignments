package week4.day1;

import java.util.ArrayList;
import java.util.List;

public class FindIntersection {

	public static void main(String[] args) {
		int[] a = { 3, 2, 11, 4, 6, 7 };
		int[] b = { 1, 2, 8, 4, 9, 7 };
		List<Integer> l1 = new ArrayList<Integer>();
		List<Integer> l2 = new ArrayList<Integer>();
		for (int i = 0; i < a.length; i++)
			l1.add(a[i]);
		for (int j = 0; j < b.length; j++)
			l2.add(b[j]);
		System.out.print("List 1:" + l1 + "\n");
		System.out.print("List 2:" + l2 + "\n");
		List<Integer> duplicates = new ArrayList<Integer>();
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if (a[i] == b[j]) {
					duplicates.add(a[i]);
					continue;
				}

			}
		}
		System.out.print("Duplicates: " + duplicates);
	}

}
