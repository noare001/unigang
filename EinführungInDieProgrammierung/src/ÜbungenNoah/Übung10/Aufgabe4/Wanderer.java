package ÜbungenNoah.Übung10.Aufgabe4;

public class Wanderer {

	//Start Position
	private String position = "left";

	//time needed by Wanderer to cross Bridge
	private int timeNeeded;
	
	//Name of Wanderer
	private String Name;

	/**
	 * Constructs Wanderer with timeNeeded and name
	 * @param timeNeeded
	 * @param name
	 */
	public Wanderer(int timeNeeded, String name) {
		super();
		this.timeNeeded = timeNeeded;
		this.Name = name;
	}
	
	/**
	 * changes Position from left to right and right to left
	 */
	public void changePos() {
		if (position.equals("left")) {
			position = "right";
			System.out.println(Name + " nach rechts bewegt");
		} else {
			position = "left";
			System.out.println(Name + " nach links bewegt");
		}
	}

	/**
	 * 
	 * @return position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * sets Position on position
	 * @param position
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * 
	 * @return timeNeeded of this Wanderer
	 */
	public int getTimeNeeded() {
		return timeNeeded;
	}

	/**
	 * sets TimeNeeded to timeNeeded
	 * @param timeNeeded
	 */
	public void setTimeNeeded(int timeNeeded) {
		this.timeNeeded = timeNeeded;
	}

	/**
	 * 
	 * @return Name of this Wanderer
	 */
	public String getName() {
		return Name;
	}

	/**
	 * sets Name of this Wanderer to name
	 * @param name
	 */
	public void setName(String name) {
		Name = name;
	}

	
	
}
