public class Euclid {
	public static void main(String[] args) {

		System.out.print(euk(255,225));
	}

	public static int euk(int a, int b) {
		if (a >= 0 && b >= 0) { // sind Eingaben positiv?
			if (b == 0) {
				return a; // Abbruchbedingung
			} else {
				return euk(b, a % b); // Rek-aufruf
			}
		} else {
			return 0;
		}
	}
}