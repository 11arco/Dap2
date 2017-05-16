package Blatt4;

public class Point {
	private double[] dimValues;
	private int dim;

	public Point(double[] dimValues) {
		try {
			this.dimValues = new double[dimValues.length];
			for (int i = 0; i < dimValues.length; i++) {
				this.dimValues[i] = dimValues[i];
			}
			this.dim = this.dimValues.length;
		} catch (IllegalArgumentException e) {
			System.out.println("IllegalArgumentException");

		}
	}

	public double getDim(int i) {
		return dimValues[i];
	}
	public int dim(){
		return this.dim;
	}
}
