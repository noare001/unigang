package ÜbungFurkan.ueb11;

public class Abteilung {

	private String bezeichnung;
	private Mitarbeiter[] mitarbeiterArray;

	public Abteilung(String bezeichnug) {
		this.bezeichnung = bezeichnug;
		mitarbeiterArray = new Mitarbeiter[0];
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public int getAnzahlMitarbeiter() {
		return mitarbeiterArray.length;
	}

	public void addMitarbeiter(Mitarbeiter mit) {
		if (getAnzahlMitarbeiter() < 15) {
			Mitarbeiter[] newArray = new Mitarbeiter[mitarbeiterArray.length + 1];
			for (int i = 0; i < mitarbeiterArray.length; i++) {
				newArray[i] = mitarbeiterArray[i];
			}
			newArray[newArray.length - 1] = mit;
			mitarbeiterArray = newArray;
			if(mit.getAbteilung() != this) mit.setAbteilung(this);
		}
	}

	public void removeMitarbeiter(Mitarbeiter mit) {
		boolean contains = false;
		for (int i = 0; i < mitarbeiterArray.length; i++) {
			if(mitarbeiterArray[i] == mit) {
				mitarbeiterArray[i] = null;
				contains = true;
			}
		}
		
	}
	
	public boolean hatMitarbeiter(Mitarbeiter mit) {
		for (int i = 0; i < mitarbeiterArray.length; i++) {
			if(mitarbeiterArray[i] == mit) {
				return true;
			}
		}
		return false;
	}
	
	public Mitarbeiter getMitarbeiter(int i) {
		return mitarbeiterArray[i];
	}

	public void ausgabeMitarbeiter() {
		for (Mitarbeiter m : mitarbeiterArray) {
			System.out.println(m.getName() + " " + m.getPersonalnummer());
		}
	}
}
