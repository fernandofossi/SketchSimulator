/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufes.nerds.simulator.model;

import java.util.BitSet;

/**
 *
 * @author Fernando Fossi
 */
public class Bitmap {

    private final int bitMapSize;
    private long startEpoch;
    private long endEpoch;
    private int numberOfPackets;
    private int numberOfColisions;

    private final BitSet bitSet;

    public Bitmap(int bitMapSize) {
        this.bitMapSize = bitMapSize;
        bitSet = new BitSet(bitMapSize);
        numberOfPackets = 0;
        bitSet.clear();
    }

    public Bitmap(int bitMapSize, long startEpoch) {
        this.bitMapSize = bitMapSize;
        this.startEpoch = startEpoch;
        bitSet = new BitSet(bitMapSize);
        numberOfPackets = 0;
        numberOfColisions = 0;
        bitSet.clear();
    }

    public void setEndEpoch(long endEpoch) {
        this.endEpoch = endEpoch;
    }

    public long getEndEpoch() {
        return endEpoch;
    }

    public void setStartEpoch(long startEpoch){
        this.startEpoch = startEpoch;
    }
    
    public long getStartEpoch() {
        return startEpoch;
    }

    public int getBitMapSize() {
        return bitMapSize;
    }

    public void setPosition(int pos) {
        if (bitSet.get(pos)) {
            numberOfColisions++;
        }
        numberOfPackets++;
        bitSet.set(pos);
    }

    public boolean getPosition(int pos) {
        return bitSet.get(pos);
    }

    public int occupancy() {
        return bitSet.cardinality();
    }

    public void reset() {
        numberOfColisions = 0;
        numberOfPackets = 0;
        bitSet.clear();
    }

    public int getSize() {
        return bitSet.size();
    }

    public BitSet getBitSet() {
        return bitSet;
    }

    public int getNumberOfColisions() {
        return numberOfColisions;
    }

    public int getNumberOfPackets() {
        return numberOfPackets;
    }
}
