/**
 * Simple Stack Machine
 * <p>
 * Written by Atze Dijkstra, atze@cs.uu.nl,
 * Copyright Utrecht University.
 */

package nl.uu.cs.ssm;


public class MemoryCellEvent extends UndoableEvent {
    public static final int CELL = 0;
    public static final int ANNOTATION = 1;
    private static final long serialVersionUID = 1L;
    public int cellIndex;
    public Object oldCellValue;
    public int event;

    protected MemoryCellEvent(Object src, int which, int previous, Modification mdf) {
        super(src, mdf);
        event = CELL;
        cellIndex = which;
        oldCellValue = previous;
    }

    protected MemoryCellEvent(Object src, int which, MemoryAnnotation previous, Modification mdf) {
        super(src, mdf);
        event = ANNOTATION;
        cellIndex = which;
        oldCellValue = previous;
    }

    public int getCellIndex() {
        return cellIndex;
    }

    public int getOldCellValue() {
        return (Integer) oldCellValue;
    }

    public MemoryAnnotation getOldAnnotation() {
        return (MemoryAnnotation) oldCellValue;
    }

    public String toString() {
        return "MemCellEvent src=" + getSource() + " inx=" + cellIndex + " prev=" + oldCellValue;
    }
}
