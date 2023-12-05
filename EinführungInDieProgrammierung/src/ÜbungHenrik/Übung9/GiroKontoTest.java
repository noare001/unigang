package ÜbungHenrik.Übung9;

public class GiroKontoTest {
	
	public static void main( String[] args) {
		Girokonto erstesKonto = new Girokonto();
		erstesKonto.einzahlen(2050);
		erstesKonto.setDispokredit(1050);
		System.out.println(erstesKonto);
		System.out.println(erstesKonto.auszahlen(3200));
		System.out.println(erstesKonto.auszahlen(1500));
		System.out.println(erstesKonto);
		System.out.println("-----------------------------------------------");
		Girokonto zweitesKonto = new Girokonto();
		erstesKonto.überweisung(zweitesKonto, 1000);
		System.out.println(zweitesKonto);
		System.out.println(zweitesKonto.getKontostand());
		System.out.println("--------------------------------------------------");
		Girokonto drittesKonto = new Girokonto();
		drittesKonto.einzahlen(500000);
		drittesKonto.setDispokredit(300000);
		System.out.println(drittesKonto);
		System.out.println(drittesKonto.auszahlen(10000000));
		System.out.println(drittesKonto.auszahlen(70000));
		System.out.println(drittesKonto);
		
		
	}
}
