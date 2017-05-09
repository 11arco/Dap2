package Blatt3;

public class Main {
	static long tStart;
	static long tEnd;
	static long msecs;

	public static void main(String[] args) {						
		if (args.length == 0) {										//leeren String "abfangen"
			aufgabe1();
		} else {
			float a = Float.parseFloat(args[0]);						
			aufgabe2((int)a*1000, 1000);
		}

	}

	public static void aufgabe1() {									//Aufgabe2 aufrufen
		int[] array = new int[5000];
		fillArray(array);

		bubble(array);
		System.out.println("Laufzeit:" + msecs);
	}

	public static void aufgabe2(int time, int size) {				//Aufgabe2 aufrufen
		int[] array = new int[size];
		fillArray(array);
		calc(array, time, size);

	}

	public static void calc(int[] array, int time, int size) {
		bubble(array);
		if (msecs >=  time - 50  && msecs <= time + 50 ) {		//Check, ist msecs gültig
			System.out.println("Laufzeit:" + msecs + " ms");
			System.out.println("Feldgröße:" + size);
			System.out.println("passt");			
			return;												//Abbruch, sonst werden Folgende if beartbeitet
		}
		if (msecs < time-50) {										//ZU kiene Zet, also erhöhen der Feldgröße
			System.out.println("Laufzeit:" + msecs+ " ms");			
			System.out.println("Feldgröße:" + size);
			aufgabe2(time, 2 * size);
		}
		if (msecs > time+50) {										//Binäre Suche 	
			System.out.println("Laufzeit:" + msecs+ " ms");
			System.out.println("Feldgröße:" + size);
			if (size != 0) {
				aufgabe2(time, size * 3 / 4);					//Annäherung auf time, indem die letzte erhöhung der Size halbiert wird
				}

		}
	}

	public static void bubble(int[] array) {					//Messung Bubblesort outsourced, der Rekursion wegen 
		tStart = System.currentTimeMillis();		
		Main.bubbleSort(array);									//Aufruf Bubblesort
		tEnd = System.currentTimeMillis();

		msecs = tEnd - tStart;
	}

	public static void bubbleSort(int[] array) {				//Bubble-Sort
		int n = array.length;								
		int temp;	
		for (int i = 0; i < n; i++) {							//pointer erster Durchlauf
			for (int j = n - 1; i < j; j--) {					//pointer zweiter Durchlauf
				if (array[j - 1] > array[j]) {					//Größenvergleich
					temp = array[j];							//-
					array[j] = array[j - 1];				//-Dreieckstauch
					array[j - 1] = temp;					//-
				}
			}
		}
	}

	public static void fillArray(int[] array) {				//Fülle Array absteigend
		for (int i = 0; i < array.length; i++) {
			array[i] = array.length - i;

		}
	}
}
