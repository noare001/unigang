package ÜbungNils.Übung8;

public class DozentTest {

	public static void main(String[] args) {
		Dozent derDekan = new Dozent("Meier","BWL",'m');
		Dozent dieDekanin = new Dozent("Bauer","Englisch",'w');

		System.out.println("Name:       " + derDekan.getName());
	    System.out.println("Lehrgebiet: " + derDekan.getLehrgebiet());
	    System.out.println("Geschelcht: " + derDekan.getGeschlecht());
	    System.out.println("ist Dekan?: " + derDekan.isdekan());
	    
	    dieDekanin.setLehrgebiet("Biologie");
	}

}
