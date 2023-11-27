package Uebung07;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Uebung07 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("--------------------------------------------------------------------\r\n"
					+ "1 Geometrische Summe\r\n" 
					+ "2 Zeichne Weihnachtsbaum\r\n" 
					+ "3 Sortiere Listen\r\n"
					+ "4 Summe Quadrat\r\n" 
					+ "5 Summe Groesstes Quadrat\r\n" 
					+ "6 Fertig\r\n"
					+ "-------------------------------------------------------------------- \r\n"
					+ "\r\nBitte wählen Sie eine der Möglichkeiten 1-6 aus");
			switch (scanner.nextInt()) {
				case 1:
					System.out.println("Geben sie Integer n und Double q an");
					System.out.println("Das Ergebnis ist: " + geometrischeSumme(scanner.nextInt(), scanner.nextDouble()));
					break;
				case 2:
					System.out.println("Bitte geben Sie eine natürliche Zahl für die Höhe an: ");
					drawChristmasTree(scanner.nextInt());
					break;
				case 3:
					System.out.println("Geben sie die Werte für das erste 5 stellige Array an:");
					int[] a = { scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt(),
							scanner.nextInt() };
					System.out.println("Geben sie die Werte für das zweite 5 stellige Array an:");
					int[] b = { scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt(),
							scanner.nextInt() };
					System.out.print("Ergebnis: ");
					for (int num : merge(a, b)) {
						System.out.print(num + " ");
					}
					break;
				case 4:
					System.out.println("Gebe Die Koordinate i und j an: ");
					int[][] feld = new int[scanner.nextInt() + 3][scanner.nextInt() + 3];
					for (int x = 0; x < feld.length; x++) {
						for (int y = 0; y < feld[x].length; y++) {
							feld[x][y] = ThreadLocalRandom.current().nextInt(1, 10) + 1;
						}
					}
					displayArray(feld);
					System.out.println("Die Summe ist: " + summeQuadrat(feld, feld.length - 3, feld[0].length - 3));
					break;
				case 5:
					System.out.println("Gebe Die Größe Der Reihen i und der Spalten j an: ");
					int[][] feld1 = new int[scanner.nextInt() + 2][scanner.nextInt() + 2];
					for (int x = 0; x < feld1.length; x++) {
						for (int y = 0; y < feld1[x].length; y++) {
							feld1[x][y] = ThreadLocalRandom.current().nextInt(1, 10) + 1;
						}
					}
					displayArray(feld1);
					SummeGroesstesQuadrat(feld1);
					break;
				default:
					scanner.close();
					return;
			}
			scanner.nextLine();
			System.out.println("\r\nDrücke Enter zum fortfahren...");
			scanner.nextLine();
		}
	}

	public static void displayArray(int[][] stern) {
		for (int j = 0; j < stern.length; j++) System.out.println(Arrays.toString(stern[j]));
	}

	// Aufgabe 1
	public static double geometrischeSumme(int n, double q) {
		double ergebnis = 1.0;
		for (int i = 0; i < n; i++) {
			double zwischenErgebnis = q;
			for (int j = 0; j < i; j++)
				zwischenErgebnis *= q;
			ergebnis += zwischenErgebnis;
		}
		return ergebnis;
	}

	// Aufgabe 2
	public static void drawChristmasTree(int n) {
		for (int i = n; i >= 0; i--) {
			String row = ""; 
			for (int j = n; j > -n; j--) {
				if (j < n - i && j > -n + i) {
					row += "*";
				} else {
					row += " ";
				}
			}
			System.out.println(row);
		}
	}

	// Aufgabe 3
	public static int[] merge(int[] a, int[] b) {
		// Merged erstellen mit länge von der Länge von a und b zusammen
		int[] merged = new int[a.length + b.length];

		// Arrays zusammenfügen
		int index = 0;
		for (int i : a)
			merged[index++] = i;
		for (int i : b)
			merged[index++] = i;

		// Merged Array Sortieren
		for (int i = 0; i < merged.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < merged.length; j++) {
				if (merged[j] < merged[minIndex]) {
					minIndex = j;
				}
			}
			int zw = merged[i];
			merged[i] = merged[minIndex];
			merged[minIndex] = zw;
		}
		return merged;
	}

	// Aufgabe 5 a
	public static int summeQuadrat(int[][] feld, int i, int j) {
		return feld[i][j] + feld[i + 1][j] + feld[i][j + 1] + feld[i + 1][j + 1];
	}

	// Aufgabe 5 b
	public static void SummeGroesstesQuadrat(int[][] feld) {
		// groessteSumme[0] ist x, groessteSumme[1] ist y und groessteSumme[2] ist die
		// summe
		int groessteSumme[] = new int[3];
		for (int i = 0; i < feld.length - 1; i++) {
			for (int j = 0; j < feld[i].length - 1; j++) {
				if (summeQuadrat(feld, i, j) > groessteSumme[2]) {
					groessteSumme[0] = i;
					groessteSumme[1] = j;
					groessteSumme[2] = summeQuadrat(feld, i, j);
				}
			}
		}
		System.out.println("\r\nIm Teilfeld mit der größten 2x2-Summe hat die linke obere\r\n" + "Ecke die Indexzeile "
				+ groessteSumme[0] + " und die Indexspalte " + groessteSumme[1] + "\r\nund die Summe: " + groessteSumme[2]);
	}
}
