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
		// a.extractMax();
		// a.printHeap();
		// a.extractMax();
		// a.printHeap();
	}
}
