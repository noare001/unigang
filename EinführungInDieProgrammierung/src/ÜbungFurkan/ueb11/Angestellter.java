package ÜbungFurkan.ueb11;

public class Angestellter extends Mitarbeiter {

	public double grundgehalt;
	public double ortszuschlag;
	public double zulage;
	
	public Angestellter(String name, double gGehalt, double ortszuschlag, double zulage, Abteilung abt) {
		super(name, abt);
		grundgehalt = gGehalt;
		this.ortszuschlag = ortszuschlag;
		this.zulage = zulage;
	}

	public String toString() {
		return getName() + " id:" + getPersonalnummer() + 
				"|| Grundgehalt: " + grundgehalt + ", Ortszuschlag: " + ortszuschlag + 
				", Zulage: " + zulage;
	}
	
	@Override
	public double berechneGehalt() {
		// TODO Auto-generated method stub
		return grundgehalt + ortszuschlag + zulage;
	}

}
