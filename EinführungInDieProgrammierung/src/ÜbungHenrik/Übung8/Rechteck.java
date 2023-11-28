package ÜbungHenrik.Übung8;

public class Rechteck {
	private double seitenLaengeX;
	private double seitenLeangeY;
	private double x;
	private double y;

	public Rechteck(double x, double y, double seitenLaengeX, double seitenLeangeY) {
		this.x = x;
		this.y = y;
		this.seitenLaengeX = seitenLaengeX;
		this.seitenLeangeY = seitenLeangeY;
	}

	public boolean schneidet(Rechteck R) {
		if (this.getEckeLinksUnten().getY() >= R.getEckeLinksOben().getY()
				|| this.getEckeLinksUnten().getX() >= R.getEckeRechtsUnten().getX()
				|| this.getEckeLinksOben().getY() <= R.getEckeLinksUnten().getY()
				|| this.getEckeRechtsOben().getX() <= R.getEckeLinksOben().getX()) {
			return false;
		} 
		return true;
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

	public String toString() {
		String s = "Rechteck mit Seitenlängen " + this.getSeitenLaengeX() + " und " + this.getSeitenLeangeY()
				+ " an der Stelle (" + this.getX() + "," + this.getY() + ")";
		return s;
	}

	public Punkt2D getEckeLinksUnten() {
		Punkt2D ans = new Punkt2D(x, y);
		return ans;
	}

	public Punkt2D getEckeLinksOben() {
		Punkt2D ans = new Punkt2D(x, y + seitenLeangeY);
		return ans;
	}

	public Punkt2D getEckeRechtsUnten() {
		Punkt2D ans = new Punkt2D(x + seitenLaengeX, y);
		return ans;
	}

	public Punkt2D getEckeRechtsOben() {
		Punkt2D ans = new Punkt2D(x + seitenLaengeX, y + seitenLeangeY);
		return ans;
	}

	public double getSeitenLaengeX() {
		return seitenLaengeX;
	}

	public void setSeitenLaengeX(double seitenLaengeX) {
		this.seitenLaengeX = seitenLaengeX;
	}

	public double getSeitenLeangeY() {
		return seitenLeangeY;
	}

	public void setSeitenLeangeY(double seitenLeangeY) {
		this.seitenLeangeY = seitenLeangeY;
	}
}
