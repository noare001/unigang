package ÜbungenNoah.Übung08.Aufgabe4;

public class RechteckTest {

	public static void main(String[] args) {
			Rechteck r1 = new Rechteck(0,0,7,5);
			System.out.println(r1);
			Rechteck r2 = new Rechteck(6,4,2,2);
			System.out.println(r2);
			Rechteck r3 = new Rechteck(6,-1,2,2);
			System.out.println(r3);
			Rechteck r4 = new Rechteck(-1,-1,2,2);
			System.out.println(r4);
			Rechteck r5 = new Rechteck(-1,4,2,2);
			System.out.println(r5);
			
			System.out.print(r1.schneidet(r2) + " ");
			System.out.print(r1.schneidet(r3) + " ");
			System.out.print(r1.schneidet(r4) + " ");
			System.out.print(r1.schneidet(r5) + " ");
			System.out.println(r3.schneidet(r2));
	}

}
