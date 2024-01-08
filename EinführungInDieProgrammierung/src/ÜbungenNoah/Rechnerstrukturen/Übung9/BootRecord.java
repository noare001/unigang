/**
 * Fachhochschule Dortmund
 * Rechnerstrukturen und Betriebssysteme 1
 * Copyright (c) 2013 Claus Fühner <claus.fuehner@fh-dortmund.de>
 * http://www.fh-dortmund.de/fuehner/
 */

package ÜbungenNoah.Rechnerstrukturen.Übung9;

/**
 * This class is provided with Block class (basically an array of bytes)
 * comprising the binary data of a boot sector. 
 * It interprets this data as a FAT boot sector
 * and makes the data fields available to the user.
 * FAT12 or FAT16 boot sectors only!!!
 * Concentrate mainly on BIOS parameter block.
 */
public class BootRecord extends Block {

	// **********************************************************************

    public BootRecord(int sectorSize) {
    	super(sectorSize);
    }

	// **********************************************************************

    public String getOemName()        { return getChars(0x03, 8);  }
    public int getBytesPerSector()    { return getUInt16(0x0b); }
    public int getSectorsPerCluster() { return getUInt8(0x0d); }
    public int getReservedSectors()   { return getUInt16(0x0e); }
    public int getNumberOfFats()      { return getUInt8  (0x10); }
    public int getMaxRootDirEntries() { return getUInt16(0x11); }
    public int getTotalSectors()      { return getUInt16(0x13); }
    public int getMedia()             { return getUInt8(0x15); }
    public int getSectorsPerFat()     { return getUInt16(0x16); }
    public int getSectorsPerTrack()   { return getUInt16(0x18); }
    public int getHeadsPerCylinder()  { return getUInt16(0x1a); }
    public long getHiddenSectors()    { return getUInt32(0x1c); }
    public long getTotalSectorsBig()  { return getUInt32(0x20); }
    public long getSerialNumber()     { return getUInt32(0x27); }
    public String getVolumeLabel()    { return getChars(0x2b, 11); }
    public String getFileSystem()     { return getChars(0x36, 8); }

	// **********************************************************************

    public String toString() {
    	String s = BootRecord.class.getName();
    	s += "\nOem Name:            " + getOemName();
        s += "\nBytes per sector:    " + getBytesPerSector();
        s += "\nSectors per cluster: " + getSectorsPerCluster();
        s += "\nReserved sectors:    " + getReservedSectors();
        s += "\nNumber of FATs:      " + getNumberOfFats();
        s += "\nRoot dir entries:    " + getMaxRootDirEntries();
        s += "\nTotal sectors:       " + getTotalSectors();
        s += "\nMedia:               " + getMedia();
        s += "\nSectors per FAT:     " + getSectorsPerFat();
        s += "\nSectors per track:   " + getSectorsPerTrack();
        s += "\nHeads per cylinder:  " + getHeadsPerCylinder();
        s += "\nHidden sectors:      " + getHiddenSectors();
        s += "\nTotal sectors (big): " + getTotalSectorsBig();
        s += "\nSerial number:       " + getSerialNumber();
        s += "\nVolume label:        " + getVolumeLabel();
        s += "\nFile system:         " + getFileSystem();
        return s;
    }
}
