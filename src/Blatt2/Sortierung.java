package Blatt2;

public class Sortierung {
	static boolean check = true;

	public static void main(String[] args) {
		int[] values = { 20, 5, 6, 16, 4, 12 };
		mergeSort(values);
	}

	public static void insertionSort(int[] array) {
		for (int j = 2; j <= array.length; j++) {
			int key = array[j];
			int i = j - 1;
			while (i > 0 && array[i] > key) {
				array[i + 1] = array[i];
				i = i - 1;
			}
			array[i + 1] = key;
		}
	}

	public static boolean isSorted(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] > array[i + 1]) {
				return false;
			}
		}
		return true;
	}

	public static void mergeSort(int[] array) {
		int[] tmpArray = new int[array.length];
		mergeSort(array, tmpArray, 0, array.length - 1);
		assert isSorted(array);
	}

	public static void mergeSort(int[] array, int[] tmpArray, int left, int right) {
		if (left < right) {
			int q = ((left + right) / 2);
			if (check) {
				check = false;
				for (int i = 0; i < tmpArray.length; i++) {
					tmpArray[i] = array[i];
				}
			}
			mergeSort(array, tmpArray, left, q);
			System.out.println(left+""+right);
			mergeSort(array, tmpArray, q + 1, right);
			merge(array, tmpArray, left, right, q);

		}

	}

	public static void merge(int[] array, int[] tmpArray, int left, int right, int q) {

		if (array[left] < array[right]) {

		} else {
			tmpArray[left] = array[right];
			tmpArray[right] = array[left];
			for (int i = 0; i < q + 2; i++) {
				array[i] = tmpArray[i];
			}

		}

	}

}
