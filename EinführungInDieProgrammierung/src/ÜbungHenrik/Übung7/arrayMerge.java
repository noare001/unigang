package ÜbungHenrik.Übung7;

import java.util.Arrays;

public class arrayMerge {

	
	public static void main (String[] args) {
		int[] a = {1,5,6,7,8};
		int[] b = {2,3,9,10};
		System.out.println(Arrays.toString(merge(a,b)));
		
	}
	
	public static int[] merge(int[] a, int[] b) {
		int[] ans = new int[a.length+b.length];
		for(int i = 0; i< a.length; i++) {
			ans[i] = a[i];
		}
		for(int j = 0; j<b.length; j++) {
			ans[a.length+j] = b[j];
		}
		for(int k = 0; k<ans.length; k++) {
			for(int y = k; y< ans.length; y++) {
				if(ans[k] >ans[y]) {
					int temp = ans[k];
					ans[k] = ans[y];
					ans[y] = temp;
					
				}
			}
		}
		return ans;
	}
}

