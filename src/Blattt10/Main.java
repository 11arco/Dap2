package Blattt10;

public class Main {
	public static void main(String[] args) {
		int n = 0;
		if (args.length == 1) {
			try {
				n = Integer.parseInt(args[0]);
			} catch (Exception e) {
				System.out.println(e);
				return;
			}
		} else {
			System.out.println("Falsche Einagbe");
			return;
		}

		move(n, 'A', 'B', 'C');
	}

	public static void move(int quantity, char start, char help, char target) {
		if (quantity == 1) {
			System.out.println("Verschiebe oberste Scheibe von " + start + " nach " + target);
		} else {
			move(quantity - 1, start, target, help);
			move(1, start, help, target);
			move(quantity - 1, help, start, target);
		}
	}
}
