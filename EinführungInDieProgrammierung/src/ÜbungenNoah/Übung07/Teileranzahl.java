package ÜbungenNoah.Übung07;

import java.util.Scanner;

public class Teileranzahl {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("------------------------------------------------------------------------------\r\n"
					+ "1 Teileranzahl für n\r\n" 
					+ "2 Maximale Teileranzahl für die Zahlen 1 bis n\r\n" 
					+ "3 Fertig\r\n"
					+ "------------------------------------------------------------------------------");
			switch (scanner.nextInt()) {
				case 1:
					System.out.println("Gebe eine ganze Zahl ein: ");
					int n = scanner.nextInt();
					System.out.println("Die Zahl " + n + " besitzt " + berechneTeileranzahl(n) + " Teiler");
					break;
				case 2:
					System.out.println("Gebe eine ganze Zahl ein: ");
					int m = scanner.nextInt();
					System.out.println("Zwischen 1 und " + m + " besitzt die Zahl " + berechneMaximaleTeileranzahl(m)
							+ " mit " + berechneTeileranzahl(berechneMaximaleTeileranzahl(m)) + " die meisten Teiler");
					break;
				case 3:
					scanner.close();
					return;
			}
			scanner.nextLine();
			System.out.println("\r\nDrücke Enter zum fortfahren...");
			scanner.nextLine();
		}
	}

	public static int berechneTeileranzahl(int n) {
		int anzahlTeiler = 0;
		for (int i = 1; i <= n; i++) {
			if (n % i == 0)
				anzahlTeiler++;
		}
		return anzahlTeiler;
	}

	public static int berechneMaximaleTeileranzahl(int n) {
		int meisteTeiler = 0;
		for (int i = 1; i <= n; i++) {
			if (berechneTeileranzahl(i) > berechneTeileranzahl(meisteTeiler))
				meisteTeiler = i;
		}
		return meisteTeiler;
	}
}