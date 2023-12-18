package ÜbungFurkan.ueb11;

public class Arbeiter extends Mitarbeiter{

	private double stundenlohn;
	private double anzahlStunden;
	private double ueberstudenzuschlag;
	private double anzahlUeberstunden;
	
	public Arbeiter(String name, double stdlohn, double anzahlStunden, double uestzus, Abteilung abt) {
		super(name, abt);
		stundenlohn = stdlohn;
		this.anzahlStunden = anzahlStunden;
		ueberstudenzuschlag = uestzus;
	}

	public void setAnzahlUeberstunden(double ueberstunden) {
		this.anzahlUeberstunden = ueberstunden;
	}
	
	public String toString() {
		return getName() + " id:" + getPersonalnummer() + 
				"|| Anzahl Stunden: " + anzahlStunden + ", Stundenlohn: " + stundenlohn + 
				", Anzahl Überstunden: " + anzahlUeberstunden+ ", Überstundenzuschlag: " + ueberstudenzuschlag;
	}
	
	@Override
	public double berechneGehalt() {
		return anzahlStunden * stundenlohn + anzahlUeberstunden * ueberstudenzuschlag;
	}

}
