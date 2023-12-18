package ÜbungFurkan.ueb11;

public class Geschaeftsfuehrer extends Manager{

	private double zulage;
	
	public Geschaeftsfuehrer(String name, double fGehalt, double provision, double zulage, Abteilung abt) {
		super(name, fGehalt, provision, abt);
		this.zulage = zulage;
	}
	
	public String toString() {
		return super.toString() + ", Zulage: " + zulage;
	}
	
	@Override
	public double berechneGehalt() {
		return super.berechneGehalt() + zulage;
	}

}
