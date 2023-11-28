package ÜbungHenrik.Übung3;

public class AusgabeTest {
	public static void main(String[] args)
	{
		// Zeichenketten
		System.out.println("4*5"); //Wird als String ausgegeben
		System.out.println("Dies ist" + "ein Text"); // Zwei Strings zusammen adiert ohne Leertaste dazwischen
		System.out.println("Dies ist ein \nText" );// String mit einer neuen zeile durch /n 
		// Zeichen
		System.out.println("\u0065"); // u ruft die ASCII Tabelle auf, 00 sagt 1 Byte und 65 in der ASCII Tabelle ist e
		System.out.println("\""); //  durch den Backslash wird " ausgegeben
		// Ganze Zahlen
		System.out.println(2147483647); // Maximum vom Integer ausgegeben
		System.out.println(2147483647+1); // Maximum vom Int +1 wird zum Minimum vom Int durch die Bitdarstellung
		System.out.println(0xFF); // Hexadezimal durch 0x und FF ist gleich 255
		System.out.println(0xFFFFFF); // 0x für Hexadezimal und FFFFFF ist gleich 16777215
		// Gleitpunktzahlen
		System.out.println("Zahl " + 0.12345678901234567890); // es können nicht mehr Nachkommastellen angezeigt werden
		System.out.println("Zahl " + 0.12345678901234567890f); // Floats können nur 7 Nachkommastellen haben
		System.out.println("Summe " + (5.6 + 5.8) ); // Periode durch Binärdarstellung
		System.out.println("Summe " + (12345678.0f + 0.1f) ); // 7 Nachkommastellen wegen Float und E7 steht für 10 hoch 7
		System.out.println("Differenz " + (0.123456789f - 0.123456788f) ); // alles nach der 7. Nachkommastelle fällt weg
		System.out.println("Summe " + ((12345678.0f + 0.1f) + 0.41f) ); // gibt nur 7 Nachkommastellen nehmen und alles danach wird nicht mitgenommen
		System.out.println("Summe " + (12345678.0f + (0.1f + 0.41f)) ); // 0.1f und 0.41f werden auf 1 aufgerundet und deswegen kommt das ergebnis daraus
	}
}
