/**
 * Fachhochschule Dortmund
 * Rechnerstrukturen und Betriebssysteme 1
 * Copyright (c) 2013 Claus Fühner <claus.fuehner@fh-dortmund.de>
 * http://www.fh-dortmund.de/fuehner/
 */

package ÜbungenNoah.Rechnerstrukturen.Übung9;
import java.io.UnsupportedEncodingException;

/**
 * Container for a disc block (sector or cluster) providing 
 * some access methods for the underlying byte array. 
 */
public class Block {

	// **********************************************************************

    private byte[] buf;

	// **********************************************************************

    /**
     * This class represents a disc block, i. e. a sector or a cluster.
     * The block size cannot be changed after class construction.
     * @param size block size in bytes
     */
    public Block(int size) {
    	buf = new byte[size];
    }

	// **********************************************************************

    /**
     * Return the underlying byte array for reading/writing the
     * sector data.
     * @return The byte array representing the sector
     */
    public byte[] getData() { return buf; }

    /**
     * Read one byte from the block at the given offset and interpret it 
     * as an 8 bit unsigned integer.
     * @param offset Offset (in bytes) of the byte to read
     * @return The byte interpreted as UInt8
     */
    public int getUInt8(int offset) { return buf[offset] & 0x0ff; }

    /**
     * Read two bytes from the block starting at the given offset and 
     * interpret them as an 16 bit unsigned integer in little endian format.
     * @param offset Offset (in bytes) of the first byte to read
     * @return The bytes interpreted as UInt16
     */
    public int getUInt16(int offset) { return getUInt8(offset) + 256 * getUInt8(offset+1); }

    /**
     * Read four bytes from the block starting at the given offset and 
     * interpret them as an 32 bit unsigned integer in little endian format.
     * @param offset Offset (in bytes) of the first byte to read
     * @return The bytes interpreted as UInt32
     */
    public long getUInt32(int offset) { return getUInt16(offset) + 65536L * getUInt16(offset+2); }

    /**
     * Read len bytes from the block, interprets them as ISO-8859-1
     * encoded characters and convert them to a Java String.
     * @param offset Offset (in bytes) of the first byte to read
     * @return The bytes interpreted as a Java String
     */
    public String getChars(int offset, int len) {
        byte[] bytes = new byte[len];
        for (int i=0; i<len; i++)
            bytes[i] = buf[offset+i];

        String decoded = "";
        try {
            decoded = new String(bytes, "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return decoded;
    }

	// **********************************************************************

    public String toString() {
    	String s = "";
        for (int i=0; i< buf.length; i+=16)
        {
            s += String.format("%04X: ", i);
            for (int j=0; j<16; j++) {
                int b = buf[i+j] & 0x0ff;
                s += String.format("%02X ", b);
            }
            s += " ";
            for (int j=0; j<16; j++) {
                char c = (char)(buf[i+j] & 0x0ff);
                s += String.format("%c", Character.isISOControl(c) ? '.' : c);
            }
            s += "\n";
        }
    	return s;
    }

	// **********************************************************************

}
