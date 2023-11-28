package ÜbungFurkan.ueb08;

public class DozentTest {

	public static void main(String[] args) {
		Dozent dieDozentin = new Dozent("Lilia", "Deutsch",'w');
		Dozent derDekan = new Dozent("Hanz","Mathe",'m');
		derDekan.setDekan(true);
		System.out.println("Dekan Geschlecht: " + derDekan.getGeschlecht());
		System.out.println("Dekan Lehrebiet: " + derDekan.getLehrgebiet());
		System.out.println("Dekan Dekan: " + derDekan.isDekan());
		System.out.println("Dekan Name: " + derDekan.getName());
		dieDozentin.setLehrgebiet("Geschichte");
		
	}
	
}
