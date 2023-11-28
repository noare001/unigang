package ueb08;


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

	public Punkt2D getEckeLinksUnten() {
		return new Punkt2D(x,y+seitenlaengeY);
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
	
	public String toString() {
		return "Rechteckt mit Seitenlängen " + seitenlaengeX + " und " + seitenlaengeY +
				" an der Stelle (" + x + ", " + y + ")";
	}
	
	public boolean schneidet(Rechteck r) {
		return gleicherRechteck(r) || punktInReckteck(r.getEckeLinksOben()) || punktInReckteck(r.getEckeRechtsOben()) || punktInReckteck(r.getEckeLinksUnten()) || punktInReckteck(r.getEckeRechtsUnten());
	}
	
	public boolean punktInReckteck(Punkt2D p) {
		boolean xCord = p.getX() > getEckeLinksOben().getX() && p.getX() < getEckeRechtsOben().getX();
		boolean yCord = p.getY() > getEckeLinksOben().getY() && p.getY() < getEckeLinksUnten().getY();
		return xCord && yCord;
	}
	
	public boolean gleicherRechteck(Rechteck r) {
		boolean linksOben = getEckeLinksOben().getX() == r.getEckeLinksOben().getX() &&  getEckeLinksOben().getY() == r.getEckeLinksOben().getY();
		boolean rechtsUnten = getEckeRechtsUnten().getX() == r.getEckeRechtsUnten().getX() && getEckeRechtsUnten().getY() == r.getEckeRechtsUnten().getY();
		return linksOben && rechtsUnten;
	}
}
