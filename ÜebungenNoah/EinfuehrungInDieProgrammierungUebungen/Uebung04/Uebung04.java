package Uebung04;

import java.util.Scanner;

public class Uebung04 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double radius = scanner.nextInt();
		double höhe = scanner.nextInt();
		System.out.println(" Radius ist " + radius + "cm,\n Höhe ist " + höhe + "cm,\n Umfang ist " + umfang(radius)
				+ "cm,\n Deckelfläche ist " + deckelFlaeche(radius) + "cm^2,\n Mantelfäche ist "
				+ mantelflaeche(höhe, umfang(radius)) + "cm^2,\n Oberfläche ist "
				+ oberflaeche(deckelFlaeche(radius), mantelflaeche(höhe, umfang(radius))) + "cm^2 \n und Volumen ist "
				+ volumen(deckelFlaeche(radius), höhe) + "cm^3");
	}

	public static double umfang(double r) {
		return 2 * Math.PI * r;
	}

	public static double deckelFlaeche(double r) {
		return Math.PI * r * r;
	}

	public static double mantelflaeche(double h, double u) {
		return u * h;
	}

	public static double oberflaeche(double df, double mf) {
		return 2 * df + mf;
	}

	public static double volumen(double df, double h) {
		return df * h;
	}
}

//Aufgabe 1
//a)
//	Die Richtung, in welche die Operatoren ausgewertet werden.
//
//b) 
//	(i) ist richtig. (ii) ist nicht richtig, da ein double eingegeben wird, ein Long aber erwartet. (iii) ist nicht richtig, da tuWas kein integer ist und dementsprechend nichts zurückgeben kann. 
//
//c)
//	Ja, wenn es kein void ist sondern ein String, Integer oder ähnliches. 
//	
//Aufgabe 2
//a)
//	i >= 0 && i < 7 
// 
//b)
// 1.
//13.0 / 4 + 5 / 3 + 11 % 7
//((13.0 / 4) + (5 / 3)) + (11 % 7)
//		13.0 / 4 = 3.25
//		5 / 3 = 1
//	3.25 + 1 = 4.25
//	11 % 7 = 4
//4.25 + 4 = 8.25

// 2. 
//	5 > 3 = true
//	erg2 == false 
//	--> da ein "oder" zwischen beiden Ausdrücken ist und 5 > 3 gleich true ist wird niemals in den zweiten Ausdruck gehen und erg2 ist immer true
//	
// 3. 
// 5 > 4 = true
// also in 3 > 4 = false 
// also in 'd' 
// --> "end"

//Aufgabe 3
//10: x = 1332;
//12: b = 2664
//21: b = 2664

//Aufgabe 4
//Aufruf 2, da hoppla mit 3 doubles aufgerufen wird, es aber keine Methode hoppla mit 3 doubles gibt
//Aufruf 4, da es kein hoppla mit double long long gibt
//
//Ausgabe bei Aufruf 1: 
//	"lld"
//
//Aufgabe bei Aufruf 3:
//	"dld"