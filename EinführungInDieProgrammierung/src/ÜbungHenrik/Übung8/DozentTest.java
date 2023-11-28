package ÜbungHenrik.Übung8;

public class DozentTest {

	public static void main(String[] args) {
    Dozent dieDozentin = new Dozent("Beate", "Biologie", 'w');
	
	Dozent derDekan = new Dozent("Klaus", "Physik",'m');
	derDekan.setDekan(true);
	System.out.println(derDekan.getName() +" " +derDekan.getLehrgebiet() + " "+ derDekan.getGeschlecht() + " " + derDekan.isDekan());
	System.out.println("Das Lehrgebiet der Dozentin ist: " +dieDozentin.getLehrgebiet());
	}
}
