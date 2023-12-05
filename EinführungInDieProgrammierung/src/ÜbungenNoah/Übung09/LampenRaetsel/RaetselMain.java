package ÜbungenNoah.Übung09.LampenRaetsel;

import java.util.Scanner;

public class RaetselMain {

	// initialisieren der Lampe
	private static Lampe lampe = new Lampe();

	// initialisieren aller Wanderer
	private static Wanderer WandererA = new Wanderer(5, "WandererA");
	private static Wanderer WandererB = new Wanderer(10, "WandererB");
	private static Wanderer WandererC = new Wanderer(20, "WandererC");
	private static Wanderer WandererD = new Wanderer(25, "WandererD");

	// Liste der Wanderer zum iterieren
	private static Wanderer[] wandererListe = new Wanderer[] { WandererA, WandererB, WandererC, WandererD };

	// initialisieren des Scanners für Input
	public static Scanner scanner = new Scanner(System.in);

	/**
	 * Prints out help and statusmessage at start and runs waitForMove() while
	 * timeremaining greater 0 and not won Prints then Falsche Lösung oder Richtige
	 * Lösung wenn Rätsel gelöst oder nicht
	 */
	public static void main(String[] args) {

		help();

		System.out.println("Game starting:");
		statusMessage();

		while (lampe.getTimeRemaining() > 0 && !checkWin()) {
			waitForMove();
		}

		if (lampe.getTimeRemaining() < 0) {
			System.out.println(
					"\rFalsche Loesung. Du hast " + (lampe.getTimeRemaining() * (-1)) + 60 + " Minuten gebraucht");
		} else if (checkWin()) {
			System.out.println("\rDu hast das Rätsel gelöst!");
		} else {
			System.out.println("\rFalsche Lösung. Du hast keine Zeit mehr übrig!");
		}
	}

	/**
	 * Wartet auf user eingabe, prüft ob ein command vorhanden ist und wenn nicht
	 * prüft ob eingabe korrekt ist und führt dementsprechenden Zug aus
	 */
	public static void waitForMove() {
		System.out.println("\rWait for Move...");

		// User Input
		String input = scanner.nextLine();

		// Wenn command found end Method
		if (checkCommands(input))
			return;

		// Wenn nur ein buchstabe und dieser Valid ist
		if (input.length() == 1 && isValidChar(input.charAt(0))) {

			// Wenn move valid is print succes else print fail
			if (makeMove(getWandererByChar(input.charAt(0)))) {
				System.out.println("\rZug gemacht und " + getWandererByChar(input.charAt(0)).getTimeNeeded()
						+ " Minuten verbraucht");
			} else {
				System.out.println("Wanderer ist nicht auf der gleichen Seite wie die Lampe!");
			}

			// Wenn input Länge 3 hat und in der Mitte ein Leerzeichen ist und beide
			// buchstaben valid sind
		} else if (input.length() == 3 && input.charAt(1) == ' ' && isValidChar(input.charAt(0))
				&& isValidChar(input.charAt(2))) {

			// Wenn move valid is print success else print fail
			if (makeMove(getWandererByChar(input.charAt(0)), getWandererByChar(input.charAt(2)))) {
				System.out.println("Zug gemacht und " + Math.max(getWandererByChar(input.charAt(0)).getTimeNeeded(),
						getWandererByChar(input.charAt(2)).getTimeNeeded()) + " Minuten verbraucht");
			} else {
				System.out.println("Wanderer sind nicht auf der gleichen Seite wie die Lampe!");
			}

			// Prints fail and ends method if input not matching format
		} else {
			System.out.println(
					"Ungültige Eingabe! Bitte gib einen String mit einem oder zwei Buchstaben mit einem Leerzeichen ein.");
			waitForMove();
			return;
		}

		statusMessage();

	}

	/**
	 * checks Input for commands
	 * 
	 * @param input
	 * @return true if there is a command
	 */
	private static boolean checkCommands(String input) {
		switch (input.toUpperCase()) {
		case "LOESUNG":
			showLoesung();
			return true;
		case "HELP":
			help();
			return true;
		case "RESET":
			reset();
			return true;
		default:
			return false;
		}
	}

	/**
	 * resets Game and prints statusMessage
	 */
	public static void reset() {
		for (Wanderer wanderer : wandererListe) {
			wanderer.setPosition("left");
		}
		lampe.setPosition("left");
		lampe.setTimeRemaining(60);
		System.out.println("\r\nGame resetted \r\n");
		statusMessage();
	}

	/**
	 * resets game and shows Loesung
	 */
	public static void showLoesung() {

		// resets Game first
		reset();

		// A und B wechseln Seite
		makeMove(WandererA, WandererB);
		statusMessage();

		// A geht zurück
		makeMove(WandererA);
		statusMessage();

		// C und D wechseln Seite
		makeMove(WandererC, WandererD);
		statusMessage();

		// B geht zurück
		makeMove(WandererB);
		statusMessage();

		// A und B wechseln Seite
		makeMove(WandererA, WandererB);
		statusMessage();

		checkWin();
	}

	/**
	 * Prints out tasks of the riddle
	 */
	public static void help() {
		System.out.println("Aufgabe:\r\n"
				+ "Vier Wanderer müssen über eine unbeleuchtete Hängebrücke gehen. Die Brücke\r\n"
				+ "trägt immer nur zwei Personen gleichzeitig. Für jede Überquerung brauchen sie unbedingt eine Taschenlampe,\r\n"
				+ "die insgesamt nur 60 Minuten brennt. Die vier Wanderer\r\n"
				+ "brauchen für den Weg über die Brücke unterschiedlich lange Zeit:\r\n"
				+ "• Wanderer A braucht 5 Minuten.\r\n" + "• Wanderer B braucht 10 Minuten.\r\n"
				+ "• Wanderer C braucht 20 Minuten.\r\n" + "• Wanderer D braucht 25 Minuten.\r\n"
				+ "Achtung: Die Gehzeit zählt für jede Überquerung, egal ob hin oder zurück. Gehen\r\n"
				+ "zwei Wanderer zusammen, zählt immer die Gehzeit des langsamsten.\r\n"
				+ "Wie kommen die Wanderer in 60 Minuten über die Hängebrücke?\r\n"
				+ "\rType \"Loesung\" for getting the Solution, type \"Help\" \r\n"
				+ "for reading this again or type \"Reset\" for reset\r\n");
	}

	/**
	 * Prints out time remaining and visualisation of game status
	 */
	public static void statusMessage() {
		// String for left Side of Bridge
		String left = "";

		// String for right Side of Bridge
		String right = "";

		// iterates through wandererListe and adds wanderer
		// to left or right String because of their position
		for (Wanderer wanderer : wandererListe) {
			if (wanderer.getPosition().equals("left")) {
				left += wanderer.getName() + " ";
			} else {
				right += wanderer.getName() + " ";
			}
		}

		// adds "Lampe " to left or tight String because of position
		if (lampe.getPosition().equals("left")) {
			left += "Lampe ";
		} else {
			right += "Lampe ";
		}

		// initilialisiert ausgabe String mit left und right String
		String ausgabe = "|  " + left + "='=====|========|====='= " + right + "  |";

		// String for Oben und Unten Kasten der Visualisierung
		String ObenUnten = "-----------------------------------------------------------------------------";

		// Prints out Time Remaining
		System.out.println("Time remaining: " + lampe.getTimeRemaining() + " Minuten");

		// Prints out Kasten mit Visualisierung
		System.out.println(ObenUnten + "\r" + fillLine("       ,        ,       ", "='=====|========|====='=", ausgabe) + "\r"
				+ fillLine("  __.-'|'-.__.-'|'-.__  ", "='=====|========|====='=", ausgabe) + "\r" + ausgabe + "\r"
				+ fillLine("                        ", "='=====|========|====='=", ausgabe) + "\r" + ObenUnten);
	}

	/**
	 * finds String pattern in String ausgabe and sets String
	 * replacement on same starting point as pattern
	 * 
	 * @param replacement
	 * @param pattern
	 * @param ausgabe
	 * @return String with replacement on same position as pattern 
	 */
	public static String fillLine(String replacement, String pattern, String ausgabe) {
		String ans = "";
		while (ans.length() < ausgabe.length()) {
			if (ans.length() == 0 || ans.length() == ausgabe.length() - 1) {
				ans += "|";
			} else {
				if (ans.length() == ausgabe.indexOf(pattern)) {
					ans += replacement;
				} else {
					ans += " ";
				}
			}
		}
		return ans;
	}

	/**
	 * 
	 * @return true if win
	 */
	public static boolean checkWin() {
		return WandererA.getPosition().equals("right") && WandererB.getPosition().equals("right")
				&& WandererC.getPosition().equals("right") && WandererD.getPosition().equals("right");
	}

	/**
	 * 
	 * @param input
	 * @return true if char input is a valid char 
	 */
	public static boolean isValidChar(char input) {
		if ((input == 'a' || input == 'b' || input == 'c' || input == 'd')) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param input
	 * @return Wanderer by char
	 */
	public static Wanderer getWandererByChar(char input) {
		switch (input) {
		case 'a':
			return WandererA;
		case 'b':
			return WandererB;
		case 'c':
			return WandererC;
		case 'd':
			return WandererD;
		default: return WandererA; // will never reached
		}
	}

	/**
	 * Make move with two Wanderer
	 * 
	 * @return true if move is valid and moves directly
	 * @Param Wanderer a
	 */
	public static boolean makeMove(Wanderer a, Wanderer b) {
		if (a.getPosition() == b.getPosition() && a.getPosition() == lampe.getPosition()) {
			a.changePos();
			b.changePos();
			lampe.changePos();
			lampe.decreaseTime(Math.max(a.getTimeNeeded(), b.getTimeNeeded()));
			return true;
		}
		return false;
	}

	/**
	 * Make move with one Wanderer
	 * 
	 * @return true if move is valid and moves directly
	 */
	public static boolean makeMove(Wanderer a) {
		if (a.getPosition().equals(lampe.getPosition())) {
			a.changePos();
			lampe.changePos();
			lampe.decreaseTime(a.getTimeNeeded());
			return true;
		}
		return false;
	}

}
