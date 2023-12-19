package ÜbungHenrik.Übung10;

public class Mitarbeiter {
	private String name;
	private int personalNummer;
	private static int anzahlMitarbeiter= 0;
	private Abteilung abt;
	
	public Mitarbeiter (String name, Abteilung abt) {
		this.name = name;
		this.abt = abt;
		abt.addMitarbeiter(this);
		this.personalNummer = ++anzahlMitarbeiter;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPersonalNummer() {
		return personalNummer;
	}

	public Abteilung getAbt() {
		return abt;
	}
	
	public boolean isKollege(Mitarbeiter mit) {
		if(this.getAbt() == mit.getAbt()) return true;
		return false;
	}
	
	public Mitarbeiter[] bestimmeKollegen() {
		Mitarbeiter[] kollege = new Mitarbeiter[15];
		
		for(int i = 0; i<15; i++) {
			if(this.abt.getMitarbeiter(i) != this) {
				kollege[i] = this.abt.getMitarbeiter(i);
			}
		}
		return kollege;
	}
}
