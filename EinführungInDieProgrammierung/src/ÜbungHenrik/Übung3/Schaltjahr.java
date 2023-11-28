package ÜbungHenrik.Übung3;

public class Schaltjahr {

	public static void main(String[] args) {
		int jahr = 2006;
		System.out.println( jahr % 4== 0 && (jahr % 400 == 0 || jahr % 100 != 0));
	}
}
