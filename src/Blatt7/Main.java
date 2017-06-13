package Blatt7;

import java.util.Random;

public class Main {
	static long tStart;
	static long tEnd;
	static long msecs;
	static long avg = 0;
	static int[][] vier;
	static int pointer=1;
	public static void main(String[] args) {

		int leng = 0; // initialisiere eine Varibale für die Länge der zu
						// vergleichenden Arrays

		if (args.length != 1) { // Nur eine Eingabe (länge) erlauben
			System.out.println("Falsche Eingabe");
			return;
		}
		try {
			leng = Integer.parseInt(args[0]); // nur Integereingaben erlauben
			System.out.println(" n=     " + leng);
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Problem bim 'parseInt'");
			return;
		}
		if (leng <= 0) {
			System.out.println("Eingabe zu klein");
			return;
		}
		if (leng >= 147050) { // ab einer größe von 25000 gibt es Probleme 
			System.out.println("Eingabe zu groß");
			return;
		}

		show(leng); // Berechnung und Ausgabe des Vergleichs

	}

	public static void show(int leng) { // (schöne) Ausgabe der errechneten Zeit
										// und widerholhter Aufruf der
										// Berechnung
		String x;
		String y;

		for (int i = 0; i < 5; i++) {
			x = randStr(leng, new Random()); // random Strings der länge leng
												// machen
			y = randStr(leng, new Random());
		//	System.out.println("String 1: " + x);
		//	System.out.println("String 2:" + y);
			timeCalc(x, y);
			avg = (avg + msecs) / 2; // Durchschnitts Laufzeit ermitteln
			System.out.println("|msecs: " + msecs + "|Durchlauf " + (i + 1) + "|");
			System.out.println();
			vier = null;
			System.gc();

		}
		System.out.println("Durschnittslaufzeit: " + avg + " msecs");
	}

	public static int[][] lcs(char[] x, char[] y) { // Durchlauf der Arrays
		int m = x.length;
		int n = y.length;
		int[][] c = new int[m+1][n+1];
		
		for (int i = 0; i <= m; i++) { // fülle erste Zeile mit
			c[i][0] = 0;
		}
		for (int i = 0; i <= n; i++) {
			c[0][i] = 0; // fülle erste Spalte mit
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				lb(x, y, c, i, j); // Längenberechnung
			}
		}

		return c;
	}

	public static void lb(char[] x, char[] y, int[][] c, int i, int j) { // Rekursionsgleichung
		if (x[i-1] == y[j-1]) {
			c[i][j] = (char) (c[i - 1][j - 1] + 1);
			pointer = j;
		} else {
			if (c[i - 1][j] >= c[i][j - 1]) {
				c[i][j] = c[i - 1][j];
			} else {

				c[i][j] = c[i][j - 1];
			}
		}
	}

	static String randStr(int n, Random r) { // erzeuge random String aus einem
												// Random Objekt
		String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder res = new StringBuilder(n);
		while (--n >= 0) {
			res.append(alphabet.charAt(r.nextInt(alphabet.length())));
		}
		return res.toString();
	}

	public static void timeCalc(String x, String y) { // Zeitmesung
		tStart = System.currentTimeMillis();
		vier = lcs(x.toCharArray(), y.toCharArray());
		tEnd = System.currentTimeMillis();

		msecs = tEnd - tStart;
		int check =0;
		//out(vier);
		System.out.println(vier[vier.length-1][vier[0].length-1]);
		for(int i =0; i<vier.length; i++){
			for (int j =1 ; j< vier[i].length; j++){
				if(vier[i][j] != vier[i][j-1] && vier[i][j] > check){
					
					System.out.print(x.toCharArray()[i-1]);
					check++;
				}
			}
		}
	}

	public static void out(int[][] x) {
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[0].length; j++) {
				System.out.print(x[i][j]);
			}
			System.out.println();
		}
	}

}
