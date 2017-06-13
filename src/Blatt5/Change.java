package Blatt5;

public class Change {

	public static void main(String[] args) {
		String currency = null;
		int b = 0;
		int[] w = {};

		try {											
			currency = args[0];
			System.out.println("Euro");
		} catch (Exception e) {
			System.out.println("falsche Eingabe");
			System.out.println(e);
		}
		try {
			b = Integer.parseInt(args[1]);
		} catch (Exception e) {
			System.out.println("falsche Eingabe");
			System.out.println(e);								//try catch Abfangen von Falscheingaben
		}
		if (currency.equals("Euro")) {
			int[] q = { 200, 100, 50, 20, 10, 5, 2, 1 };		//setzte w für Eingabe Euro
			w = q;
		}
		if (currency.equals("Alternative")) {
			int[] e = { 200, 100, 50, 20, 10, 5, 4, 2, 1 };     //setze w für Eingabe Al..
			w = e;
		}
		Main.show(w);											
		Main.show(change(b, w));								//Ausgabe von Wechselgeld
	}

	public static int[] change(int b, int[] w) {
		int[] cash = new int[w.length];
		int i = 0;
		while (i < w.length) {
			if (w[i] <= b) {
				cash[i] = b / w[i];
				b = b % w[i];
			}
			i++;

		}
		return cash;

	}
}
