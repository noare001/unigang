package ueb07;

import java.util.Arrays;

public class uebungen {

	public static void main(String[] args) {
//		int[] a = {2,5,7,8,9,13};
//		int[] b = {1,6,8,24};
//		System.out.println(Arrays.toString(merge(a, b)));
		weinachtsbaum(6);
	}

	public static double geometrischeSumme(int n, double q) {
		double summe = 0;
		for (int i = 0; i <= n; i++) {
			double zwischenSumme = 1;
			for (int j = 0; j < i; j++) {
				zwischenSumme *= q;
			}
			summe += zwischenSumme;
		}
		return summe;
	}

	public static void weinachtsbaum(int n) {
		weinachtsbaumRek(n, 1);
	}
	
	public static void weinachtsbaumRek(int n, int sterne) {
		if(n > 0 ) {
			String s = "";
			for(int i = n; i > 0; i--) {
				s += " ";
			}
			for(int i = sterne; i>0 ; i--) {
				s += "*";
			}
			for(int i = n; i > 0; i--) {
				s += " ";
			}
			System.out.println(s);
			weinachtsbaumRek(n-1, sterne+2);
		}
	}
	
	public static int[] merge(int[] a, int[] b) {
		int[] result = new int[a.length+b.length-1];
		int smallestFromA = getSmallestFromArray(a, Integer.MIN_VALUE);
		int smallestFromB = getSmallestFromArray(b, Integer.MIN_VALUE);
		result[0] = smallestFromA > smallestFromB ? smallestFromB : smallestFromA;
		for(int i = 1; i<result.length;i++) {
			smallestFromA = getSmallestFromArray(a, result[i-1]);
			smallestFromB = getSmallestFromArray(b, result[i-1]);
			result[i] = smallestFromA > smallestFromB ? smallestFromB : smallestFromA;
		}
		return result;
	}
	
	public static int getSmallestFromArray(int[] arr, int min) {
		for(int i = 0; i<arr.length;i++) {
			if(min < arr[i]) {
				return arr[i];
			}
		}
		return Integer.MAX_VALUE;
	}
}
