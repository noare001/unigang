package ÜbungNils.Übung6;

public class AnzahlSterne {
	public static void main(String[] args) {
		char[][] Array1 = new char [][] {{ '*', 'A', '*'},{ '*', },{ 'B', 'C', 0, 'a'}};
		char[][] Array2 = new char [][] {{ '*', 'A', '*', 'A'},{'*','*','*','B'},{'B','C',0,'c'}};
		
	 berechneSterneProZeile(Array1);
	 berechneSterneProSpalte(Array2);
	}
	
	public static void berechneSterneProZeile( char[][] eintrag){
		for ( int i = 0; i< eintrag.length; i++) {
			int zaehler = 0;
			for ( int j = 0; j< eintrag[i].length; j++) {
		       if ( eintrag[i][j] == '*') {
		    	   zaehler++;
		       }
			}
			System.out.println( i + ":" + zaehler );
		}
	 }
	public static void berechneSterneProSpalte( char[][] eintrag){
		int anzahlZeilen = 0;
		for ( int i = 0; i< eintrag.length; i++) {
			anzahlZeilen++;
		}
		for ( int i = 0; i< anzahlZeilen; i++) {
			int zaehler = 0;
			for ( int j = 0; j< eintrag.length; j++) {
		       if ( eintrag[i][j] == '*') {
		    	   zaehler++;
		       }
			}
			System.out.println( i + ":" + zaehler );
		}
	 }
	public static void berechneAnzahlZeilen( char[][] eintrag) {
		
		
	}
}
		
		
	


