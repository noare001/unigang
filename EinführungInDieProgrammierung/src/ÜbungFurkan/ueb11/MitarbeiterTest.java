package ÜbungFurkan.ueb11;

public class MitarbeiterTest {

	public static void main(String[] args) {
		new MitarbeiterTest();
	}
	
	public MitarbeiterTest() {
		Abteilung abt1 = new Abteilung("Abteilung 1");
		Abteilung abt2 = new Abteilung("Abteilung 2");
		Angestellter ang1 = new Angestellter("Ang 1", 299, 40, 50, abt1);
		Angestellter ang2 = new Angestellter("Ang 2", 399, 40, 300, abt1);
		Angestellter ang3 = new Angestellter("Ang 3", 399, 30, 100, abt1);
		Angestellter ang4 = new Angestellter("Ang 4", 299, 60, 140, abt1);
		
		Geschaeftsfuehrer ge1 = new Geschaeftsfuehrer("Ge 1", 2000, 200, 150, abt1);
		Geschaeftsfuehrer ge2 = new Geschaeftsfuehrer("Ge 2", 2050, 500, 200, abt2);
		Arbeiter a1 = new Arbeiter("Ar 1", 1000, 230, 40, abt1);
		Arbeiter a2 = new Arbeiter("Ar 2", 900, 210, 50, abt1);
		Arbeiter a3 = new Arbeiter("Ar 3", 1200, 3000, 70, abt1);
		Arbeiter a4 = new Arbeiter("Ar 4", 1100, 250, 90, abt1);
		Arbeiter a5 = new Arbeiter("Ar 5", 1050, 220, 50, abt1);
		
		abt1.ausgabeMitarbeiter();
		
		abt1.addMitarbeiter(a1);
		abt1.addMitarbeiter(ang1);
		abt1.addMitarbeiter(ang2);
		a2.joinAbteilung(abt1);
		a3.joinAbteilung(abt1);
		
		abt2.addMitarbeiter(a5);
		abt2.addMitarbeiter(a4);
		abt2.addMitarbeiter(a3);
		ang3.joinAbteilung(abt2);
		ang4.joinAbteilung(abt2);
		
		abt1.ausgabeMitarbeiter();
		abt2.ausgabeMitarbeiter();
		
		System.out.println("Abteilung 1:" + abt1.berechneGehaltskosten());
		System.out.println("Abteilung 2:" + abt2.berechneGehaltskosten());
		
		System.out.println("Mitarbeiteranzahl:");
		System.out.println("Abteilung 1 " + abt1.getAnzahlMitarbeiter() + ", davon sind " + abt1.getAnzahlAngestellte() + " Angestellt");
		System.out.println("Abteilung 2 " + abt2.getAnzahlMitarbeiter() + ", davon sind " + abt2.getAnzahlAngestellte() + " Angestellt");
		
	}
	
}
