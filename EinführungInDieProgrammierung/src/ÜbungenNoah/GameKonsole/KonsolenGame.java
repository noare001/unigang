package ÜbungenNoah.GameKonsole;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class KonsolenGame {

	private static String[][] field = new String[12][20];
	public static ArrayList<Player> playerList = new ArrayList<Player>();
	public static ArrayList<Apple> appleList = new ArrayList<Apple>();
	public static Scanner scanner = new Scanner(System.in);
	public static boolean end = false;

	public static void main(String[] args) {
		addPlayer();
		initGame();
		drawStringArray(field);
		gameLoop();
	}

	public static void initGame() {
		clearField();
		drawPlayer();
		addApple();
		drawApple();
	}

	public static void gameLoop() {
		while (!end) {
			handleMove();
			appleCollision();
			clearField();
			drawPlayer();
			drawApple();
			if (playerList.get(0).getX() == field.length - 2 && playerList.get(0).getY() == field[0].length - 2) {
				end = true;
			}
			drawStringArray(field);
		}
	}

	private static void handleMove() {
		switch (scanner.nextLine().toUpperCase()) {
		case "W":
			if (playerList.get(0).getX() > 1) {
				playerList.get(0).setX(playerList.get(0).getX() - 1);
			}
			break;
		case "D":
			if (playerList.get(0).getY() < field[0].length - 2) {
				playerList.get(0).setY(playerList.get(0).getY() + 1);
			}
			break;
		case "A":
			if (playerList.get(0).getY() > 1) {
				playerList.get(0).setY(playerList.get(0).getY() - 1);
			}
			break;
		case "S":
			if (playerList.get(0).getX() < field.length - 2) {
				playerList.get(0).setX(playerList.get(0).getX() + 1);
			}
			break;
		}
	}

	public static void appleCollision() {
		for (Apple a : appleList) {
			if (playerList.get(0).getX() == a.getX() && playerList.get(0).getY() == a.getY()) {
				appleList.remove(a);
				playerList.get(0).setPunkte(playerList.get(0).getPunkte() + 1);
				if (playerList.get(0).getPunkte() > 98) {
					end = true;
				}
				addApple();
			}
		}
	}

	public static void addPlayer() {
		playerList.add(new Player(1, 1));
	}

	public static void drawPlayer() {
		for (Player p : playerList) {
			field[p.getX()][p.getY()] = p.getPunkte() + (p.getPunkte() > 9 ? "" : " ");
		}
	}

	private static void addApple() {
		appleList.add(new Apple(ThreadLocalRandom.current().nextInt(1, field.length - 2) + 1,
				ThreadLocalRandom.current().nextInt(1, field[0].length - 2) + 1));
	}

	private static void drawApple() {
		for (Apple a : appleList) {
			field[a.getX()][a.getY()] = "# ";
		}
	}

	public static void clearField() {
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				if (i == 0 || i == field.length - 1 || j == 0 || j == field[i].length - 1) {
					field[i][j] = "■ ";
				} else {
					field[i][j] = "  ";
				}
			}
		}
	}

	public static void drawStringArray(String a[][]) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
	}
}
