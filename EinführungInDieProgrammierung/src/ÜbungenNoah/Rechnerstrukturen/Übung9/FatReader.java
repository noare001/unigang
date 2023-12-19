/**
 * Fachhochschule Dortmund
 * Rechnerstrukturen und Betriebssysteme 1
 * Copyright (c) 2013 Claus Fühner <claus.fuehner@fh-dortmund.de>
 * http://www.fh-dortmund.de/fuehner/
 * 
 * Quellen zum Thema FAT-16:
 * https://www.cs.drexel.edu/~jjohnson/2012-13/fall/cs370/resources/File%20Allocation%20Table.pdf
 * http://de.wikipedia.org/wiki/File_Allocation_Table#Stammverzeichnis_und_Unterverzeichnisse
 * 
 * Erzeugen und Nutzen eines passenden Dateisystem-Images unter Linux:
 *   mkdosfs -v -S 512 -s 2 -F 16 -n RB1 -C rb1-fat.img 8192
 *   mkdir dos
 *   mount rb1-fat.img dos
 *   cp test.txt dos
 *   umount dos
 */

package ÜbungenNoah.Rechnerstrukturen.Übung9;

import java.io.IOException;

/**
 * Testklasse zum Lesen einer FAT16-formatierten Dateisystems.
 */
public class FatReader {

    static final int sectorSize = 512;
    
    DiscImage discImage;

	// **********************************************************************

    public FatReader(String imgFn) throws IOException {
        discImage = new DiscImage();

        // Image mounten (wie Mount-Kommando unter UNIX)
        // Wenn das Mounten fehlschlägt, kann die Image-Datei wahrscheinlich
        // nicht gefunden werden.
        discImage.mount(imgFn);
    }
    
	// **********************************************************************

    /**
     * FAT-Dateiattribute in einen String umwandeln.
     * @param attr Attribute als Byte aus dem Dateisystem-Image
     * @return lesbare Darstellung der Attribute als String
     */
    public String attrToString(int attr) {
    	String attrStr = "";
    	attrStr += (attr & 0x20) != 0 ? "a" : "-"; // Archiv
    	attrStr += (attr & 0x10) != 0 ? "d" : "-"; // Directory
    	attrStr += (attr & 0x08) != 0 ? "v" : "-"; // Volume-Label
    	attrStr += (attr & 0x04) != 0 ? "s" : "-"; // System
    	attrStr += (attr & 0x02) != 0 ? "h" : "-"; // Hidden
    	attrStr += (attr & 0x01) != 0 ? "r" : "-"; // Read-Only
    	return attrStr;
    }

	// **********************************************************************

    /**
     * Wurzelverzeichnis ausgeben
     */
    public void printRootDir() throws IOException {
    	// TODO Praktikums zum FAT-Verzeichnisaufbau
    	// Falls die Datei mit dem Dateisystem-Image nicht gefunden
    	// wird, muss wahrscheinlich der Pfad in der main()-Methode	
    	// angepasst werden!
    	
    	Block sector = new Block (512) ; // Speicher reservieren
    	discImage.readSector(0, sector) ; // Sektor in Speicher lesen
  
    	System.out.println(sector);
    	
//    	Der erste Eintrag beginnt bei Offset 0x0020 (32 in Dezimal).
//    	Der zweite Eintrag beginnt bei Offset 0x0020 + 32 = 0x0040 (64 in Dezimal).
//    	Der dritte Eintrag beginnt bei Offset 0x0040 + 32 = 0x0060 (96 in Dezimal).
    	
//    	Hier sind die Bytes für den dritten Eintrag (Offset 0x0060 bis 0x006F):
//
//    		0x0060: 20 (Leerzeichen, Dateiname beginnt)
//    		0x0061: 20 (Leerzeichen, Dateiname fortgesetzt)
//    		...
//    		0x006C: 0E (Attribute)
//    		0x006D: 1F (Weiteres Attribut)
//    		0x006E: BE (Dateigröße Byte 1)
//    		0x006F: 5B (Dateigröße Byte 2)
//
//    	Die Byte-Reihenfolge ist umgekehrt, da es sich um Little Endian handelt. 
//    	Um die Dezimalzahl der Dateigröße zu erhalten, musst du die Bytes in der 
//    	umgekehrten Reihenfolge zusammenführen: 0x5BBE = 23486 in Dezimal.
    	
    	System.out.println(sector.getUInt16(64));
    	
    	System.out.println("\r\nErster sector aus root");
    	
    	discImage.readSector(discImage.getFirstSectorNoOfRootDir(), sector) ; // Sektor in Speicher lesen
    	System.out.println(sector);
    	System.out.println(sector.getUInt16(64));
    	
    	System.out.println("Aufgabe 2: \r\n");
    	aufgabe2();
  }
    
    public void aufgabe2() throws IOException {
    	Block sector = new Block (512) ; // Speicher reservieren
    	
    	for (int i = discImage.getFirstSectorNoOfRootDir(); i <= discImage.getMaxRootDirEntries() && i < (discImage.getFirstSectorNoOfRootDir()+50); i++) {
    		discImage.readSector(i, sector) ; // Sektor in Speicher lesen
    		System.out.println(sector);
    		
    	}
    }

	// **********************************************************************

    /**
     * Inhalt einer Datei nach stdout ausgeben.
     * @param clusterNo Nummber des Start-Clusters der Datei
     * @param size Dateigr§e in Bytes
     * @throws IOException
     */
    public void printFile(int clusterNo, int size) throws IOException {
    	// TODO Praktikums zum Lesen von FAT-Dateien
    	// Falls die Datei mit dem Dateisystem-Image nicht gefunden
    	// wird, muss wahrscheinlich der Pfad in der main()-Methode
    	// angepasst werden!
    }

	// **********************************************************************

    public static void main(String[] argv) throws IOException {
    	// TODO Hier wenn notwendig den Pfad zum Image anpassen!
    	FatReader fatReader = new FatReader("C:\\Users\\conti_mobil\\git\\unigang\\EinführungInDieProgrammierung\\src\\ÜbungenNoah\\Rechnerstrukturen\\Übung9\\rb1-fat.img");
    	//Aufgabe 1: C:\\Users\\conti_mobil\\git\\unigang\\EinführungInDieProgrammierung\\src\\ÜbungenNoah\\Rechnerstrukturen\\Übung9\\rb1-fat.img
    	//FatReader fatReader = new FatReader("FatNoPartitionTable.dmg");

    	fatReader.printRootDir();
    	fatReader.printFile(7, 19); // test.txt
    	fatReader.printFile(8, 4082); // message.txt
    }
}
