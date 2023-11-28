package ueb07;

import java.util.Scanner;

public class Teilerzeahlen {

	public static void main(String[] args) {
		new Teilerzeahlen();
	}

	public Teilerzeahlen() {
		Scanner scanner = new Scanner(System.in);
		boolean end = false;
		while (!end) {
			int eingabe;
			do {
				System.out.println("------------------------------------------------------------------------------\r\n"
						+ "1 Teileranzahl für n\r\n" + "2 Maximale Teileranzahl für die Zahlen 1 bis n\r\n"
						+ "3 Fertig\r\n"
						+ "------------------------------------------------------------------------------");

				eingabe = scanner.nextInt();
			} while (eingabe > 3 && eingabe < 1);

			if (eingabe == 3) {
				end = true;
				System.out.println("Auf wiedersehen :)");
			} else {
				int n;
				do {
					System.out.println("Gebe eine Zahl >= 1 ein");
					n = scanner.nextInt();
				} while (n < 1);
				if (eingabe == 1) {
					System.out.println(n + " hat " + berechneTeileranzahl(n) + " Teiler");
				} else {
					berechneMaximaleTeileranzahl(n);
				}
			}
		}
	}

	public int berechneTeileranzahl(int n) {
		int teileranzahl = 0;
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				teileranzahl++;
			}
		}
		return teileranzahl;
	}

	public void berechneMaximaleTeileranzahl(int n) {
		int zahlMitMaxTeilern = 0;
		for (int i = 1; i <= n; i++) {
			if (zahlMitMaxTeilern < berechneTeileranzahl(i)) {
				zahlMitMaxTeilern = i;
			}
		}
		System.out.println("Die zahl " + zahlMitMaxTeilern + " hat bei den zahlen zwischen 1 und " + n + " mit "
				+ berechneTeileranzahl(zahlMitMaxTeilern) + " die meisten Teiler");
	}
}
