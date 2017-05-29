package Blatt6_2;

import java.io.*;
import java.util.*;

import Blatt6.Interval;

public class Main {
	public static void main(String args[]){
		String format = null;
		String path = null;
		ArrayList<Interval> A = new ArrayList(1);

		try {
			format = args[0];
		}catch(Exception e){
			System.out.println(e);
		}
		try {
			path = args[1];
		} catch (Exception e) {
			System.out.println("Falsche Eingabe");
			System.out.println(e);

		}
		
		if (path != null) {
			RandomAccessFile file = null;
			try {
				file = new RandomAccessFile(path, "r");
			} catch (FileNotFoundException e) {
				System.out.println("RandomAccesFile Error");
				e.printStackTrace();
			}
			String zeile = null;
			try {
				zeile = file.readLine();
			} catch (IOException e) {
				System.out.println("readLine Error");
				e.printStackTrace();
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
			}

		}

	}
}
