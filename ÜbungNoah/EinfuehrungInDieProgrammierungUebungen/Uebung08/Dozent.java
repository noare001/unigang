package Uebung08;

public class Dozent {

	private String name;
	private String lehrgebiet;
	private boolean dekan = false;
	private char geschlecht;
	
	public Dozent(String name, String lehrgebiet, char geschlecht) {
		super();
		this.name = name;
		this.lehrgebiet = lehrgebiet;
		this.geschlecht = geschlecht;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLehrgebiet() {
		return lehrgebiet;
	}

	public void setLehrgebiet(String lehrgebiet) {
		this.lehrgebiet = lehrgebiet;
	}

	public boolean isDekan() {
		return dekan;
	}

	public void setDekan(boolean dekan) {
		this.dekan = dekan;
	}

	public char getGeschlecht() {
		return geschlecht;
	}

	public void setGeschlecht(char geschlecht) {
		this.geschlecht = geschlecht;
	}
	
	
}
