package ÜbungHenrik.Übung7;

import java.util.Scanner;

public class Teileranzahl {

	public static void main(String[] args) {
		System.out.println("------------------------------------------------------------------------------\r\n"
				+ "1 Teileranzahl für n\r\n"
				+ "2 Maximale Teileranzahl für die Zahlen 1 bis n\r\n"
				+ "3 Fertig\r\n"
				+ "------------------------------------------------------------------------------");
		Scanner scanner = new Scanner(System.in);
		int auswahl = scanner.nextInt();
		if(auswahl > 3 || auswahl <0) {
			main(args);
		}
		if(auswahl == 1) {
			System.out.println("Bitte geben sie n an: ");
			int n = scanner.nextInt();
			System.out.println("Die Zahl " +n+" hat " +teileranzahl(n)+ " Teiler.");
		}
		if(auswahl == 2) {
			System.out.println("Bitte geben sie n an: ");
			int n = scanner.nextInt();
			System.out.println("Die Zahl mit den meisten Teilern ist "+ maxTeilerReturn(n)+ " mit "+ maximaleTeilerAnzahl(n) + " Teilern.");
		}
		if(auswahl == 3) {
			System.out.println("Fertig");
		}
	}
	
	public static int teileranzahl(int n) {
		int ans = 0;
		for(int i = 1; i<=n; i++) {
			if( n % i == 0) {
				ans++;
			}
		}
		return ans;
	}
	
	public static int maximaleTeilerAnzahl(int n) {
		int teilerAnz = 0;
		int maxTeiler = 0;
		for( int i = 1; i<n ; i++) {
			if( teilerAnz < teileranzahl(i)) {
				teilerAnz = teileranzahl(i);
				maxTeiler = i;
			}
		}
		
		return teilerAnz;
	}
	
	public static int maxTeilerReturn(int n) {
		int maxTeiler = 0;
		int teilerAnz = 0;
		for( int i = 0; i<n ; i++) {
			if(teilerAnz < teileranzahl(i)) {
				maxTeiler = i;
			}
		}
		return maxTeiler;
	}
}
