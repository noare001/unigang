package ÜbungHenrik.Übung9;

public class GiroKontoTest {
	
	public static void main( String[] args) {
		Girokonto erstesKonto = new Girokonto();
		erstesKonto.einzahlen(2050);
		erstesKonto.setDispokredit(1050);
		System.out.println(erstesKonto);
		erstesKonto.auszahlen(3200);
		Girokonto zweitesKonto = new Girokonto();
		erstesKonto.überweisung(zweitesKonto, 1000);
		System.out.println(zweitesKonto);
		System.out.println(zweitesKonto.getKontostand());
		Girokonto drittesKonto = new Girokonto();
		drittesKonto.einzahlen(500000);
		drittesKonto.setDispokredit(300000);
		System.out.println(drittesKonto);
		System.out.println(drittesKonto.auszahlen(10000000));
		System.out.println(drittesKonto.auszahlen(70000));
		System.out.println(drittesKonto);
		
		
	}
}
