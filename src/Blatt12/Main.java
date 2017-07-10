package Blatt12;

import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		try {
			Graph.fromFile(args[0]);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
	}
}
