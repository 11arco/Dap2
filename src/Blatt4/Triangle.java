package Blatt4;

public class Triangle extends Simplex {

	public Triangle(int d, Point[] points) {
		super(d, points);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean validate() {
		int i =0;
		int dsum =0;
		while(i <getPoints().length ){
			dsum= dsum +getPoints()[i].dim();
		}
		dsum = dsum /getPoints().length+1;
		if (getPoints().length >= 3 && getPoints()[dsum].dim() ==2 ) {
			
			return true;
		}
		return false;
	}

}
