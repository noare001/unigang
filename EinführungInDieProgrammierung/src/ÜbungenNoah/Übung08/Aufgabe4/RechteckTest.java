package ÜbungenNoah.Übung08.Aufgabe4;

import java.util.Arrays;

public class RechteckTest {

	public static void main(String[] args) {
		Rechteck r1 = new Rechteck(0, 0, 7, 5);
		System.out.println(r1);
		Rechteck r2 = new Rechteck(6, 4, 2, 2);
		System.out.println(r2);
		Rechteck r3 = new Rechteck(6, -1, 2, 2);
		System.out.println(r3);
		Rechteck r4 = new Rechteck(-1, -1, 2, 2);
		System.out.println(r4);
		Rechteck r5 = new Rechteck(-1, 4, 2, 2);
		System.out.println(r5);

		System.out.print(r1.schneidet(r2) + " ");
		System.out.print(r1.schneidet(r3) + " ");
		System.out.print(r1.schneidet(r4) + " ");
		System.out.print(r1.schneidet(r5) + " ");
		System.out.println(r3.schneidet(r2));

		drawSquares(r1, r2);

	}

	public static void drawSquare(Rechteck A, String[][] ans) {
		for (int i = (int) A.getY(); i < A.getY() + A.getSeitenlaengeY(); i++) {
			for (int j = (int) A.getX(); j < A.getX()
					+ A.getSeitenlaengeX(); j++) {
				if (j == A.getX() || j == A.getX() + A.getSeitenlaengeX()-1
						|| i == A.getY()
						|| i == A.getY() + A.getSeitenlaengeY()-1) {
					ans[i][j] = "■ ";
				}
			}
		}
	}

	public static void drawSquares(Rechteck A, Rechteck B) {
		int maxX = (int) Math.max(A.getX() + A.getSeitenlaengeX(),
				B.getX() + B.getSeitenlaengeX());
		int maxY = (int) Math.max(A.getY() + A.getSeitenlaengeY(),
				B.getY() + B.getSeitenlaengeY());

		String[][] ans = new String[maxY][maxX];

		for (String[] row : ans) {
			Arrays.fill(row, "  ");
		}

		drawSquare(A, ans);
		drawSquare(B, ans);

		displayCharArray(ans);
	}

	public static void displayCharArray(String stern[][]) {
		for (int i = stern.length-1; i >= 0; i--) { // int i = stern.length-1; i >= 0; i--  -> Zentrum von Koordinatensystem oben links
			for (String cell : stern[i]) {
				System.out.print(cell);
			}
			System.out.println();
		}
	}

}
