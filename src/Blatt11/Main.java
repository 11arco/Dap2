package Blatt11;

public class Main {
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("Falsche Eingabe");
			return;
		}
		try {
			if (Integer.parseInt(args[0]) < 0) {
				System.out.println("Falsche Eingbe");
				return;
			}
		} catch (Exception e) {
			System.out.println(e);
			return;
		}

		Heap a = new Heap(Integer.parseInt(args[0]));
		a.fillRandom();
		a.printHeap();
		System.out.println();
		System.out.println("Fill " + args[1]);
		System.out.println();
		a.insert(Integer.parseInt(args[1]));
		a.printHeap();
		prio(a);
		a.printHeap();

	}

	public static void prio(Heap arr) {
		for (int i = 0; i < arr.values.length; i++) {
			System.out.println("remove: " + arr.extractMax());
			// arr.printHeap();
			// System.out.println();

		}
	}
}
