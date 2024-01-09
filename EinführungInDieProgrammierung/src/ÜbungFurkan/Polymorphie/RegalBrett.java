package ÜbungFurkan.Polymorphie;

public class RegalBrett {

	private int breite;
	private double tragkraft;
	private Medium[] medien;

	public RegalBrett(int breite, double tragkraft) {
		medien = new Medium[100];
		this.breite = breite;
		this.tragkraft = tragkraft;
	}

	public boolean fuegeHinzu(Medium medium) {
		if (medium.getBreite() <= breite && (tragkraft - summeGewicht()) >= medium.getGewicht()) {
			for (int i = 0; i < medien.length; i++) {
				if (medien[i] == null) {
					medien[i] = medium;
					return true;
				}
			}
		}
		return false;

	}

	public double summeGewicht() {
		double summe = 0;
		for (Medium m : medien)
			if (m != null)
				summe += m.getGewicht();
		return summe;

	}
}
