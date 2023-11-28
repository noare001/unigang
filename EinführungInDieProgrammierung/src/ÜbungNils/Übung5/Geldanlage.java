package ÜbungNils.Übung5;
import java.util.Scanner;

public class Geldanlage {

	public static void main(String[] args) {	
		int eingabe;
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Laufzeit in Jahren eingeben");
	    int Laufzeit = myObj.nextInt();  // Read user input
	    System.out.println("Anlagebetrag in Euro eingeben");
	    double betrag = myObj.nextDouble();
	    do {
		System.out.println("-------------------------------------------------------------------");
		System.out.println("1 1,5 % Verzinsung ohne Bonuszahlung");
		System.out.println("2 0,7 % Verzinsung mit 15 Euro Bonuszahlung");
		System.out.println("3 0,4 % Verzinsung mit 20 Euro Bonuszahlung");
		System.out.println("4 0,1 % Verzinsung mit 50 Euro Bonuszahlung");
		System.out.println("5 Fertig");
		System.out.println("-------------------------------------------------------------------");
		System.out.println(" Bitte wählen Sie eine der Möglichkeiten 1-5 aus");
	    eingabe = myObj.nextInt();
		while (eingabe<0 | eingabe>5 ) {
			System.out.println(" Bitte wählen Sie eine der Möglichkeiten 1-5 aus");
			eingabe = myObj.nextInt();
		}
		if ( eingabe != 5) {
		double ausgabe = berechneGuthaben( betrag, Laufzeit, eingabe);
		System.out.println(ausgabe);
		}
	    }while( eingabe != 5);
	}
  public static double berechneGuthaben( double betrag, int Laufzeit, int eingabe) {
	  double zinsen = 0;
	  int bonus = 0;
	  
	  switch(eingabe) {
	  case 1:
		  zinsen = 1.015;
		  bonus = 0;
          break;
	  case 2: 
		  zinsen = 1.007;
		  bonus = 15;
		  break;
	  case 3: 
		  zinsen = 1.004;
		  bonus = 20;
		  break;
	  case 4: 
		  zinsen = 1.001;
		  bonus = 50;
		  break;	  
	  }
	  double ergebnis = betrag;
	  
	  for ( int i = 0; i < Laufzeit; i++) {
		  ergebnis = ergebnis * zinsen + bonus;
	  }
	  return ergebnis;
  } 
}

