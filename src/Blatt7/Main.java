package Blatt7;

import java.util.Random;

public class Main {
	static long tStart;
	static long tEnd;
	static long msecs;
	static long avg = 0;

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
		if (leng >= 24550) { // ab einer größe von 25000 gibt es Probleme mit
								// String to Array
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
			x = randStr(leng, new Random());
			y = randStr(leng, new Random());
			timeCalc(x, y);
			avg = (avg + msecs) / 2;
			System.out.println("|msecs: " + msecs + "|Durchlauf " + (i + 1) + "|");

		}
		System.out.println("Durschnittslaufzeit: " + avg + " msecs");
	}

	public static char[][] lcs(char[] x, char[] y) { // Durchlauf der Arrays
		int m = x.length;
		int n = y.length;
		char[][] c = new char[m][n];
		for (int i = 0; i < m; i++) {
			c[i][0] = 0;
		}
		for (int i = 0; i < n; i++) {
			c[0][i] = 0;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				lb(x, y, c, i, j);
			}
		}

		return null;
	}

	public static void lb(char[] x, char[] y, char[][] c, int i, int j) { // Reukrsionsgleichung
		if (x[i] == y[j]) {
			c[i][j] = (char) (c[i - 1][j - 1] + 1);
		} else {
			if (c[i - 1][j] >= c[i][j - 1]) {
				c[i][j] = c[i - 1][j];
			} else {
				c[i][j] = c[i][j - 1];
			}
		}
	}

	static String randStr(int n, Random r) { // erzeuge random String aus einem
												// Random Ojekt
		String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder res = new StringBuilder(n);
		while (--n >= 0) {
			res.append(alphabet.charAt(r.nextInt(alphabet.length())));
		}
		return res.toString();
	}

	public static void timeCalc(String x, String y) { // Zeitmesung
		tStart = System.currentTimeMillis();
		lcs(x.toCharArray(), y.toCharArray());
		tEnd = System.currentTimeMillis();

		msecs = tEnd - tStart;
	}

}
