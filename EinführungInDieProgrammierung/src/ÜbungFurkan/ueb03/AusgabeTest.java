package ÜbungFurkan.ueb03;

public class AusgabeTest {

	public static void main(String[] args) {
		// Zeichenketten
		System.out.println("4*5"); // (4*5) Es wird nicht ausmultipliziert, da dies als eine Zeichenkette gesehen
									// wird
		System.out.println("Dies ist" + "ein Text"); // (Dies istein Text) Es werden 2 Zeichenketten miteinander
														// addiert, d.h. aneinander
														// gehängt
		System.out.println("Dies ist ein \nText"); // (Die ist ein
													// Test) Das \n ist das Zeichen für einen Zeilenumbruch
		// Zeichen
		System.out.println("\u0065"); // (e) \uffff zeigt, dass die folgende hexadecimalzahl der unicode für ein Zeichen ist. 0065 sthet hier für ein e
		System.out.println("\""); // (") Da der Backslash (\) vor dem Anführungszeichen dafür sorgt ,
		// dass das Anführungszeichen so wie es ist gelsesen wird, anstatt in seiner
		// Funktion Strings zu kennzeichen
		// Ganze Zahlen
		System.out.println(2147483647); // (2147483647) //Da die Zahl in ein String umgewandelt wird
		System.out.println(2147483647 + 1); // (-2147483648) //2147483647 ist der Integer Limit und a Zahlen im default integer sind, wird rückt die Zahl ins negative, wenn man 1 drauf addiert
		System.out.println(0xFF); // (255) FF im Hexadecimalsystem ergibt 255
		System.out.println(0xFFFFFF); // (16777215) FF im Hexadecimalsystem ergibt 255
		// Gleitpunktzahlen
		System.out.println("Zahl " + 0.12345678901234567890); // (Zahl 0.12345678901234568) Es können nicht mehr
																// Nachkommastellen ineiner Zahl ausgelesen werden
		System.out.println("Zahl " + 0.12345678901234567890f); // (Zahl 0.12345679) Da Floats nur bis zu 7
																// Nachkommastellen darstellen können
		System.out.println("Summe " + (5.6 + 5.8)); // (Summe 11.399999999999999) 0.4 ist in binär eine Periodische Zahl. Und da doubles nur begrenzte Anzahl an Bits zur verfügung haben, ist die Summe recht ungenau
		System.out.println("Summe " + (12345678.0f + 0.1f)); //(Summe 1.2345678E7) Die Zahl kann keine weitere Stelle haben, weswen die 0.1f nicht draufaddiert wurde. Ansonsten wird die Zahl hier nur anders dargestellt mit der mantise = 7
		System.out.println("Differenz " + (0.123456789f - 0.123456788f)); // (Differenz 0.0) Beide Floats wurden auf
																			// dieselbe Zahl gerundet
		System.out.println("Summe " + ((12345678.0f + 0.1f) + 0.41f));//(Summe 1.2345678E7) Dieser Zahl kann keine weitere Stelle gegeben werdem, daher ist die Lösung der größte Summand
		System.out.println("Summe " + (12345678.0f + (0.1f + 0.41f)));//(Summe 1.2345679E7) Es wurde um 1 addiert, da 0.1f+0.41f = 0.51f und somit beim addieren mit dem ersten Summanden, die neue Summe aufgerundet wird
	}
}