package ueb05;

import java.util.Scanner;

public class PythTripel {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("Bitte geben Sie eine natürliche Zahl an:");
			int n = scanner.nextInt();
			System.out.println("Die pythagoräischen Tripel bis"+ n + "sind:");
			pythTripl(n);
		}
		
	}
	
	public static void pythTripl(int n) {
		int a = 1;
		int b = 1;
		while(a < n) {
			b = a;
			while(b < n) {
				int c = a*a + b*b;
				for(int i = 1; i*i < c*c;i++) {
					if(c == i*i) {
						System.out.println(a + "*" + a + " + " + b + "*" + b + " = " + i + "*" + i);
					}
				}
				b++;
			}
			a++;
		}
	}
}
