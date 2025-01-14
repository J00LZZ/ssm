/**
 * Simple Stack Machine
 * <p>
 * Written by Atze Dijkstra, atze@cs.uu.nl,
 * Copyright Utrecht University.
 */

package nl.uu.cs.ssm;

import java.util.Vector;

public abstract class MetaInstrInstantiator {
    protected MetaInstrInstantiator() {
    }

    public static MetaInstrInstantiator newAnnoteInstantiator() {
        return new MetaInstrInstantiator() {
            public MetaInstruction instantiate(Instruction instr, Vector<String> args) {
                return MetaInstruction.newAnnote(instr, args);
            }
        };
    }

    public abstract MetaInstruction instantiate(Instruction instr, Vector<String> args);
}