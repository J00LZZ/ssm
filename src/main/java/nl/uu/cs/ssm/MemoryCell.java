/**
 * Simple Stack Machine
 * <p>
 * Written by Atze Dijkstra, atze@cs.uu.nl,
 * Copyright Utrecht University.
 */

package nl.uu.cs.ssm;


class MemoryCell {
    private int value = 0;
    private String label = null;

    protected MemoryCell(int v) {
        setValue(v);
    }

    protected MemoryCell() {
    }

    public int getValue() {
        return value;
    }

    public int setValue(int v) {
        return value = v;
    }

    public int swapValue(int v) {
        int oldv = value;
        value = v;
        return oldv;
    }

    public String getLabel() {
        return label;
    }

    public String setLabel(String v) {
        return label = v;
    }

}