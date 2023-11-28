package ÜbungFurkan.ueb06;

import java.util.Arrays;

public class uebungen {
//	Aufgabe 01
//
//	a)
//	Arrays
//	b)
//	false (default wert)
//	c)
//	arr[2].length

	public static void main(String[] args) {
		// System.out.println(checkNum(new int[3]));
		// erzeugeFeld(8);
		erzeugeFelder();
		int[][] A = { { 2, 2, 2 }, { 1, 1, 1 }, { 3, 3, 3 } };
		int[][] B = { { 7, 10, 1 }, { 8, 11, 2 }, { 9, 12, 4 } };
		System.out.println(Arrays.deepToString(matrixProdukt(A, B)));
	}

	public static boolean checkNum(int[] nums) {
		return nums.length > 2 && nums[0] == nums[nums.length - 1];
	}

	public static int count(int[] nums, int value) {
		int result = 0;
		for (int i : nums) {
			if (value == nums[i]) {
				result++;
			}
		}
		return result;
	}

	public static void erzeugeFeld(int size) {
		int[][] feld = new int[size][size];
		for (int i = 0; i < feld.length; i++) {
			for (int j = 0; j < feld[i].length; j++) {
				feld[i][j] = i + j + 2;
			}
			System.out.println(Arrays.toString(feld[i]));
		}
	}

	// Ab hier Praktika
	public static void berechneSterneProZeile(char[][] feld) {
		for (int i = 0; i < feld.length; i++) {
			int anzahlSterne = 0;
			for (int j = 0; j < feld[i].length; j++) {
				if (feld[i][j] == '*') {
					anzahlSterne++;
				}
			}
			System.out.println(i + " : " + anzahlSterne);
		}
	}

	public static void berechneSterneProSpalte(char[][] feld) {
		for (int i = 0; i < feld[0].length; i++) {
			int anzahlSterne = 0;
			for (int j = 0; j < feld.length; j++) {
				if (feld[j][i] == '*') {
					anzahlSterne++;
				}
			}
			System.out.println(i + " : " + anzahlSterne);
		}
	}

	public static int berechneAnzahlZeilen(char[][] feld) {
		int result = 0;
		for (int i = 0; i < feld.length; i++) {
			int anzahlSterne = 0;
			for (int j = 0; j < feld[i].length; j++) {
				if (feld[i][j] == '*') {
					anzahlSterne++;
				}
			}
			if (anzahlSterne > 1) {
				result++;
			}
		}
		return result;
	}

	public static void erzeugeFelder() {
		char[][] feldEins = { { '2', 'e', '4' }, { '+', '*', '*', 'F', '#' }, { 'D', 'F', 'F', '*', 'm' },
				{ '*', '*', '*' }, { '9', '*', 'i', 'l', '+', '*' } };
		char[][] feldZwei = { { 'o', 'D', 'L', '*' }, { 'C', 'C', '*', '*', 'j' }, { 'W', 'f', 'l', 'O' },
				{ 'l', '*', '*', 'D' }, { 'V', 'b', '*', '+', '*' } };

		// a)
		berechneSterneProZeile(feldEins);
		berechneSterneProZeile(feldZwei);
		// b)
		char[][] rechteckigesFeld = { { '*', '*', '*' }, { 'e', 'e', '*' }, { '*', '*', '*' }, { '*', '*', '*' } };
		berechneSterneProSpalte(rechteckigesFeld);
	}

	// Aufgabe 5 Praktika
	public static int skalarProdukt(int[] v, int[] w) {
		int result = 0;
		for (int i = 0; i < v.length; i++) {
			result += v[i] * w[i];
		}
		return result;
	}

	public static int[] getZeile(int[][] A, int i) {
		return A.length > i ? A[i] : null;
	}

	public static int[] getSpalte(int[][] B, int j) {
		int[] result = new int[B.length];
		for (int i = 0; i < B.length; i++) {
			if (B[i].length > j) {
				result[i] = B[i][j];
			}
		}
		return result;
	}

	public static int[][] matrixProdukt(int[][] A, int[][] B) {
		int[][] c = new int[A.length][B[0].length];
		if (A.length == B[0].length) {
			for (int i = 0; i < A.length; i++) {
				for (int j = 0; j < B[0].length; j++) {
					c[i][j] = skalarProdukt(getZeile(A, i), getSpalte(B, j));
				}
			}
			return c;
		}
		return null;
	}
}
