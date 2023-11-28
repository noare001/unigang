package ÜbungenNoah.Übung08.Aufgabe4;

public class Punkt2D {

	private double x;
	private double y;
	
	public Punkt2D(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public boolean vergleichePunkt(Punkt2D P) {
		return x == P.getX() && y == P.getY();
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
}
