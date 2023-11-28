package ÜbungNils.Übung3;
import java.util.Scanner;

public class Schaltjahr {
	
	public static void main(String[] args) {

			    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
			    System.out.println("Jahr eingeben");

			    int Jahr = myObj.nextInt();  // Read user input
			    
			    if ( Jahr % 4 == 0 ){
			       if ( Jahr % 100 == 0){
			    	  if ( Jahr % 400 == 0) {
			    		  System.out.println( Jahr + " ist ein Schaltjahr" );
			    	  }else { 
			    	    System.out.println( Jahr + " ist kein Schaltjahr" );
			     }}else {
			         System.out.println( Jahr + " ist ein Schaltjahr" );
	          }}else {
	        	 System.out.println( Jahr + " ist kein Schaltjahr" );  
		      }
		}	    	
	  }
	


