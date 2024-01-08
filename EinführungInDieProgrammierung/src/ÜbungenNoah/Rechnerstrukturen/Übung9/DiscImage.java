/**
 * Fachhochschule Dortmund
 * Rechnerstrukturen und Betriebssysteme 1
 * Copyright (c) 2013 Claus Fühner <claus.fuehner@fh-dortmund.de>
 * http://www.fh-dortmund.de/fuehner/
 */

package ÜbungenNoah.Rechnerstrukturen.Übung9;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Logger;

/**
 * This class represents a disc image. It uses a file as backing
 * store, i. e. to store the real data. Access to the image is
 * by sector.
 * This class assumes a FAT-16 filesystems without partition table
 * and with 512 Byte sector size. Mounting different filesystem
 * types will fail.
 * @see mount, unmount, readSector
 */
public class DiscImage {

	// **********************************************************************

    private String imageFilename;
    private RandomAccessFile f;
    private BootRecord bootRecord;

    private final int sectorSize = 512;

    private static final Logger log = Logger.getLogger(DiscImage.class.getName());

	// **********************************************************************

    public DiscImage() throws IOException {
    	imageFilename = null;
    	f = null;
    	bootRecord = null;
    }

	// **********************************************************************

    /**
     * The mount method mounts an image file 
     * similar to the respective UNIX command.
     * Use this method to create and initialize the 
     * DiscImage class.
     */
    public void mount(String imageFilename) throws IOException {
        this.imageFilename = imageFilename;
        f = new RandomAccessFile(this.imageFilename, "r");

        // read the boot sector
        bootRecord = new BootRecord(sectorSize);
        readSector(0, bootRecord);

        // perform some sanity checks
        if (bootRecord.getUInt16(0x0b)!=512)
            throw new IOException("Illegal Block Size (!=512)");
        if (bootRecord.getUInt16(0x1fe)!=0xaa55)
            throw new IOException("Illegal Filesystem Signature (!=0xaa55)");

        // logging
        log.info("mounted "+imageFilename+
        		", volume label "+bootRecord.getVolumeLabel()+
        		", filesystem type (@0x36) "+bootRecord.getFileSystem());
    }

    /**
     * Unmounts a disc image file and frees all associated resources.
     * This method renders this class instance unusable.
     */
    public void unmount() throws IOException {
    	if (f!=null)
    		f.close();
    	imageFilename = null;
    	f = null;
    	bootRecord = null;
    }

	// **********************************************************************

    /**
     * Reads the given sector from the mounted filesystem into the buffer.
     * @param sectorNo number of the 512 byte sector to read
     * @param sectorBuf buffer which will hold the sector's data after read
     * @throws IOException
     */
    public void readSector(long sectorNo, Block sectorBuf) throws IOException {
        f.seek(sectorNo * sectorSize);
        f.read(sectorBuf.getData());

        log.info("readSector(" + sectorNo + ")");
        log.fine(sectorBuf.toString());
    }
    
    /**
     * Reads the given cluster from the data area of the mounted 
     * filesystem into the buffer.
     * @param clusterNo number of the cluster to read
     * @param clusterBuf buffer which will hold the cluster's data after read
     * @throws IOException
     */
    public void readCluster(int clusterNo, Block clusterBuf) throws IOException {
    	long sectorNo = getFirstSectorNoOfDataArea() + (clusterNo-2) * getSectorsPerCluster();
    	f.seek(sectorNo * sectorSize);
        f.read(clusterBuf.getData());

        log.info("readCluster(" + clusterNo + ")");
        log.fine(clusterBuf.toString());
    }

	// **********************************************************************

    /**
     * The boot record (sector 0 of a disc image) contains - among others - 
     * important bookkeeping information. This class keeps
     * the boot record of any mounted filesystem in memory. The BootRecord
     * class provides access routines to the boot record.
     */
    BootRecord getBootRecord() {
        return bootRecord;
    }

	// **********************************************************************

    /**
     * This method returns the number of sectors per cluster in the
     * mounted FAT filesystem. This figure is needed for computing
     * sector numbers from cluster numbers.
     * @return Number of sectors per cluster
     */
    public int getSectorsPerCluster() {
        return bootRecord.getSectorsPerCluster();
    }

    /**
     * This method return the sector number of the first sector of the first
     * FAT of the mounted FAT filesystem.
     * @return Number of the first sector of FAT #1
     */
    public int getFirstSectorNoOfFat()  {
        return bootRecord.getReservedSectors();
    }

    /**
     * This method returns the sector number of the first sector of the
     * root directory of the mounted FAT filesystem.
     * @return Number of the first sector of the root directory
     */
    public int getFirstSectorNoOfRootDir() {
        return getFirstSectorNoOfFat()
                + bootRecord.getNumberOfFats() * bootRecord.getSectorsPerFat();
    }

    /**
     * This method returns the number of root directory entries of the 
     * mounted FAT filesystem.
     * @return Maximum number of root directory entries
     */
    public int getMaxRootDirEntries() {
    	return bootRecord.getMaxRootDirEntries();
    }

    /**
     * This method returns the sector number of the first sector of the
     * data area of the mounted FAT filesystem.
     * @return Number of the first sector of the data area
     */
    public int getFirstSectorNoOfDataArea() {
        return getFirstSectorNoOfRootDir()
                + 0x20 * getMaxRootDirEntries() / sectorSize;
    }

}
