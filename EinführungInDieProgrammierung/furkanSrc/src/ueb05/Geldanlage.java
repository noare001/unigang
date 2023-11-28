package ueb05;

import java.util.Scanner;

public class Geldanlage {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Gebe die Laufzeit in Jahren an");
		int jahre = scanner.nextInt();
		System.out.println("Gebe den Betrag an");
		double betrag = scanner.nextDouble();
		boolean fortsetzen = true;
		while (fortsetzen) {
			System.out.println("-------------------------------------------");
			System.out.println("Betrag: " + betrag);
			System.out.println("1: 5 % Verzinsung ohne Bonuszahlung");
			System.out.println("2: 0,7 % Verzinsung mit 15 Euro Bonuszahlung");
			System.out.println("3: 0,4 % Verzinsung mit 20 Euro Bonuszahlung");
			System.out.println("4: 0,1 % Verzinsung mit 50 Euro Bonuszahlung");
			System.out.println("5: Fertig");
			System.out.println("-------------------------------------------");
			System.out.println("Bitte wählen Sie eine der Möglichkeiten 1-5 aus.");
			int key = scanner.nextInt();
			switch (key) {
			case 1 -> betrag = berechneGuthaben(betrag, 0, 5, jahre);
			case 2 -> betrag = berechneGuthaben(betrag, 15, 0.7, jahre);
			case 3 -> betrag = berechneGuthaben(betrag, 20, 0.4, jahre);
			case 4 -> betrag = berechneGuthaben(betrag, 50, 0.1, jahre);
			case 5 -> fortsetzen = false;
			default -> System.out.println("Ungültiger Input");
			}
			System.out.println("Betrag: " + betrag);
		}

		scanner.close();
		System.out.println("Verlasse die while-schleife" + "\n" + "Dein Betrag beträgt " + betrag);
		// System.out.println(inToBinaryString(36));
	}

	public static double berechneGuthaben(double anlage, double bonuszahlung, double zinssatz, int jahre) {
		while (jahre > -1) {
			anlage = anlage * (1 + zinssatz / 100) + bonuszahlung;
			jahre--;
		}
		return anlage;
	}

	public static String inToBinaryString(int n) {
		return n > 0 ? inToBinaryString(n / 2) + n % 2 : "";
	}
}
