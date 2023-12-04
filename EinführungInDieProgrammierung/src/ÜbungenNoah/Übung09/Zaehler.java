package ÜbungenNoah.Übung09;

class Zaehler {
	
	// Objektattribute
	private int zaehlerstand;

	// Konstruktoren
	public Zaehler(int wert) {
		this.zaehlerstand = wert;
	}

	// Methoden
	public void uebertrage(Zaehler zweiterZaehler) {
		zweiterZaehler.setZaehlerstand(this.zaehlerstand);
	}

	public void setZaehlerstand(int wert) {
		this.zaehlerstand = wert;
	}

	public int getZaehlerstand() {
		return this.zaehlerstand;
	}

	public boolean equals(Zaehler zweiterZaehler) {
		return this.zaehlerstand == zweiterZaehler.getZaehlerstand();
	}
}
