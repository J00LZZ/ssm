/**
 * Simple Stack Machine
 * <p>
 * Written by Atze Dijkstra, atze@cs.uu.nl,
 * Copyright Utrecht University.
 */

package nl.uu.cs.ssm;


public class MachineStateEvent extends UndoableEvent {
    private static final long serialVersionUID = 1L;

    protected MachineStateEvent(Object src, Modification mdf) {
        super(src, mdf);
    }

}
