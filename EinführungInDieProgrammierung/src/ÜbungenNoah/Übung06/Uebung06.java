package ÜbungenNoah.Übung06;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Uebung06 {

	public static void main(String[] args) {
		
		char[][] stern1 = new char[ ThreadLocalRandom.current().nextInt(1, 10) + 1][ ThreadLocalRandom.current().nextInt(1, 10) + 1];
		fülleChar(stern1);
		
		char[][] stern2 = new char[ ThreadLocalRandom.current().nextInt(1, 10) + 1][ ThreadLocalRandom.current().nextInt(1, 10) + 1];
		fülleChar(stern2);
		

		// Stern1
		System.out.println("Inhalt von Stern 1:");
		displayCharArray(stern1);
		System.out.println("\nSterne Pro Zeile von Stern 1: ");
		berechneSterneProZeile(stern1);
		System.out.println("Sterne Pro Spalte von Stern 1: ");
		berechneSterneProSpalte(stern1);
		System.out.println("Stern 1 hat " + berechneAnzahlZeilen(stern1) + " Zeilen mit mindestens 2 Sternen \n");

		// Stern2
		System.out.println("Inhalt von Stern 2:");
		displayCharArray(stern2);
		System.out.println("\nSterne Pro Zeile von Stern 2: ");
		berechneSterneProZeile(stern2);
		System.out.println("Sterne Pro Spalte von Stern 2: ");
		berechneSterneProSpalte(stern2);
		System.out.println("Stern 2 hat " + berechneAnzahlZeilen(stern2) + " Zeilen mit mindestens 2 Sternen \n");
	}

//	Aufgabe 1
//		a)
//		Referenz (Speicheradresse) auf den Speicherort des Inhalts
//		
//		b)
//		Die Elemente sind mit "null" belegt, da kein true oder false zugewiesen wurde
//		
//		c)
//		Feld[3].length();
//		
//		
//	Aufgabe 2
//		a)
	public static boolean checkNum(int[] nums) {
		return nums.length > 0 && nums[0] == nums[nums.length - 1];
	}

//		b)
	public static int count(int[] nums, int value) {
		int anzahl = 0;
		for (int i : nums) {
			if (nums[i] == value)
				anzahl++;
		}
		return anzahl;
	}

//		c)
	public static void fillFeld() {
		int[][] feld = new int[8][8];
		for (int i = 0; i < feld.length; i++) {
			for (int j = 0; j < feld[i].length; j++) {
				feld[i][j] = i + j + 2;
			}
		}
		for (int j : feld[0]) {
			System.out.println(Arrays.toString(feld[j - 2]));
		}
	}

//	Aufgabe 4
//		a)
	public static void berechneSterneProZeile(char sterne[][]) {
		for (int i = 0; i < sterne.length; i++) {
			int anzahlSterne = 0;
			for (int j = 0; j < sterne[i].length; j++) {
				if (sterne[i][j] == '*')
					anzahlSterne++;
			}
			System.out.println(i + ": " + anzahlSterne);
		}
	}

//	 	b)
	public static void berechneSterneProSpalte(char sterne[][]) {
		for (int i = 0; i < sterne[0].length; i++) {
			int anzahlSterne = 0;
			for (int j = 0; j < sterne.length; j++) {
				if (sterne[j][i] == '*')
					anzahlSterne++;
			}
			System.out.println(i + ": " + anzahlSterne);
		}
	}

//	 	c)
	public static int berechneAnzahlZeilen(char sterne[][]) {
		int zeilenMitZweiSternen = 0;
		for (int i = 0; i < sterne.length; i++) {
			int anzahlSterne = 0;
			for (int j = 0; j < sterne[i].length; j++) {
				if (sterne[i][j] == '*')
					anzahlSterne++;
			}
			if (anzahlSterne > 1)
				zeilenMitZweiSternen++;
		}
		return zeilenMitZweiSternen;
	}

	
	
	public static void fülleChar(char stern[][]) {
		for (int i = 0; i < stern.length; i ++) {
			for (int j = 0; j < stern[i].length; j++) {
				stern[i][j] =  Math.random() > 0.7 ? '*' : 'a';
			}
		}
	}
	
	public static void displayCharArray(char stern[][]) {
		for (int j = 0; j < stern.length; j++) {
			System.out.println(Arrays.toString(stern[j]));
		}
	} 
}
