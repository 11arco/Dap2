package Blatt6;

import java.util.*;

public class Anwendung {
	public static ArrayList<Interval> intervalScheduling(ArrayList<Interval> intervalls) {

		int n = intervalls.size();
		ArrayList<Interval> A = new ArrayList();
		A.add(intervalls.get(0));
		int j = 0;

		for (int i = 1; i < n; i++) {
			if (intervalls.get(i).getStart() >= intervalls.get(j).getEnd()) {
				A.add(intervalls.get(i));
				j = i;
			}
		}
		return A;
	}
}
