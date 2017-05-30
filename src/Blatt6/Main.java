package Blatt6;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		String path = null;
		ArrayList<Interval> A = new ArrayList(1);

		try {
			path = args[0];
		} catch (Exception e) {
			System.out.println("Falsche Eingabe");
			System.out.println(e);
			return;

		}
		if (path != null) {
			RandomAccessFile file = null;
			try {
				file = new RandomAccessFile(path, "r");
			} catch (FileNotFoundException e) {
				System.out.println("RandomAccesFile Error");
				e.printStackTrace();
				return;
			}
			String zeile = null;
			try {
				zeile = file.readLine();
			} catch (IOException e) {
				System.out.println("readLine Error");
				e.printStackTrace();
				return;
			}
			StringTokenizer st = new StringTokenizer(zeile, ",");
			int start = Integer.parseInt(st.nextToken());
			int ende = Integer.parseInt(st.nextToken());
			Interval ivall = new Interval(start, ende);
			try {
				while (zeile != null) {
					st = new StringTokenizer(zeile, ",");
					start = Integer.parseInt(st.nextToken());
					ende = Integer.parseInt(st.nextToken());
					ivall = new Interval(start, ende);

					A.add(ivall);
					zeile = file.readLine();
				}
			} catch (IOException e) {
				System.out.println("Fehler beim parseInt");
				e.printStackTrace();
				return;
			}

		}
		showIntervalle(A);
		Collections.sort(A);
		showIntervalle(A);
		ArrayList<Interval> B = Blatt6.Anwendung.intervalScheduling(A);
		showIntervalle(B);

	}

	public static void showIntervalle(ArrayList<Interval> b) {
		for (int i = 0; i < (b).size(); i++) {
			System.out.print(b.get(i).toSrting());

		}
		System.out.println();
	}
}
