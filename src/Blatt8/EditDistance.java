package Blatt8;

import java.util.ArrayList;

public class EditDistance {

	public static int distance(String erster, String zweiter) {
		ArrayList<Character> a = new ArrayList<Character>();
		ArrayList<Character> b = new ArrayList<Character>();
		for (char c : erster.toCharArray()) { // for each füllung
			a.add(c);
		}
		for (char c : zweiter.toCharArray()) {
			b.add(c);
		}
		int m = a.size();
		int n = b.size();
		int calc = 0;
		int i = 0;
		int j = 0;
		while (i < m || j < n) {
			System.out.println(a.get(i) + "-" + b.get(j));
			if (a.get(i) != b.get(j) || i > m || j > n) {
				calc++;
			}

			if (i != m) {

				i++;
			}

			if (j != n) {
				j++;
			}
		}

		return calc;
	}

}
