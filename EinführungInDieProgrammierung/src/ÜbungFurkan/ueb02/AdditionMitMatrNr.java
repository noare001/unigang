package ÜbungFurkan.ueb02;

import java.util.Scanner;

public class AdditionMitMatrNr {
	
	public static void main(String[] args) {
		System.out.println("Starting");
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		int matrikelNummer = 4124123 + input + scanner.nextInt();
		System.out.println("Ihr ergebnis: " + (matrikelNummer));
	}
}
