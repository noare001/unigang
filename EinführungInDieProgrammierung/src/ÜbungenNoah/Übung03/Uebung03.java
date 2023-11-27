 package ÜbungenNoah.Übung03;

public class Uebung03 {
	public static void main(String[] args) {
		
		//Aufgabe 1
		
			// a) 
				//Ein unärer Operator hat nur einen Operanten und binäre haben zwei Operanten
	
			// b)
				//Aufgabe1b();
	
		//Aufgabe 2
			
			// a)
				// (i) 0000010100
				//		20 / 2 = 10 r0
				//	10 / 2 = 5 r 0
				//	5 / 2 = 2 r 1
				//	2 / 2 = 1 r 0
				//	1 / 2 = 0 r 1
				// (ii) 0000001011 = 1111110100 
				//					+         1
				//				   = 1111110101
				//	11 / 2 = 5 r1
				//	5 / 2 = 2 r 1
				//	2 / 2 = 1 r 0
				//	1 / 2 = 0 r 1
				
		//Aufgabe 3
			//Aufgabe3();
		
		//Aufgabe 4
		//	a) int x = 13; int y = x; ist korrekt
		// 	b) int x = 0; byte y = x; ist nicht korrekt, da byte auf beiden Seiten sein muss
		//  c) byte x = 0; int y = x; ist korrekt	
		//	d) int y = 3.1415; falsch da Integer keine Kommazahlen speichern kann: wird auf 3 runden -> double y
		// 	e) float y = 3.1415; ist korrekt
		//  f) float y = 3.1415f; ist korrekt
				
		//Aufgabe 5
			//Aufgabe5();
	
		//Aufgabe 6
			//Aufgabe6(2000);
		
	}
	
	public static void Aufgabe1b() {
		int x = 31;
		int y = x>>4;
		int z = y<<2;
		System.out.println("x ist: " + x);
		System.out.println("y ist: " + y);
		System.out.println("z ist: " + z);
	}
	
	public static void Aufgabe3() {
		int a = 1;
		int b = 2;
		System.out.println(++a);
		System.out.println(a);
		System.out.println(b++);
		System.out.println(b);
		System.out.println(a++ + " " + --b);
	}
	
	public static void Aufgabe5() {
		// Zeichenketten
		System.out.println("4*5"); //gibt 4*5 aus da 4*5 in Anführungsstrichen ist und somit als Text ausgegeben wird
		System.out.println("Dies ist" + "ein Text"); // gibt Dies istein Text aus, da die zwei Strings zusammengefügt werden und kein Leerzeichen eingefügt wird
		System.out.println("Dies ist ein \nText" ); // gibt Dies ist ein (nächste Zeile) Text aus da \n in die nächste Zeile g
		// Zeichen
		System.out.println("\u0065"); //gibt e zurück da \u0065 der Unicode für e ist
		System.out.println("\""); //gibt " zurück da nur so Anführungsstriche gezeichnet werden
		// Ganze Zahlen
		System.out.println(2147483647); //gibt Zahl normal zurück
		System.out.println(2147483647+1); //gibt -2147483648 zurück, da +1 negativ macht
		System.out.println(0xFF); //gibt 255 zurück da 0xFF die Hexadarstellung für 255 ist
		System.out.println(0xFFFFFF); //gibt 16777215 zurück, da 0xFFFFFF die Hexadarstellung dafür ist
		// Gleitpunktzahlen
		System.out.println("Zahl " + 0.12345678901234567890); //gibt Zahl 0.12345678901234568 zurück, da double nur 15 Nachkommastellen darstellen kann
		System.out.println("Zahl " + 0.12345678901234567890f); //gibt Zahl 0.12345679 da float nur 8 Nachkommstellen darstellen kann
		System.out.println("Summe " + (5.6 + 5.8) ); //gibt Summe 11.399999999999999 zurück, da die Bitdarstellung von 0.2, 0.4 usw. periodisch ist
		System.out.println("Summe " + (12345678.0f + 0.1f) ); //gibt Summe 1.2345678E7 zurück da float nur 7 stellen Darstellen kann und trotzdem versucht möglichst genau zu sein
		System.out.println("Differenz " + (0.123456789f - 0.123456788f) ); //gibt Different 0.0 zurück da float nur 8 Nachkommastellen darstellen kann und die beiden Zahlen bis zur achten Nachkommastelle gleich sind
		System.out.println("Summe " + ((12345678.0f + 0.1f) + 0.41f) ); //gibt Summe 1.2345678E7 zurück, da 0.1f und 0.41f abgeschnitten werden weil float nicht so viele Stellen darstellen kann
		System.out.println("Summe " + (12345678.0f + (0.1f + 0.41f)) ); // gibt Summe 1.2345679E7 zurück, da 0.1f und 0.41f wieder zusammen auf 1 gerundet werden
	}
	
	public static void Aufgabe6(int jahr) {
		System.out.println(jahr % 4 == 0 && (jahr % 400 == 0 || jahr % 100 != 0));
	}
}
