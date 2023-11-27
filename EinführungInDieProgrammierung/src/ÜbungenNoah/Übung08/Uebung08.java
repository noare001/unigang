package ÜbungenNoah.Übung08;

public class Uebung08 {

	
	
	public static void main(String[] args) {
		Dozent dieDozentin = new Dozent("Angelika", "Mathe", 'w');
		Dozent derDekan = new Dozent("Markus", "Sport", 'm');
		
		derDekan.setDekan(true);
		
		bekommeAttributes(derDekan);
		dieDozentin.setLehrgebiet("Biologie");
		bekommeAttributes(dieDozentin);
		
	}

	private static void bekommeAttributes(Dozent dozent) {
		System.out.println("Name: " + dozent.getName());
		System.out.println("Lehrgebiet: " + dozent.getLehrgebiet());
		System.out.println("Dekan?: " + dozent.isDekan());
		System.out.println("Geschlecht: " + dozent.getGeschlecht() + "\n");
	}
}


// Aufgabe 1
// - Was ist ein Objekt?
// Ein Objekt ist eine konkrete Instanz einer Klasse. Es ist ein Speicherbereich, der Daten und Funktionen enthält. Objekte werden in der objektorientierten Programmierung verwendet, um reale Objekte oder Konzepte darzustellen.
//
// - Was ist eine Klasse?
// Eine Klasse ist eine Beschreibung eines Objekts. Sie definiert, welche Daten und Funktionen ein Objekt enthält. Klassen werden in der objektorientierten Programmierung verwendet, um die gemeinsamen Eigenschaften und Verhaltensweisen von Objekten zu definieren.
//
// - Worin besteht der Unterschied zwischen einer Klasse und einem Objekt?
// Eine Klasse ist eine Beschreibung, ein Objekt ist eine Instanz. Eine Klasse existiert nur als Entwurf, ein Objekt existiert als realer Speicherbereich.
//
// - Wie greift man auf ein Attribut bzw. eine Methode eines Objektes zu?
// Um auf ein Attribut eines Objektes zuzugreifen, verwendet man den Punktoperator (.).
//
// - Was ist die „garbage collection“ und wozu dient diese?
// Die Garbage Collection ist ein Prozess, der von der Laufzeitumgebung durchgeführt wird, um nicht mehr benötigte Objekte automatisch zu löschen.