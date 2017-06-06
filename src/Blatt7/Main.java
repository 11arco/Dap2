package Blatt7;

import java.util.Random;

public class Main {
	static long tStart;
	static long tEnd;
	static long msecs;

	public static void main(String[] args) {

		int leng = 0;

		if (args.length != 1) {
			System.out.println("Falsche Eingabe");
			return;
		}
		try {
			leng = Integer.parseInt(args[0]);
			System.out.println(leng);
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Problem bim 'parseInt'");
			return;
		}

		show(leng);

	}

	public static void show(int leng) {
		String x;
		String y;

		for (int i = 0; i < 5; i++) {
			x = randStr(leng, new Random());
			y = randStr(leng, new Random());
			timeCalc(x, y);
			System.out.println(msecs);

		}
	}

	public static char[][] lcs(char[] x, char[] y) {
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

	public static void lb(char[] x, char[] y, char[][] c, int i, int j) {
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

	static String randStr(int n, Random r) {
		String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder res = new StringBuilder(n);
		while (--n >= 0) {
			res.append(alphabet.charAt(r.nextInt(alphabet.length())));
		}
		return res.toString();
	}

	public static void timeCalc(String x, String y) {
		System.out.println("run");
		tStart = System.currentTimeMillis();
		lcs(x.toCharArray(), y.toCharArray());
		tEnd = System.currentTimeMillis();

		msecs = tEnd - tStart;
	}

}
