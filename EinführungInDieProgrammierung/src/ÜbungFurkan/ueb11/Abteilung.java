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

	public int getAnzahlAngestellte() {
		int anzahl = 0;
		for (int i = 0; i < mitarbeiterArray.length; i++)
			if (mitarbeiterArray[i] instanceof Angestellter)
				anzahl++;
		return anzahl;
	}

	public void addMitarbeiter(Mitarbeiter mit) {
		if (getAnzahlMitarbeiter() < 15 && !hasArbeiter(mit)) {
			System.out.println(bezeichnung + " adding" + mit.getName());
			Mitarbeiter[] newArray = new Mitarbeiter[mitarbeiterArray.length + 1];
			for (int i = 0; i < mitarbeiterArray.length; i++) {
				newArray[i] = mitarbeiterArray[i];
			}
			newArray[newArray.length - 1] = mit;
			mitarbeiterArray = newArray;
			mit.setAbteilung(this);
		}
	}
	
	private boolean hasArbeiter(Mitarbeiter mit) {
		for(Mitarbeiter m:mitarbeiterArray) {
			if(m == mit) return true;
		}
		return false;
	}
	
	public void removeMitarbeiter(Mitarbeiter mit) {
		System.out.println(bezeichnung + " removing" + mit.getName());
		for (int i = 0; i < mitarbeiterArray.length; i++) {
			if (mitarbeiterArray[i] == mit) {
				mitarbeiterArray[i] = null;
			}
		}

	}

	public boolean hatMitarbeiter(Mitarbeiter mit) {
		for (int i = 0; i < mitarbeiterArray.length; i++) {
			if (mitarbeiterArray[i] == mit) {
				return true;
			}
		}
		return false;
	}

	public double berechneGehaltskosten() {
		double summe = 0;
		for (Mitarbeiter m : mitarbeiterArray)
			if (m != null)
				summe += m.berechneGehalt();
		return summe;
	}

	public Mitarbeiter getMitarbeiter(int i) {
		return mitarbeiterArray[i];
	}

	public void ausgabeMitarbeiter() {
		System.out.println(bezeichnung);
		for (Mitarbeiter m : mitarbeiterArray) {
			if (m != null)
				System.out.println(m.getName() + " " + m.getPersonalnummer());
		}
	}
}
