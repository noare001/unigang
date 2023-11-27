package ÜbungenNoah.Übung08.Aufgabe4;

public class Rechteck {

	private double x;
	private double y;
	private double seitenlaengeX;
	private double seitenlaengeY;
	
	
	public Rechteck(double x, double y, double seitenlaengeX, double seitenlaengeY) {
		super();
		this.x = x;
		this.y = y;
		this.seitenlaengeX = seitenlaengeX;
		this.seitenlaengeY = seitenlaengeY;
	}

	 public String toString() {
		 return "Rechteck mit Seitenlängen " + seitenlaengeX + " und " + seitenlaengeY + " an der Stelle (" + x + "," + y + ")";
	 }
	 
	 public boolean schneidet (Rechteck R) {
		 
		 double schnittmengeUntenLinksX = Math.max(getEckeLinksUnten().getX(), R.getEckeLinksUnten().getX());
		 double schnittmengeUntenLinksY = Math.max(getEckeLinksUnten().getY(), R.getEckeLinksUnten().getY());
		 
		 double schnittmengeObenRechtsX = Math.min(getEckeRechtsOben().getX(), R.getEckeRechtsOben().getX());
		 double schnittmengeObenrechtsY = Math.min(getEckeRechtsOben().getY(), R.getEckeRechtsOben().getY());	 
		 
		 return schnittmengeUntenLinksX < schnittmengeObenRechtsX && schnittmengeUntenLinksY < schnittmengeObenrechtsY ;
	 }
	
	public Punkt2D getEckeLinksUnten() {
		return new Punkt2D(x, y+seitenlaengeY);
	}
	
	public Punkt2D getEckeLinksOben() {
		return new Punkt2D(x, y);
	}
	
	public Punkt2D getEckeRechtsUnten() {
		return new Punkt2D(x+seitenlaengeX, y+seitenlaengeY);
	}
	
	public Punkt2D getEckeRechtsOben() {
		return new Punkt2D(x+seitenlaengeX, y);
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


	public double getSeitenlaengeX() {
		return seitenlaengeX;
	}


	public void setSeitenlaengeX(double seitenlaengeX) {
		this.seitenlaengeX = seitenlaengeX;
	}


	public double getSeitenlaengeY() {
		return seitenlaengeY;
	}


	public void setSeitenlaengeY(double seitenlaengeY) {
		this.seitenlaengeY = seitenlaengeY;
	}
	
	
	
}
