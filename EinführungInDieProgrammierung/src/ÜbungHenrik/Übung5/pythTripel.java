package ÜbungHenrik.Übung5;

import java.util.Scanner;

public class pythTripel {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Geben Sie die ganze Zahl n an");
		int n= scanner.nextInt();
		System.out.println("Die pythagoräischen Tripel bis " + n + " sind: ");
		pythTripel(n);
		
	}
	
	public static void pythTripel( int n) {
		int anzahl= 0;
		for(int i = 1; i <=n ; i++) {
			for(int j = i ; j <= n ; j++) {
				for(int k = j ; k <= i+j; k++) {
					if((i * i) + (j*j) == (k*k)) {
						anzahl++;
						System.out.println( i + " * "+ i + " + "+ j + " * " + j +" = " + k + " * " + k);
					}
				}
			}
		}
		System.out.println("Es wurden "+ anzahl + " pythagoräische Tripel gefunden");
	}
}
