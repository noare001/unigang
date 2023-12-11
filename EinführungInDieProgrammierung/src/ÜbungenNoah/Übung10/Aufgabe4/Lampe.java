package ÜbungenNoah.Übung10.Aufgabe4;

public class Lampe {

	//Standard Position 
	private String position = "left";
	
	//Start timeRamining
	private int timeRemaining = 60;

	/**
	 * KOnstruktor von Lampe
	 */
	public Lampe() {
		super();
	}

	/**
	 * changes Position from left to right and right to left
	 */
	public void changePos() {
		if (position.equals("left")) {
			position = "right";
			System.out.println("Lampe nach rechts bewegt");
		} else {
			position = "left";
			System.out.println("Lampe nach links bewegt");
		}
	}
	
	/**
	 * decreases timeReamining by t
	 * @param t
	 */
	public void decreaseTime(int t) {
		timeRemaining -= t;
	}

	/**
	 * 
	 * @return position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * sets Position at position
	 * @param position
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * 
	 * @return timeReamining
	 */
	public int getTimeRemaining() {
		return timeRemaining;
	}

	/**
	 * Sets timeRemaining at time
	 * @param timeRemaining
	 */
	public void setTimeRemaining(int time) {
		this.timeRemaining = time;
	}

}
