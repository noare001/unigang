package ÜbungFurkan.ueb10.Raetsel;

public class Wanderer {

	private int zeit;
	private String name;
	private boolean ueberquert;
	
	public Wanderer(String name, int zeit) {
		this.name = name;
		this.zeit = zeit;
	}
	
	public int getZeit() {
		return zeit;
	}
	
	public boolean hatUeberquert() {
		return ueberquert;
	}
	
	public void ueberquere() {
		ueberquert = !ueberquert;
	}

	public String getName() {
		return name;
	}
	
}
