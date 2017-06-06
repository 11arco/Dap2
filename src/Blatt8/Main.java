package Blatt8;

public class Main {

	public static void main(String[] args) {
		

		
		if (args.length == 2) {
			System.out.println(EditDistance.distance(args[0],args[1]));
		} else {
			System.out.println("Falsche Einageb");
		}

	}
}
