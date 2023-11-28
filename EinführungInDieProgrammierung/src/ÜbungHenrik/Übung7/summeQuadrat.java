package ÜbungHenrik.Übung7;

public class summeQuadrat {
	public static int[][] quadrat = {{1,2,4,5,3},
									{4,5,3,2,1},
									{8,34,5,2,7},
									{5,78,3,2,43}};
	
	
	public static void main(String[] args) {
		summeGroeßtesQuadrat(quadrat);
	}
	
	public static int summeQuadrat (int[][] a, int i , int j) {
		 int höhe = a.length;
		 int länge = a[0].length;
		 if(i+1 >= höhe || j+1 >= länge){
			 return 0;
		 }
		 return a[i][j]+a[i][j+1]+a[i+1][j]+a[i+1][j+1];
	}
	
	public static void summeGroeßtesQuadrat(int[][] a) {
		int ans = 0;
		int x = 0;
		int y = 0;
		for(int i = 0; i<a.length;i++) {
			for( int j= 0; j<a[0].length; j++) {
				if(ans < summeQuadrat(a,i,j)) {
					ans = summeQuadrat(a, i, j);
					x = i;
					y = j;
				}
			}
		}
		System.out.println("Das 2x2 Feld mit den beginnenden Koordinaten "+ x + " und "+y +" hat die größte Summe mit einer Größe von "+ans);
	}
}
