package Blatt4;

import java.lang.Math;

public class Application {
	static Point[] points;
	static double[] values;

	public static void main(String[] args) {
		if (args.length == 0) {

			points = new Point[(int) (Math.random() * 10)];
		}
		if (args.length != 6) {
			System.out.println("Falsche Eingabe.");
			System.out.println("Bitte 6 Parameter eingeben.");

			return;
		} else {
			try {
				int i = Integer.parseInt(args[0]);
				points = new Point[3];

				values = new double[(int) (2)];
				for (int i1 = 0; i1 < points.length; i1++) {
					for (int j = i1; j < values.length; j=j+2) {
						values[j] = Double.parseDouble(args[j]);
					}
					points[i1] = new Point(values);
				}
			} catch (IllegalArgumentException e) {
				System.out.println(e);
				return;
			}
		}

		values = new double[(int) (Math.random() * 6)];
		for (int i = 0; i < points.length; i++) {
			for (int j = 0; j < values.length; j++) {
				values[j] = (Math.random() * 10);
			}
			points[i] = new Point(values);

		}
		Simplex s = new Triangle(points.length, points);
		System.out.println("Die länge aller Kanten");
		System.out.println(s.perimeter());

	}
}
