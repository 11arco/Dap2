package Blatt3;

public class Main {
	static long tStart;
	static long tEnd;
	static long msecs;

	public static void main(String[] args) {
		if (args.length == 0) {
			aufgabe1();
		}
		else {
			int a = Integer.parseInt(args[0]);
			aufgabe2(a, 1000);
		}

	}

	public static void aufgabe1() {
		int[] array = new int[5000];
		fillArray(array);

		bubble(array);
		System.out.println("Laufzeit:" + msecs);
	}

	public static void aufgabe2(int time, int size) {
		int[] array = new int[size];
		fillArray(array);
		calc(array, time, size);

	}

	public static void calc(int[] array, int time, int size) {
		bubble(array);
		if (msecs == time) {
			System.out.println("Laufzeit:" + msecs);
			System.out.println("Feldgröße:" + size);
		}
		if (msecs < time) {
			System.out.println("Laufzeit:" + msecs);
			System.out.println("Feldgröße:" + size);
			aufgabe2(time, 2 * size);
		}
		if (msecs > time) {
			System.out.println("Laufzeit:" + msecs);
			System.out.println("Feldgröße:" + size);
			if (size != 0) {
				aufgabe2(time, size * 3 / 4);
			}

		}
	}

	public static void bubble(int[] array) {
		tStart = System.currentTimeMillis();
		Main.bubbleSort(array);
		tEnd = System.currentTimeMillis();

		msecs = tEnd - tStart;
	}

	public static void bubbleSort(int[] array) {
		int n = array.length;
		int temp;
		for (int i = 0; i < n; i++) {
			for (int j = n - 1; i < j; j--) {
				if (array[j - 1] > array[j]) {
					temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
				}
			}
		}
	}

	public static void fillArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = array.length - i;

		}
	}
}
