/**
 * Simple Stack Machine
 * <p>
 * Written by Atze Dijkstra, atze@cs.uu.nl,
 * Copyright Utrecht University.
 */

package nl.uu.cs.ssm;

interface MemoryCellModel {
    void addMemoryCellListener(MemoryCellListener l);

    void removeMemoryCellListener(MemoryCellListener l);

}