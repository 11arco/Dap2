package Blatt11;

public class Heap {
	int[] values;
	int heapsize;

	public Heap(int n) {
		values = new int[n];
	}

	public int left(int i) {
		return values[2 * i + 1];
	}

	public int right(int i) {
		return values[2 * i + 2];

	}

	public int parent(int i) {
		return values[i / 2 - 1];
	}

	public void heapfy(int i) {
		int temp;
		for (int j = 0; j < this.values.length; j++) {
			if (this.values[i] < values[j]) {
				temp = this.values[j];
				this.values[j] = values[i];
				values[i] = temp;
			}
		}
	}

	public void insert(int key) {
		int temp;
		for (int i = 0; i < this.values.length; i++) {
			if (key < this.values[i] || this.values[i] == 0) {
				temp = this.values[i];
				this.values[i] = key;
				key = temp;
			}
			if (key == 0) {
				return;
			}
			heapfy(i);
		}
	}

	public int extractMax() {
		int max = values[0];
		int index = 0;
		for (int i = 1; i < values.length; i++) {
			if (values[i] > max) {
				max = values[i];
				index = i;
			}
		}
		values[index] = 0;

		return max;
	}

	public void printHeap() {
		int cut = 0;
		for (int i = 0; i < this.values.length; i++) {
			System.out.print(this.values[i] + " ");
			if (i == cut) {
				System.out.println();
				cut = cut + 2 ^ i;
			}
		}
		System.out.println();
	}

	public void count() {
		for (int i = 0; i < values.length; i++) {
			values[i] = i + 1;
		}
	}

	public void fillRandom() {
		for (int i = 0; i < values.length; i++) {
			insert((int) (values.length * Math.random()));
		}
	}

}
