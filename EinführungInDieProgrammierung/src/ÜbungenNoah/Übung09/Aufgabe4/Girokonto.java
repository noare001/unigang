package ÜbungenNoah.Übung09.Aufgabe4;

import java.text.DecimalFormat;

public class Girokonto {

	private String kontonummer;
	private double kontostand;
	private double dispokredit = 0;
	private static int anzahlKonten = 0;
	
	DecimalFormat df = new DecimalFormat("000000");

	public Girokonto() {
		super();
		this.kontonummer = "0822" + df.format(++anzahlKonten);
	}

	public void einzahlen(double betrag) {
		kontostand += betrag;
	}

	public boolean auszahlen(double betrag) {
		if (kontostand >= betrag) {
			kontostand -= betrag;
			return true;
		} else if (dispokredit >= betrag) {
			dispokredit-= betrag;
			return true;
		}
		return false;
	}
	
	public boolean ueberweisung(Girokonto zweitesKonto, double betrag) {
		if(auszahlen(betrag)) {
			zweitesKonto.einzahlen(betrag);
			return true;
		} else if (dispokredit >= betrag) {
			dispokredit-= betrag;
		}
		return false;
	}
	
	public String toString() {
		return "Kontonummer: " + kontonummer + ", Kontostand: " + kontostand + ", Dispokredit: " + dispokredit;
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

	public static int getAnzahlKonten() {
		return anzahlKonten;
	}

}
