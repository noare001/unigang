package ÜbungHenrik.Übung7;

import java.util.Scanner;

public class geometrischeSumme {

	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Geben sie n an: ");
		int n = scanner.nextInt();
		System.out.println("Geben sie q an: ");
		double q = scanner.nextDouble();
		System.out.println(geometrischeSumme(n, q));
		
		System.out.println("Geben sie n für den Weihnachstbaum an: ");
		int p = scanner.nextInt();
		weihnachtsBaum(p);
	}


	
	public static double geometrischeSumme(int n , double q) {
		double ans = 0;
		for(int i = 0; i<= n; i++){
			
		
				ans += potenzieren(i, q);
			
			
		}
		return ans;
	}
	
	public static double potenzieren( int n, double q) {
		double ans = q;
		if(n == 0) {
			return 1.0;
		}
		if(n >1 ) {
			
		for( int i = 1; i<n; i++) {
			ans *= q;
		}
		}
		return ans;
	}
	
	
	public static void weihnachtsBaum( int n) {
		int sterne = 1;
		int k = n;
		for( int i=0; i <= n; i++) {
			String row = "";
			for(int u = 0; u <k; u++) {
				row += " ";
			}
			for( int j= 0; j< sterne; j++) {
				row += "*";
			}
			for(int c = 0; c <k; c++) {
				row += " ";
			}
			System.out.println(row);
			sterne += 2;
			k--;
		}		
	}
}
