package ÜbungFurkan.Polymorphie;

public class CD implements Medium{

	private int breite;
	
	public CD(int breite) {
		this.breite = breite;
	}
	
	@Override
	public double getGewicht() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getBreite() {
		// TODO Auto-generated method stub
		return breite;
	}

}
