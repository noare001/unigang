package ueb04;

import java.util.Scanner;

public class Dosenberechnung {

	private Scanner scanner;
	
	public static void main(String[] args) {
		new Dosenberechnung();
	}
	
	public Dosenberechnung() {
		//Prep
		scanner = new Scanner(System.in);
		System.out.println("Gib den Radius an");
		double radius = scanner.nextDouble();
		System.out.println("Gib die Höhe an");
		double hoehe = scanner.nextDouble();
		//Antworten
		System.out.println("Umfang: " + umfang(radius));
		System.out.println("Deckelfläche: " + deckelflaeche(radius));
		System.out.println("Mantelfläche: " + mantelflaeche(radius, hoehe));
		System.out.println("Oberfläche: " + oberflaeche(radius, hoehe));
		System.out.println("Volumen: " + volumen(radius, hoehe));
	}
	
	public double umfang(double radius) {
		return Math.PI*radius*2;
	}
	
	public double deckelflaeche(double radius) {
		return radius*radius*Math.PI;
	}
	
	public double mantelflaeche(double radius, double hoehe) {
		return umfang(radius)*hoehe;
	}
	
	public double oberflaeche(double radius, double hoehe) {
		return 2*deckelflaeche(radius)*mantelflaeche(radius, hoehe);
	}
	
	public double volumen(double radius, double hoehe) {
		return deckelflaeche(radius)*hoehe;
	}
}
