/**
 * Simple Stack Machine
 * <p>
 * Written by Atze Dijkstra, atze@cs.uu.nl,
 * Copyright Utrecht University.
 */

package nl.uu.cs.ssm;

import java.util.EventListener;

public interface MemoryCellListener extends EventListener {
    void cellChanged(MemoryCellEvent e);
}