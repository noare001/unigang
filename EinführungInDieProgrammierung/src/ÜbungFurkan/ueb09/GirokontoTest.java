package ÜbungFurkan.ueb09;

public class GirokontoTest {

	public static void main(String[] args) {
		Girokonto konto1 = new Girokonto();
		Girokonto konto2 = new Girokonto();
		Girokonto konto3 = new Girokonto();
		konto1.einzahlen(30000);
		konto1.setDispokredit(10000);
		konto2.setDispokredit(800);
		konto2.einzahlen(3232);
		konto3.einzahlen(10);
		System.out.println(konto1);
		System.out.println(konto2);
		System.out.println(konto3);
		seperator();
		System.out.println("Erfolgreiches Auszahlen: \nStand Davor " + konto1.getKontostand() + 
				"\nAuszahlung Erfolgreich?: " +  konto1.auszahlen(300) + "\nStand Danach: " + konto1.getKontostand());
		seperator();
		System.out.println("Nicht erfolgreiches Auszahlen: \nStand Davor " + konto2.getKontostand() + 
				"\nAuszahlung Erfolgreich?: " +  konto2.auszahlen(4000) + "\nStand Danach: " + konto2.getKontostand());
		seperator();
		System.out.println("Erfolgreiches Überweisen \nKonto 3: " + konto3.getKontostand() + ", Konto 2: " + konto2.getKontostand() +
		"\nÜberweisung erfolgreich?: " + konto2.ueberweisen(konto3, 1000) + 
		"\nStand danach \nKonto 1: " + konto3.getKontostand() + ", Konto 2: " + konto2.getKontostand());
		seperator();
		System.out.println("Nicht erfolgreiches Überweisen \nKonto 3: " + konto3.getKontostand() + ", Konto 2: " + konto2.getKontostand() +
				"\nÜberweisung erfolgreich?: " + konto3.ueberweisen(konto2, 2000) + 
				"\nStand danach \nKonto 3: " + konto3.getKontostand() + ", Konto 2: " + konto2.getKontostand());
		seperator();
		System.out.println("Erfolgreiches Überweisen wegen Dispokredit \nKonto 1: " + konto1.getKontostand() + ", Konto 3: " + konto3.getKontostand() +
				"\nÜberweisung erfolgreich?: " + konto1.ueberweisen(konto3, 30000) + 
				"\nStand danach \nKonto 1: " + konto1.getKontostand() + ", Konto 3: " + konto3.getKontostand());
		seperator();
		System.out.println(konto1);
		System.out.println(konto2);
		System.out.println(konto3);
	}
	
	public static void seperator() {
		System.out.println("____________________________________________________");
	}
	
}
