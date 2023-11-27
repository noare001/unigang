package ÜbungenNoah.Übung05;

import java.util.Scanner;

public class Uebung05 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("--------------------------------------------------------------------\r\n"
				+ "1 Prüfe Null\r\n" + "2 Prüfe gerade ungerade\r\n" + "3 Gib Anzahl Tage für Monat\r\n"
				+ "4 Convert Dezimal to binär\r\n" + "5 Geld Anlage Berechnung\r\n" + "6 Pythagoräischen Tripel"
				+ "-------------------------------------------------------------------- \r\n"
				+ "Bitte wählen Sie eine der Möglichkeiten 1-6 aus.");
		switch (scanner.nextInt()) {
		case 1:
			System.out.println("Bitte geben Sie eine natürliche Zahl an: ");
			System.out.println(pruefeNull(scanner.nextInt()));
			break;
		case 2:
			System.out.println("Bitte geben Sie eine natürliche Zahl an: ");
			System.out.println(geradeUngerade(scanner.nextInt()));
			break;
		case 3:
			System.out.println("Bitte gib einen Monatsname ein:");
			System.out.println(gibAnzahlTage(scanner.nextLine()));
			break;
		case 4:
			System.out.println("Bitte geben Sie eine natürliche Zahl an: ");
			System.out.println(intToBinärString(scanner.nextInt()));
			break;
		case 5:
			geldAnlage();
			break;
		case 6:
			System.out.println("Bitte geben Sie eine natürliche Zahl an: ");
			pythTripel(scanner.nextInt());
			break;
		default:
			throw new IllegalArgumentException("Unexpected value");
		}
	}

//	Aufgabe 1
//		a)
	public static String pruefeNull(int n) {
		return n > 0 ? n + " ist größer als 0" : n < 0 ? n + " ist kleiner als 0" : n + " ist 0";
	}

//		b)
	public static String geradeUngerade(int n) {
		return n % 2 == 1 ? n + " ist ungerade" : n + " ist gerade";
	}

//	Aufgabe 2
	public static String gibAnzahlTage(String monat) {
		switch (monat) {
		case "Januar", "März", "Mai", "Juli", "August", "Oktober", "Dezember":
			return "31";
		case "Februar":
			return "28";
		case "April", "Juni", "September", "November":
			return "30";
		default:
			return "Kein Monatsname übergeben";
		}
	}

//	Aufgabe 3
	public static String intToBinärString(int n) {
		return n > 0 ? intToBinärString(n / 2) + n % 2 : "";
	}

//	Aufgabe 4
	@SuppressWarnings("resource")
	public static void geldAnlage() {
		System.out.println("Laufzeit in Jahren eingeben: ");
		Scanner scanner = new Scanner(System.in);
		int laufzeit = scanner.nextInt();
		System.out.println("Anlagebetrag in Euro eingeben: ");
		double anlageBetrag = scanner.nextDouble();
		int auswahl = 10;
		while (auswahl > 5 || auswahl < 1) {
			System.out.println("--------------------------------------------------------------------\r\n"
					+ "1 1,5 % Verzinsung ohne Bonuszahlung\r\n" + "2 0,7 % Verzinsung mit 15 Euro Bonuszahlung\r\n"
					+ "3 0,4 % Verzinsung mit 20 Euro Bonuszahlung\r\n"
					+ "4 0,1 % Verzinsung mit 50 Euro Bonuszahlung\r\n" + "5 Fertig\r\n"
					+ "-------------------------------------------------------------------- \r\n"
					+ "Bitte wählen Sie eine der Möglichkeiten 1-5 aus.");
			auswahl = scanner.nextInt();
		}
		double zinsen = 1;
		int bonus = 0;
		switch (auswahl) {
		case 1:
			zinsen = 1.015;
			bonus = 0;
			break;
		case 2:
			zinsen = 1.007;
			bonus = 15;
			break;
		case 3:
			zinsen = 1.004;
			bonus = 20;
			break;
		case 4:
			zinsen = 1.001;
			bonus = 50;
			break;
		case 5:
			return;
		}
		for (int j = laufzeit; j > -1; j--)
			anlageBetrag = anlageBetrag * zinsen + bonus;
		System.out.println("Nach " + laufzeit + " Jahren haben sie "
				+ Math.round(anlageBetrag * Math.pow(10, 2)) / Math.pow(10, 2) + " €");
	}

//	Aufgabe 5
	public static void pythTripel(int n) {
		int anzahl = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = i; j <= n; j++) {
				for (int k = j; k <= i + j; k++) {
					if ((i * i) + (j * j) == (k * k)) {
						anzahl++;
						System.out.println(i + " * " + i + " + " + j + " * " + j + " = " + k + " * " + k);
					}
				}
			}
		}
		System.out.println("Es wurden " + anzahl + " pythagoräische Tripel gefunden");
	}

}
