package ÜbungFurkan.ueb11;

public class Mitarbeiterverwaltung {

	public static void main(String[] args) {
		
		Abteilung abt = new Abteilung("Die Abteilung");
		Geschaeftsfuehrer geschaeftsFuehrer = new Geschaeftsfuehrer("Hanz", 1000, 50, 340, abt);
		System.out.println(geschaeftsFuehrer);
		System.out.println(geschaeftsFuehrer.berechneGehalt());
	}
	
}
