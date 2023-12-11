package ÜbungFurkan.ueb10.Raetsel;
import java.util.Scanner;

public class Controller {

	public static void main(String[] args) {
		new Controller();
	}

	// Setup
	private Wanderer[] wanderer = new Wanderer[4];
	private boolean lampeRechts;
	private int zeit;

	public Controller() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Lass die Spiele beginnen! \n");
		System.out.println("Auswahl wie folgt eingeben:");
		System.out.println("AB (Wenn 2 bewegt werden sollen)\n" + "A (Wenn 1 bewet werden soll)\n");
		boolean goAgain = true;
		// Spiel
		while (goAgain) {
			reset();
			while (!gewonnen() && zeit > 0) {
				System.out.println("Der Stand:");
				zeichneStand();
				System.out.println("Wähle 1 oder 2 Wanderer...");
				String[] input = sc.next().toUpperCase().split("");
				int ersteWahl = -1;
				int zweiteWahl = -1;
				ersteWahl = uebersetze(input[0]);
				if (input.length > 1)
					zweiteWahl = uebersetze(input[1]);
				if (ersteWahl == -1) {
					System.out.println("Invalid input! Versuche nochmal");
				} else if (zweiteWahl == -1) {
					if (!ueberquere(ersteWahl)) {
						System.out.println("Ohne Lampe kann man doch nicht wandern! :O");
					}
				} else {
					if (!ueberquere(ersteWahl, zweiteWahl)) {
						System.out.println("Ohne Lampe kann man doch nicht wandern! :O");
					}
				}
			}
			zeichneStand();
			if (gewonnen()) {
				System.out.println("GG");
			} else {
				System.out.println("Vielleicht das nächste mal....");
			}
			System.out.println("Type 'y' to play again.");
			if(!sc.next().toUpperCase().equals("Y")) goAgain = false;
		}

	}
	
	public void reset() {
		zeit = 60;
		wanderer[0] = new Wanderer("A", 5);
		wanderer[1] = new Wanderer("B", 10);
		wanderer[2] = new Wanderer("C", 20);
		wanderer[3] = new Wanderer("D", 25);
		lampeRechts = false;
	}

	public int uebersetze(String s) {
		switch (s) {
		case "A":
			return 0;
		case "B":
			return 1;
		case "C":
			return 2;
		case "D":
			return 3;
		default:
			return -1;
		}
	}

	public boolean ueberquere(int a, int b) {
		Wanderer w1 = wanderer[a];
		Wanderer w2 = wanderer[b];
		if (w1.hatUeberquert() == w2.hatUeberquert() && w1.hatUeberquert() == lampeRechts) {
			w1.ueberquere();
			w2.ueberquere();
			if (w1.getZeit() > w2.getZeit()) {
				zeit -= w1.getZeit();
			} else {
				zeit -= w2.getZeit();
			}
			lampeRechts = !lampeRechts;
			return true;

		}
		return false;
	}

	public boolean ueberquere(int a) {
		Wanderer w1 = wanderer[a];
		if (w1.hatUeberquert() == lampeRechts) {
			w1.ueberquere();
			zeit -= w1.getZeit();
			lampeRechts = !lampeRechts;
			return true;
		}
		return false;
	}

	public boolean gewonnen() {
		for (Wanderer w : wanderer) {
			if (w.hatUeberquert() == false) {
				return false;
			}
		}
		return true;
	}

	public void zeichneStand() {
		String output = "Zeit übrig: " + zeit + "\n";
		if (!lampeRechts)
			output += "*Lampe* ";
		// Links von der Brücke
		for (Wanderer w : wanderer) {
			if (w.hatUeberquert() == false) {
				output += w.getName() + "(" + w.getZeit() + ") ";
			}
		}
		// Brücke
		output += ";-___________________-; ";
		// Recht von der Brücke
		for (Wanderer w : wanderer) {
			if (w.hatUeberquert() == true) {
				output += w.getName() + "(" + w.getZeit() + ") ";
			}
		}
		// Lampe
		if (lampeRechts)
			output += " *Lampe*";
		System.out.println(output);
	}
}
