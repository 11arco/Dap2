package Blatt5;

public class Main {
	static long tStart;
	static long tEnd;
	static long msecs;

	public static void main(String[] args) {
		int size = 0;
		try {
			size = Integer.parseInt(args[0]);
		} catch (Exception e) {
			System.out.println("Falsche Eingabe");
			System.out.println(e);
			return;
		}
		if (size < 0) {
			System.out.println("falsche Eingabe");
			System.out.println("positive Zahl erwartet");

			return;
		}
		int[] arr = new int[size];
		fillRan(arr);
		show(arr);
		timeCalc(arr);
		show(arr);
		System.out.println("Berechnungszeit: " + msecs);
		System.out.println("isSorted: " + isSorted(arr));
	}

	public static void show(int[] arr) {
		if (arr.length > 64) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 9) {
				System.out.print("|" + arr[i]);
			} else {
				System.out.print("|0" + arr[i]);

			}
		}
		System.out.println("|");

	}

	public static void fillRan(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((Math.random() * Math.random()) * 100);
		}
	}

	public static void quickSort(int[] A, int l, int r) {

		if (l < r) {
			int i = l;
			int j = r;
			int pivot = A[(l + r) / 2];
			while (i <= j) {
				while (A[i] < pivot) {
					i++;
				}
				while (A[j] > pivot) {
					j--;
				}
				if (i <= j) {
					int tmp = A[i];
					A[i] = A[j];
					A[j] = tmp;
					i++;
					j--;

				}
			}
			quickSort(A, l, j);
			quickSort(A, i, r);
		}
	}

	public static void timeCalc(int[] array) {
		tStart = System.currentTimeMillis();
		quickSort(array, 0, array.length - 1);
		tEnd = System.currentTimeMillis();

		msecs = tEnd - tStart;
	}

	public static void statistic(int[] arr) {
		for (int i = 0; i < 10; i++) {
			fillRan(arr);
			show(arr);
			timeCalc(arr);
			show(arr);
			System.out.println("Berechnungszeit: " + msecs + " msecs");
		}

	}

	public static boolean isSorted(int arr[]) {
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < arr[i - 1]) {
				return false;
			}
		}
		return true;
	}
}
