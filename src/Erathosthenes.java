
public class Erathosthenes {
	public static void main(String[] args) {
		int o = 100;
		boolean[] vars = new boolean[o];
		for (int i = 0; i < o; i++) { // fülle array true
			vars[i] = true;
		}
		for (int i = 2; i < vars.length; i++) { // erstewahl
			for (int j = i + 1; j < vars.length; j++) {// zweitewahl
				if (j % i == 0) { // teiltteund zweite wahl
					vars[j] = false; // erstewahl zweite wahl?
				}
			}
		}
		for (int i = 0; i < o; i++) { // Ausgabe
			System.out.print(i + " ");
			System.out.println(vars[i]);
		}
	}

}
