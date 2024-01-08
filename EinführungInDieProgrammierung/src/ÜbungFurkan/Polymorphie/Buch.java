package ÜbungFurkan.Polymorphie;

public class Buch implements Medium{

	private int breite;
	private double gewicht;
	
	public Buch(int breite, double gewicht) {
		this.gewicht = gewicht;
		this.breite = breite;
	}
	
	@Override
	public double getGewicht() {
		return gewicht;
	}

	@Override
	public int getBreite() {
		return breite;
	}

}
