package Blatt9;

public class Main {

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Bitte Werte eingeben");
			return;
		}
		System.out.print("Eingabe:   ");
		Baum baum;
		try {
			 baum = new Baum(Integer.parseInt(args[0]));
			System.out.print(args[0]+", ");

			for (int i = 1; i < args.length; i++) {
				System.out.print(args[i] + ", ");

				baum.add(Integer.parseInt(args[i]));
			}
			
		} catch (Exception e) {
			System.out.println("Falsche Eingabe");
			System.out.println("Bitte geben sie die Werte im Format:'1 2 3' ein");
			System.out.println(e);
			return;
		}
		System.out.println();
		order(baum);
	}

	public static void order(Baum baum) {
		System.out.print("Pre-Order: ");
		baum.preOrder();
		System.out.println();
		System.out.print("In-Order:  ");
		baum.inOrder();
		System.out.println();
		System.out.print("Post-Order:");
		baum.postOrder();
		System.out.println();

	}

}
