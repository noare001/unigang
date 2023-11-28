package ueb07;

public class Praktikum {

	public static void main(String[] args) {
		int[][] arr = { {1,5,3,6,2,4 } , {3,6,4,2,6,3}, {3,6,3,7,5,7},{45,2,65,2,76,3},{34,123,54,1,645,77},{23,56,24,75,234,43}};
		System.out.println(summeQuadrat(arr, 0, 0));
		System.out.println(summeQuadrat(arr, 6, 5));
		System.out.println(summeQuadrat(arr, 5, 5));
		System.out.println(SummeGroesstesQuadrat(arr));
		
		
	}

	public static int summeQuadrat(int[][] feld, int i, int j) {
		if (feld.length > (i+1) && feld[i].length > (j+1) && feld[i + 1].length > (j+1)) {
			return feld[i][j] + feld[i + 1][j] + feld[i][j + 1] + feld[i + 1][j + 1];
		} else {
			return 0;
		}
	}
	
	public static int SummeGroesstesQuadrat(int[][] feld) {
		int groessteSumme = 0;
		for(int i = 0; i<feld.length;i++) {
			for(int j = 0; j <feld[i].length;j++) {
				if(groessteSumme < summeQuadrat(feld, i, j)) {
					groessteSumme = summeQuadrat(feld, i, j);
				}
			}
		}
		return groessteSumme;
	}
}
