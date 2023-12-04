package ÜbungenNoah.Übung09.LampenRaetsel;

import java.util.Scanner;

public class RaetselMain {

	private static Lampe lampe = new Lampe();

	private static Wanderer WandererA = new Wanderer(5, "WandererA");
	private static Wanderer WandererB = new Wanderer(10, "WandererB");
	private static Wanderer WandererC = new Wanderer(20, "WandererC");
	private static Wanderer WandererD = new Wanderer(25, "WandererD");

	private static Wanderer[] wandererListe = new Wanderer[] { WandererA, WandererB, WandererC, WandererD };

	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Game starting");
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

	public static void waitForMove() {
		System.out.println("\rWait for Move...");

		String input = scanner.nextLine();

		if (input.length() == 1 && isValidChar(input.charAt(0))) {
			if (getWandererByChar(input.charAt(0)).getPosition().equals(lampe.getPosition())) {
				getWandererByChar(input.charAt(0)).changePos();
				lampe.setTimeRemaining(lampe.getTimeRemaining() - getWandererByChar(input.charAt(0)).getTimeNeeded());
				lampe.changePos();
				System.out.println("\rZug gemacht und " + getWandererByChar(input.charAt(0)).getTimeNeeded()
						+ " Minuten verbraucht");
			} else {
				System.out.println("Wanderer ist nicht auf der gleichen Seite wie die Lampe!");
			}
		} else if (input.length() == 3 && input.charAt(1) == ' ' && isValidChar(input.charAt(0))
				&& isValidChar(input.charAt(2))) {
			if (makeMove(getWandererByChar(input.charAt(0)), getWandererByChar(input.charAt(2)))) {
				System.out.println("Zug gemacht und " + Math.max(getWandererByChar(input.charAt(0)).getTimeNeeded(),
						getWandererByChar(input.charAt(2)).getTimeNeeded()) + " Minuten verbraucht");
			} else {
				System.out.println("Wanderer sind nicht auf der gleichen Seite wie die Lampe!");
			}

		} else {
			System.out.println(
					"Ungültige Eingabe! Bitte gib einen String mit einem oder zwei Buchstaben mit einem Leerzeichen ein.");
			waitForMove();
			return;
		}

		statusMessage();

	}

	public static void statusMessage() {
		String left = "";
		String right = "";
		for (Wanderer wanderer : wandererListe) {
			if (wanderer.getPosition().equals("left")) {
				left += wanderer.getName() + " ";
			} else {
				right += wanderer.getName() + " ";
			}
		}
		if (lampe.getPosition().equals("left")) {
			left += "Lampe";
		} else {
			right += "Lampe";
		}
		String ausgabe = "|  " + left + "  __.-'|'-.__.-'|'-.__  " + right + "  |";
		System.out.println("Time remaining: " + lampe.getTimeRemaining() + " Minuten");
		
		String ObenUnten = "";
		for (int i = 0; ausgabe.length() > i; i++) {
			ObenUnten += "-";
		}
		
		String mitteOben = fillLine("       ,        ,       ", ausgabe);
		String mitteUnten = fillLine("='=====|========|====='=", ausgabe);
		
		System.out.println(ObenUnten + "\r" + mitteOben + "\r" + ausgabe + "\r" + mitteUnten + "\r" + ObenUnten);
	}

	public static boolean checkWin() {
		return WandererA.getPosition().equals("right") && WandererB.getPosition().equals("right")
				&& WandererC.getPosition().equals("right") && WandererD.getPosition().equals("right");
	}

	public static boolean isValidChar(char input) {
		if ((input == 'a' || input == 'b' || input == 'c' || input == 'd')) {
			return true;
		}
		return false;
	}

	public static String fillLine(String replacement, String ausgabe) {
		String ans = "";
		while (ans.length() < ausgabe.length()) {
			if (ans.length() == 0 || ans.length() == ausgabe.length()-1) {
				ans += "|";
			} else {
				if (ans.length() == ausgabe.indexOf("  __.-'|'-.__.-'|'-.__  ")) {
					ans+= replacement;
				} else {
				ans += " ";
			}}
		}
		return ans;
	}
	
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
		}
		return WandererA; // will never reached
	}

	public static boolean makeMove(Wanderer a, Wanderer b) {
		if (a.getPosition() == b.getPosition() && a.getPosition() == lampe.getPosition()) {
			a.changePos();
			b.changePos();
			lampe.changePos();
			lampe.setTimeRemaining(lampe.getTimeRemaining() - Math.max(a.getTimeNeeded(), b.getTimeNeeded()));
			return true;
		}
		return false;
	}

}
