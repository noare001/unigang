package ÜbungFurkan.ueb10;

import java.util.Arrays;

public class Mitarbeiterverwaltung {

	public static void main(String[] args) {
		Abteilung hr = new Abteilung("HR");
		Abteilung inf = new Abteilung("Informatik");
		Mitarbeiter m1 = new Mitarbeiter("Mit1Inf", inf);
		Mitarbeiter m2 = new Mitarbeiter("Mit2HR", hr);
		Mitarbeiter m3 = new Mitarbeiter("Mit3HR", hr);
		Mitarbeiter m4 = new Mitarbeiter("Mit4Inf", inf);
		Mitarbeiter m5 = new Mitarbeiter("Mit5Inf", inf);
		Mitarbeiter m6 = new Mitarbeiter("Mit6Inf", inf);
		Mitarbeiter m7 = new Mitarbeiter("Mit7HR", hr);
		Mitarbeiter m8 = new Mitarbeiter("Mit8Inf", inf);
		
		System.out.println("Kollegen von " + m1.getName() + "\n" + Arrays.toString(m1.bestimmeKollegen()));
		System.out.println("Ist Kollege?");
		System.out.println(m4.getName() + " und " + m7.getName() + " -> " + m4.isKollege(m7));
		System.out.println("Ist Kollege?");
		System.out.println(m4.getName() + " und " + m8.getName() + " -> " + m4.isKollege(m8));
		System.out.println("Abteilung Informatik: ausgabeMitarbeiter()");
		inf.ausgabeMitarbeiter();
		
	}
	
}
