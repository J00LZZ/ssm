/**
 * Simple Stack Machine
 * <p>
 * Written by Atze Dijkstra, atze@cs.uu.nl,
 * Copyright Utrecht University.
 */

package nl.uu.cs.ssm;

import java.util.EventObject;

public class UndoableEvent extends EventObject {
    private static final long serialVersionUID = 1L;

    private Modification undoModification;

    protected UndoableEvent(Object src, Modification mdf) {
        super(src);
        undoModification = mdf;
    }

    public Modification undoModification() {
        return undoModification;
    }

}
