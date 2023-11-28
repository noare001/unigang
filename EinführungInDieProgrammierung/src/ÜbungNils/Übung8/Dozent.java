package ÜbungNils.Übung8;
class Dozent {
	String name, lehrgebiet;
	boolean dekan = false;
	char geschlecht;
	
	Dozent(String name, String lehrgebiet, char geschlecht)
	{
	this.name = name;
	this.lehrgebiet = lehrgebiet;
	this.geschlecht = geschlecht;
	}
	
	void setName(String name) {
	   this.name = name;
	}
	void setLehrgebiet(String lehrgebiet){
	   this.lehrgebiet = lehrgebiet;
	}
	void setGeschlecht(char geschlecht) {
	    this.geschlecht = geschlecht;
	}
	void setDekan(boolean dekan) {
		this.dekan = dekan;
	}
	String getName() {
		return this.name;		
	}
	String getLehrgebiet() {
		return this.lehrgebiet;
	}
	char getGeschlecht() {
		return this.geschlecht;
	}
	boolean isdekan() {
		return this.dekan;
	}
}