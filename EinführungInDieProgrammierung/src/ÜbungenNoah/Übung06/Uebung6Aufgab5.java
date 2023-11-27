package ÜbungenNoah.Übung06;

import java.util.Arrays;

public class Uebung6Aufgab5 {

	public static void main(String[] args) {

		int[][] A = { { 2, 2, 2 }, { 1, 1, 1 }, { 3, 3, 3 } };
		int[][] B = { { 1, 7, 3 }, { 4, 6, 3 }, { 7, 0, 8 } };
		displayArray(A);
		System.out.println("\n");
		displayArray(B);
		System.out.println("\n");
		displayArray(matrixProdukt(A, B));
	}

//	a)
	public static int skalarProdukt(int[] v, int[] w) {
		int ergebnis = 0;
		for (int i = 0; i < v.length; i++)
			ergebnis += v[i] * w[i];
		return ergebnis;
	}

//	b)
	public static int[] getZeile(int[][] A, int i) {
		return A.length > i ? A[i] : null;
	}

//	c)
	public static int[] getSpalte(int[][] B, int j) {
		int[] ergebnis = new int[B.length];
		for (int i = 0; i < B.length; i++) {
			if (B[i].length > j) {
				ergebnis[i] = B[i][j];
			}

		}
		return ergebnis;
	}

//	d)
	public static int[][] matrixProdukt(int[][] A, int[][] B) {
		int[][] c = new int[A.length][B[0].length];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B[0].length; j++) {
				c[i][j] = skalarProdukt(getZeile(A, i), getSpalte(B, j));
			}
		}
		return c;
	}

	public static void displayArray(int[][] stern) {
		for (int j = 0; j < stern.length; j++) {
			System.out.println(Arrays.toString(stern[j]));
		}
	}

}
