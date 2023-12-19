package ÜbungHenrik.Übung10;

public class Abteilung {
	private String bezeichnung;
	private Mitarbeiter[] mitListe = new Mitarbeiter[15];
	
	public Abteilung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}
	
	public String getBezeichnung() {
		return this.bezeichnung;
	}
	
	public int getAnzahlMitarbeiter() {
		int ans = 0;
		for(int i = 0; i< mitListe.length; i++) {
			if(mitListe[i] != null) {
				ans++;
			}
		}
		return ans;
	}
	
	public void addMitarbeiter(Mitarbeiter m) {
		boolean ja = false;
		for(int i = 0; i<mitListe.length; i++) {
			if(mitListe[i] == null) {
				mitListe[i] = m;
				System.out.println("Der Mitarbeiter wurde der Abteilung hinzugefügt");
				ja = true;
				break;
			}
		}
		if(!ja) {
			System.out.println("Die Abteilung ist schon voll");
		}
	}
	
	public Mitarbeiter getMitarbeiter(int i) {
		return mitListe[i];
	}
	
	public void ausgabeMitarbeiter() {
		for(Mitarbeiter m : mitListe) {
			if(m != null) {
			System.out.println(m.getName() +" hat die Personalnummer: " + m.getPersonalNummer());
			}
		}
	}
}
