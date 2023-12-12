package ÜbungHenrik.Übung10;

import java.util.Arrays;

public class MitarbeiterVerwaltung {
	public static void main(String[] args) {
		Abteilung ik = new Abteilung("ik");
		Mitarbeiter Noah = new Mitarbeiter("Noah" , ik);
		Mitarbeiter Furkan = new Mitarbeiter("Furkan" , ik);
		ik.ausgabeMitarbeiter();
		System.out.println(Furkan.isKollege(Noah));
		System.out.println(Arrays.toString(Noah.bestimmeKollegen()));
		
		Abteilung HR = new Abteilung("HR");
		Mitarbeiter Simon = new Mitarbeiter("Simon", HR);
		Mitarbeiter Lara = new Mitarbeiter("Lara" , HR);
		Mitarbeiter Marie = new Mitarbeiter("Marie", HR);
		System.out.println(Lara.getPersonalNummer());
		System.out.println(Marie.getAbt().getBezeichnung());
		HR.ausgabeMitarbeiter();
		System.out.println(ik.getAnzahlMitarbeiter());
		System.out.println(HR.getAnzahlMitarbeiter());
	}
}
