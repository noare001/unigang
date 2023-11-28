package ÜbungNils.Übung8;

public class Rechteck {
	
	double x,y,seitenlaengeX,seitenlaengeY;
	
	Rechteck(double x, double y, double seitenlaengeX, double seitenlaengeY){
		this.x = x;
		this.y = y;
		this.seitenlaengeX = seitenlaengeX;
		this.seitenlaengeY = seitenlaengeY;
	}
	void seitenlaengeX( double seitenlaengeX) {
		 this.seitenlaengeX = seitenlaengeX;
	 }
	void seitenlaengeY( double seitenlaengeY) {
		 this.seitenlaengeY = seitenlaengeY;
	 }
	 double getSeitenlaengeX() {
		 return this.seitenlaengeX;
	 }
	 double getSeitenlaengeY() {
		 return this.seitenlaengeY;
	 }
	 Punkt2D getEckeLinksUnten() {
		 Punkt2D EckeLinksUnten = new Punkt2D( this.x,this.y);
		 return EckeLinksUnten;
	 }
	 Punkt2D getEckeLinksOben() {
		 Punkt2D EckeLinksOben = new Punkt2D( this.x, this.y + this.seitenlaengeY);
		 return EckeLinksOben;
	 }
	 Punkt2D getEckeRechtsUnten() {
		 Punkt2D EckeRechtsUnten = new Punkt2D( this.x + this.seitenlaengeX, this.y);
		 return EckeRechtsUnten;		 
	 }
	 Punkt2D getEckeRechtsOben() {
		 Punkt2D EckeRechtsOben = new Punkt2D( this.x + this.seitenlaengeX, this.y + this.seitenlaengeY);
		 return EckeRechtsOben;
	 }
	 public String toString() {
		 return "Rechteck mit Seitenlängen " + getSeitenlaengeX() + " " + getSeitenlaengeY() + " an der Stelle " + getEckeLinksUnten();
	 }
	 public boolean schneidet (Rechteck R) {
		 double schnittmengeUntenLinksX = Math.max(getEckeLinksUnten().getX(), R.getEckeLinksUnten().getX());
		 double schnittmengeUntenLinksY = Math.max(getEckeLinksUnten().getY(), R.getEckeLinksUnten().getY());
		 
		 double schnittmengeObenRechtsX = Math.min(getEckeRechtsOben().getX(), R.getEckeRechtsOben().getX());
		 double schnittmengeObenrechtsY = Math.min(getEckeRechtsOben().getY(), R.getEckeRechtsOben().getY());	 
		 
		 return schnittmengeUntenLinksX < schnittmengeObenRechtsX && schnittmengeUntenLinksY < schnittmengeObenrechtsY ;
	 }
}

