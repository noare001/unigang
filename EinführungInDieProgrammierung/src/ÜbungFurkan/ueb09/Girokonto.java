package ÜbungFurkan.ueb09;

public class Girokonto {

	private String kontonummer;
	private double kontostand = 0;
	private double dispokredit = 0;
	private static int anzahlKonten = 0;
	
	public Girokonto() {
		anzahlKonten++;
		int anzahlNullen = 6-String.valueOf(anzahlKonten).length();
		kontonummer = "0822" + "0".repeat(anzahlNullen) + anzahlKonten;
	}

	public String getKontonummer() {
		return kontonummer;
	}
	
	public double getKontostand() {
		return kontostand;
	}

	public double getDispokredit() {
		return dispokredit;
	}

	public void setDispokredit(double dispokredit) {
		this.dispokredit = dispokredit;
	}
	
	public void einzahlen(double betrag) {
		kontostand += betrag;
	}
	
	public boolean auszahlen(double betrag) {
		if(kontostand-dispokredit >= betrag) {
			kontostand -= betrag;
			return true;
		}
		return false;
	}
	
	public boolean ueberweisen(Girokonto zweitesKonto, double betrag) {
		if(auszahlen(betrag)) {
			zweitesKonto.einzahlen(betrag);
			return true;
		}
		return false;
	}
	
	public String toString() {
		return kontonummer + ", Kontostand: " + kontostand + ", Dispokredit: " + dispokredit;
	}

	public static int getAnzahlKonten() {
		return anzahlKonten;
	}
	
}
