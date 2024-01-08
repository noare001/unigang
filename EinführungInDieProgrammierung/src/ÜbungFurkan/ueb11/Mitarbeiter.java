package ÜbungFurkan.ueb11;

public abstract class Mitarbeiter {

	private String name;
	private int personalnummer;
	private static int anzahlMitarbeiter = 0;
	private Abteilung abt;

	public Mitarbeiter(String name, Abteilung abt) {
		this.name = name;
		this.abt = abt;
		abt.addMitarbeiter(this);
		anzahlMitarbeiter++;
		personalnummer = anzahlMitarbeiter;

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
		return abt;
	}

	public void setAbteilung(Abteilung abt) {
		this.abt = abt;
	}

	public void joinAbteilung(Abteilung abt) {
		this.abt.removeMitarbeiter(this);
		abt.addMitarbeiter(this);
	}
	
	
	public boolean isKollege(Mitarbeiter ma) {
		return getAbteilung().getBezeichnung().equals(ma.getAbteilung().getBezeichnung());
	}

	public Mitarbeiter[] bestimmeKollegen() {
		Abteilung abt = getAbteilung();
		Mitarbeiter[] kollegen = new Mitarbeiter[abt.getAnzahlMitarbeiter() - 1];
		int arrIndex = 0;
		for (int i = 0; i < abt.getAnzahlMitarbeiter(); i++) {
			if (abt.getMitarbeiter(i) != this) {
				kollegen[arrIndex] = abt.getMitarbeiter(i);
				arrIndex++;
			}
		}
		return kollegen;
	}

	public String toString() {
		return name + " aus " + getAbteilung().getBezeichnung();
	}

	public abstract double berechneGehalt();
}
