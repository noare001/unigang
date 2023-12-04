package ÜbungenNoah.Übung09.Aufgabe4;

public class GirokontoTest {

	public static void main(String[] args) {
		
		Girokonto konto1 = new Girokonto();
		Girokonto konto2 = new Girokonto();
		
		konto1.einzahlen(100);
		System.out.println(konto1 + "\n");
		
		System.out.println("Auszahlung von 1000€: " + konto1.auszahlen(1000));
		System.out.println(konto1 + "\n");
		
		System.out.println("Auszahlung von 50€: " + konto1.auszahlen(50));
		System.out.println(konto1 + "\n");
		
		System.out.println("Überweisung von 50€: " + konto1.ueberweisung(konto2, 50));
		System.out.println(konto1);
		System.out.println(konto2 + "\n");
		
		System.out.println("Überweisung von 100€: " + konto2.ueberweisung(konto1, 100));
		System.out.println(konto1);
		System.out.println(konto2 + "\n");
	}

}
