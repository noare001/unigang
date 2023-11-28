package ÜbungNils.Übung3; 

public class AusgabeTest {
	
	public static void main(String[] args) {
		
		System.out.println("4*5");
		// Durch die Literale werden die Zahlen werden nicht verrechnet.
		System.out.println("Dies ist" + "ein Text");
		//Das Plus sorgt dafür das beide Teile ohne Leerzeichen hintereinander geschrieben werden.
		System.out.println("Dies ist ein \nText" );
		// Das \n verschiebt alles nachfolgende um eine Zeile.
		System.out.println("\u0065");
		// Die Ausgabe ist e.
		System.out.println("\"");
		// Es wird nur " Ausgegeben.
		System.out.println(2147483647);
		// Zahlen können auch ausgegeben werden ohne in Literalen zu stehen.
		System.out.println(2147483647+1);
		// Es wird automatisch verrechtnet allerdings mit negativen Vorzeichen ausgegeben.
		// liegt daran, dass die maximale Zahl die ien int positiv ausgeben kann 2147483647 ist.
		System.out.println(0xFF);
		// Das Ergebnis ist 255.
		// Die Schreibweise ist im Hexadezimal.
		System.out.println(0xFFFFFF);
		// Das Ergebnis ist 16777215.
		// Die Schreibweise ist im Hexadezimal.
		System.out.println("Zahl " + 0.12345678901234567890);
		// Das Ergenbis wird trotz dem Plus mit Leerzeichen ausgegeben und auf 17 Nachkommastellen gerundet.
		System.out.println("Zahl " + 0.12345678901234567890f);
		// Der Float rundet auf 8 Nachkommastellen.
		System.out.println("Summe " + (5.6 + 5.8) );
		// Es wird 11,39999 Periode 9 ausgegeben da der Rechentyp zu ungenau ist.
		System.out.println("Summe " + (12345678.0f + 0.1f) );
		// Ausgabe 1,2345678E7.
		System.out.println("Differenz " + (0.123456789f - 0.123456788f) );
		// Die Division wird ausgeführt und das Ergebnis ist 0, da vor dem rechnen auf 8 Nachkommastellen gerundet wird.
		System.out.println("Summe " + ((12345678.0f + 0.1f) + 0.41f) );
		// Das angezeigte Ergebnis ist dasselbe wie ohne dem + 0.41 weil es außerhalb des sichtbarkeitsbereiches liegt.
		System.out.println("Summe " + (12345678.0f + (0.1f + 0.41f)) );
		// Das angezeigte Ergebnis ist dasselbe wie ohne dem + 0.41 weil es außerhalb des sichtbarkeitsbereiches liegt.
 }

}
