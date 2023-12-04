package ÜbungenNoah.Übung09.LampenRaetsel;

public class Lampe {

	private String position = "left";
	private int timeRemaining = 60;

	public Lampe() {
		super();
	}

	public void changePos() {
		if (position.equals("left")) {
			position = "right";
			System.out.println("Lampe nach rechts bewegt");
		} else {
			position = "left";
			System.out.println("Lampe nach links bewegt");
		}
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getTimeRemaining() {
		return timeRemaining;
	}

	public void setTimeRemaining(int timeRemaining) {
		this.timeRemaining = timeRemaining;
	}

}
