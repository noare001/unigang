package ÜbungenNoah.Übung10.Aufgabe3;

public class Mitarbeiterverwaltung {

	public static void main(String[] args) {
		
		//init
		Abteilung informatik = new Abteilung("Informatik");
		
		Mitarbeiter tim = new Mitarbeiter("Tim", informatik);
		Mitarbeiter tom = new Mitarbeiter("Tom", informatik);
		
		informatik.addMitarbeiter(tim);
		informatik.addMitarbeiter(tom);
		
		
		Abteilung personal = new Abteilung("Personal");
		
		Mitarbeiter jonas = new Mitarbeiter("Jonas", personal);
		Mitarbeiter jonathan = new Mitarbeiter("Jonathan", personal);
		
		personal.addMitarbeiter(jonas);
		personal.addMitarbeiter(jonathan);

		
		//test
		System.out.println(informatik.getBezeichnung() + ": " + informatik.getAnzahlMitarbeiter());
		informatik.ausgabeMitarbeiter();
		
		System.out.println("\r\nMitarbeiter Test:");
		System.out.println(tim.getName() + ": " + tim.getAbteilung().getBezeichnung() + " - " + tim.getPersonalnummer());
		
		System.out.println("Informatik Mitarbeiter gleich Tims Kollegen: " + (informatik.getMitarbeiter() == tim.bestimmeKollegen()));
		
		System.out.println("Tim & Tom: " + tim.isKollege(tom));
		System.out.println("Tim & Jonas: " + tim.isKollege(jonas));
		

	}

}
