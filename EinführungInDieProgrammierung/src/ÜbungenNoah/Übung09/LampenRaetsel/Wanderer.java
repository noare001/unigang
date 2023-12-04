package ÜbungenNoah.Übung09.LampenRaetsel;

public class Wanderer {

	private String position = "left";

	private int timeNeeded;
	private String Name;

	public Wanderer(int timeNeeded, String name) {
		super();
		this.timeNeeded = timeNeeded;
		this.Name = name;
	}

	public void changePos() {
		if (position.equals("left")) {
			position = "right";
			System.out.println(Name + " nach rechts bewegt");
		} else {
			position = "left";
			System.out.println(Name + " nach links bewegt");
		}
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getTimeNeeded() {
		return timeNeeded;
	}

	public void setTimeNeeded(int timeNeeded) {
		this.timeNeeded = timeNeeded;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	
	
}
