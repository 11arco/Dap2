package Baltt10_naiv;

public class Main {
	public static void main(String args[]) {
		int[] values = new int[args.length];
		try {
			for (int i = 0; i < args.length; i++) {
				values[i] = Integer.parseInt(args[i]);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(naiv(values));
	}

	public static int sum(int[] values) {
		int sum = 0;
		for (int i = 0; i < values.length; i++) {
			sum = sum + values[i];
		}
		return sum;
	}

	public static boolean onlyPos(int[] values) {
		for (int i = 0; i < values.length; i++) {
			if (values[i] < 0) {
				return false;
			}
		}
		return true;
	}

	public static int naiv(int[] values) {
		int maxSum = 0;
		int sum = 0;
		int q = 0;
		if (onlyPos(values)) {
			System.out.println(sum(values));
		} else {
			for (int i = 0; i <= values.length; i++) {
				if (sum > maxSum) {
					maxSum = sum;
					sum = 0;
				}
				for (int j = i; j < values.length; j++) {
					if (values[j] >= 0) {
						sum = sum + values[j];
					} else {
						i = j;
						j = values.length;

					}
					if(j == values.length-1){
						
						i = values.length-1;
					}
				}
		
			}
		}
		return maxSum;
	}
}
