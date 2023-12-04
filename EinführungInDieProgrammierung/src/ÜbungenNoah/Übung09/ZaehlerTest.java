package ÜbungenNoah.Übung09;

class ZaehlerTest {
	public static void main(String[] args) {
		Zaehler einKmZaehler = new Zaehler(1);
		Zaehler nocheinKmZaehler = new Zaehler(42);

		nocheinKmZaehler.uebertrage(einKmZaehler);
		System.out.println(einKmZaehler == nocheinKmZaehler);
		System.out.println(einKmZaehler.equals(nocheinKmZaehler));
	}
	
//	b)
//	Zeile 9 gibt false aus, da die Objekte nicht dieselben sind. Sie haben nur den gleichen Zaehlerstand.
//	Zeile 10 gibt true zurück, da in equals die Zaehlerstände beider Objekte miteinander verglichen werden.
}
