package ÜbungenNoah.Übung08.Aufgabe4;

import java.util.Arrays;

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
			
			drawSquares(r1, r3);
			
	}

	public static void drawSquare(Rechteck A, String[][] ans) {
	    for (int i = (int) A.getEckeLinksOben().getY(); i < A.getEckeLinksOben().getY() + A.getSeitenlaengeY(); i++) {
	        for (int j = (int) A.getEckeLinksOben().getX(); j < A.getEckeLinksOben().getX() + A.getSeitenlaengeX(); j++) {
	            if (j == A.getEckeLinksOben().getX() || j == A.getEckeLinksOben().getX() + A.getSeitenlaengeX() - 1 || i == A.getEckeLinksOben().getY() || i == A.getEckeLinksOben().getY() + A.getSeitenlaengeY() - 1) {
	                ans[i][j] = "■ ";
	            } else {
	                ans[i][j] = "  ";
	            }
	        }
	        }
	}

	public static void drawSquares(Rechteck A, Rechteck B) {
	    int maxX = (int) Math.max(A.getEckeLinksOben().getX() + A.getSeitenlaengeX(), B.getEckeLinksOben().getX() + B.getSeitenlaengeX()) + 1;
	    int maxY = (int) Math.max(A.getEckeLinksOben().getY() + A.getSeitenlaengeY(), B.getEckeLinksOben().getY() + B.getSeitenlaengeY()) + 1;
	    
	    String[][] ans = new String[maxY][maxX];

	    for (String[] row : ans) {
	        Arrays.fill(row, " ");
	    }

	    drawSquare(A, ans);
	    drawSquare(B, ans);

	    displayCharArray(ans);
	}

	public static void displayCharArray(String stern[][]) {
	    for (String[] row : stern) {
	        for (String cell : row) {
	            System.out.print(cell);
	        }
	        System.out.println();
	    }
	}

	
}
