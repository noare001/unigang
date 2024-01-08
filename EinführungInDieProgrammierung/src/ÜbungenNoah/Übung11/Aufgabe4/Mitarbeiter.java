package ÜbungenNoah.Übung11.Aufgabe4;

public abstract class Mitarbeiter {

	private static int anzahlMitarbeiter = 0;
	
	private String name;
	private int personalnummer;
	private Abteilung abteilung;
	
	public Mitarbeiter(String name, Abteilung abteilung) {
		super();
		this.name = name;
		this.abteilung = abteilung;
		
		this.personalnummer = ++anzahlMitarbeiter;
	}
	
	public abstract double berechneGehalt();
	
	public boolean isKollege(Mitarbeiter m) {
		return this.abteilung.getBezeichnung().equals(m.getAbteilung().getBezeichnung());
	}
	
	public Mitarbeiter[] bestimmeKollegen() {
		return this.abteilung.getMitarbeiter();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPersonalnummer() {
		return personalnummer;
	}

	public Abteilung getAbteilung() {
		return abteilung;
	}
	
	
	
	
}
