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
    	FatReader fatReader = new FatReader("rb1-fat.img");
    	//FatReader fatReader = new FatReader("FatNoPartitionTable.dmg");

    	fatReader.printRootDir();
    	fatReader.printFile(7, 19); // test.txt
    	fatReader.printFile(8, 4082); // message.txt
    }
}
