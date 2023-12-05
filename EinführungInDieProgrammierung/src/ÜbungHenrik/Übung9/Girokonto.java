package ÜbungHenrik.Übung9;

import java.text.DecimalFormat;

public class Girokonto {
	private String kontonummer;
	private double kontostand;
	private double dispokredit;
	private static int anzahlKonten;
	
	DecimalFormat knummer = new DecimalFormat("000000");

	public Girokonto() {
		super();
		this.kontonummer = "0822" + knummer.format(++anzahlKonten);
		this.kontostand = 0.0;
		this.dispokredit  = 0.0;
	}

	public void einzahlen(double betrag) {
		this.kontostand += betrag;
	}
	
	public boolean auszahlen( double betrag ) {
		if(betrag < kontostand + dispokredit) {
			if(betrag <= kontostand) {
				kontostand -= betrag;
				return true;
			}
			double übertrag = kontostand % betrag;
			kontostand -= betrag - übertrag;
			dispokredit -= übertrag;
			return true;
		}
		return false;
	}
	
	public boolean überweisung(Girokonto zweitesKonto, double betrag) {
		if(auszahlen(betrag)) {
			zweitesKonto.einzahlen(betrag);
			return true;
		}
		return false;
		
	}
	
	public String toString() {
		return "Kontodetails: " + kontonummer + ", " + kontostand + " , " + dispokredit;
	}
	
	public static int getAnzahlKonten() {
		return anzahlKonten;
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
}
