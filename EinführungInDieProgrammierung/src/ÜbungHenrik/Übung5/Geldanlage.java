package ÜbungHenrik.Übung5;

import java.util.Scanner;

public class Geldanlage {
	public static void main(String[] args) {
		Scanner scanner  = new Scanner(System.in);
		System.out.println("Geben Sie ihre Laufzeit für die Geldanlage an: ");
		int laufzeit = scanner.nextInt();
		System.out.println("Geben Sie ihren Geldbetrag an: ");
		double euro = scanner.nextDouble();
		
		System.out.println("--------------------------------------------------------------------\r\n"
				+ "1 1,5 % Verzinsung ohne Bonuszahlung\r\n"
				+ "2 0,7 % Verzinsung mit 15 Euro Bonuszahlung\r\n"
				+ "3 0,4 % Verzinsung mit 20 Euro Bonuszahlung\r\n"
				+ "4 0,1 % Verzinsung mit 50 Euro Bonuszahlung\r\n"
				+ "5 Fertig\r\n"
				+ "--------------------------------------------------------------------");
		
		
		System.out.println("Bitte wählen Sie eine der Möglichkeiten 1-5 aus.");
		int auswahl = scanner.nextInt();
		if(auswahl >0 && auswahl < 5) {
			berechneGuthaben(laufzeit, euro, auswahl);
		} else if(auswahl == 5) {
			System.out.println("Abgeschlossen");
		} else {
			main(args);
		}
	}
	
	
	public static void berechneGuthaben(int laufzeit, double betrag, int auswahl) {
			double zins = 0;
			int bonus = 0;
		switch (auswahl) {
		case 1: 
			 zins = 1.015;
			 bonus = 0;
			break;
		case 2: 
			 zins = 1.007;
			 bonus = 15;
			 break;
		case 3: 
			zins = 1.004;
			bonus = 20;
			break;
		case 4:
			zins= 1.001;
			bonus=50;
			break;
		}
		
		if(laufzeit >0 && betrag > 0) {
			for( int i= 0; i< laufzeit; i++) {
				betrag = betrag * zins + bonus;
			}
		}
		betrag = Math.rint(betrag*100)/100;
		
		System.out.println("Ihr endgültiger Betrag ist: " + betrag);
	}
	
	
	
}
