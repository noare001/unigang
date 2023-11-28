package ÜbungNils.Übung6;

public class VektorenUndMatrizen {
	public static void main(String[] args) {
		int[] v = { 2, 4, 1};
		int[] w = { -3, 0, 3};
		int[][] A = new int[5][7];
		skalarProdukt(v, w );
		getZeile (A, 3);
	}
		
	
	public static int skalarProdukt(int[] v, int[] w){
		int ergebnis = 0;
		for ( int i = 0; i< v.length; i++) {
		 ergebnis += v[i] * w[i];
		}
		System.out.println( ergebnis);
        return ergebnis;
	}
	
	public static int[] getZeile(int[][] A, int i) {
      return A[i];
	}
}
   
