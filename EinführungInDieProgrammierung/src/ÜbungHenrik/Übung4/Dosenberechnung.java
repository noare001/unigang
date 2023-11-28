package ÜbungHenrik.Übung4;

import java.util.Scanner;

public class Dosenberechnung {
	
	private Scanner scanner;
	
	public static void main (String[] args) {
		new Dosenberechnung();
	}
	
	public Dosenberechnung(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Radius eingeben");
		double radius = scanner.nextDouble();
		System.out.println("Höhe eingeben");
		double höhe = scanner.nextDouble();
			System.out.println("Umfang: " + umfang(radius));
			System.out.println("Deckelfläche: " + deckelfläche(radius));
			System.out.println("Mantelfläche: " + mantelfläche(höhe, radius));
			System.out.println("Oberfläche: " + oberfläche(radius, höhe));
			System.out.println("Volumen: " + volumen(radius, höhe));
		
	}
	
	public static double umfang(double radius) {
		return 2 * Math.PI * radius;
	}
	
	public static double deckelfläche(double radius) {
		return Math.PI * radius * radius;
	}
	
	public static double mantelfläche(double höhe, double radius) {
		return umfang(radius) *höhe;
	}
	
	public static double oberfläche(double radius, double höhe) {
		return 2* deckelfläche(radius) + mantelfläche(höhe, radius);
	}
	
	public static double volumen (double radius, double höhe) {
		return deckelfläche(radius) * höhe;
	}
}



