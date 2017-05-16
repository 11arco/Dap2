package Blatt4;

import java.lang.Math;

public abstract class Simplex {
	private int d;
	private Point[] points;

	public Simplex(int d, Point[] points) {
		this.d = d;
		this.points = new Point[d];

		for (int i = 0; i < this.d; i++) {
			this.points[i] = points[i];
		}
	}

	public abstract boolean validate();

	public Point getPoint(int i) {
		return points[i];
	}

	public Point[] getPoints() {
		return points;
	}

	public double perimeter() {
		double sum = 0;
		if (this.points.length == 0) {

			return sum;
		} else {
			for (int i = 0; i < this.points.length ; i++) {
				for (int j = i + 1; j < this.points.length ; j++) {
					sum = sum + distance(this.points[i], this.points[j]);
				}

			}
			return sum;

		}
	}

	public double distance(Point p1, Point p2) {
		if (p1.dim() != p2.dim()) {
			System.out.println("p1, p2 länge != ");
			return 0;
		}
		double[] sumsum = new double[p1.dim()];
		double sum = 0;
		for (int i = 0; i < p1.dim(); i++) {
			sumsum[i] = abs(p1.getDim(i) - p2.getDim(i));

		}
		sum = sumsum[0];
		for (int j = 1; j < p2.dim(); j++) {
			sum = Math.sqrt(sum + sumsum[j]);
		}
		return sum;
	}

	public static double abs(double x) {
		if (x > 0) {
			return x;
		} else {
			return x * -1;
		}
	}

}
