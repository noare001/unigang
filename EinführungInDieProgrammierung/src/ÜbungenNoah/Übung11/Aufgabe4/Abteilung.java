package ÜbungenNoah.Übung11.Aufgabe4;

public class Abteilung {

	private String bezeichnung;
	private Mitarbeiter[] mitarbeiterList = new Mitarbeiter[15];
	private int anzahlMitarbeier = 0;

	public Abteilung(String bezeichnung) {
		super();
		this.bezeichnung = bezeichnung;
	}
	
	public String getBezeichnung() {
		return bezeichnung;
	}
	
	public int getAnzahlMitarbeiter() {
		return mitarbeiterList.length;
	}
	
	public void addMitarbeiter(Mitarbeiter m) {
		mitarbeiterList[anzahlMitarbeier++] = m;
	}
	
	public Mitarbeiter[] getMitarbeiter() {
		return mitarbeiterList;
	}
	
	public Mitarbeiter getMitarbeiter(int i) {
		return mitarbeiterList[i];
	}
	
	public void ausgabeMitarbeiter() {
		System.out.println("Abteilungsname: " + this.bezeichnung);
		for (Mitarbeiter m : mitarbeiterList) {
			if (m != null) {
			System.out.println(m.getName() + " P-Nr: " + m.getPersonalnummer());
			}
		}
	}
}
