package ÜbungenNoah.GameKonsole;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class KonsolenGame {

	private static String[][] field = new String[20][15];
	public static ArrayList<Player> playerList = new ArrayList<Player>();
	public static Scanner scanner = new Scanner(System.in);
	public static boolean end = false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addPlayer();
		initGame();
		drawStringArray(field);
	}

	public static void gameLoop() {
		while (!end) {
			switch ((char) scanner.nextByte()) {
			case 'w', 'W': {
				if (playerList.get(0).getX() > 1) {
					playerList.get(0).setX(playerList.get(0).getX() + 1);
				}
			}
			case 'D', 'd': {
				if (playerList.get(0).getY() < field[0].length - 1) {
					playerList.get(0).setY(playerList.get(0).getY() + 1);
				}
			}
			case 'A', 'a': {
				if (playerList.get(0).getY() > 1) {
					playerList.get(0).setY(playerList.get(0).getY() - 1);
				}
			}
			case 'S', 's': {
				if (playerList.get(0).getX() < field.length - 1) {
					playerList.get(0).setX(playerList.get(0).getX() - 1);
				}
			}
			}
		}
	}

	public static void addPlayer() {
		playerList.add(new Player(playerList.size() + 1, 1));
	}

	public static void initGame() {
		clearField();
		drawPlayer();
	}

	public static void drawPlayer() {
		for (Player p : playerList) {
			field[p.getX()][p.getY()] = "P ";
		}
	}

	public static void clearField() {
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				if (i == 0 || i == field[i].length - 1 || j == 0 || j == field.length - 1) {
					field[i][j] = "■ ";
				} else {
					field[i][j] = "  ";
				}

			}
		}
	}

	public static void drawStringArray(String a[][]) {
		for (String[] row : a) { // int i = stern.length-1; i >= 0; i-- -> Zentrum von Koordinatensystem oben
									// links
			for (String cell : row) {
				System.out.print(cell);
			}
			System.out.println();
		}
	}
}
