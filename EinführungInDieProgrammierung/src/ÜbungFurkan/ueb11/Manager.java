package ÜbungFurkan.ueb11;

public class Manager extends Mitarbeiter{
	private double festgehalt;
	private double provision;
	private double umsatz;
	
	public Manager(String name, double fGehalt, double provision, Abteilung abt) {
		super(name, abt);
		this.festgehalt = fGehalt;
		this.provision = provision;
	}
	
	public void setUmsatz(double umsatz) {
		this.umsatz = umsatz;
	}
	
	public String toString() {
		return getName() + " id:" + getPersonalnummer() + 
				" || Festgehalt: "+ festgehalt +", Provision: " + provision + ", Umsatz: " + umsatz; 
	}

	@Override
	public double berechneGehalt() {
		return festgehalt + provision * umsatz;
	}
	
	
}
