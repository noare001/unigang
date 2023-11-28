package ÜbungNils.Übung5;
import java.util.Scanner;
public class PythTripel {
	
	public static void main(String[] args) {
	Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    System.out.println("Geben Sie eine Natürliche Zahl ein");
    int n = myObj.nextInt();  // Read user input
    PythTripel(n);
	}
	public static void PythTripel(int n) {
		System.out.println("Die pythagoräischen Tripel bis " + n + " sind:");
		int tripel = 0;
		for ( int a = 1; a <= n; a++) {
			for ( int b = a+1; b <= n; b++) {
				for ( int c = b+1; c <= a + b; c++) {
					if ( (a*a) + (b*b) == c*c){
						System.out.println(a + "*" + a + "+" + b + "*" + b + "=" + c + "*" + c);
						tripel++;
					}
				}	
			}
		}
		System.out.println("Es wurden " + tripel + " pythagoräische Tripel gefunden.");
	}
}
