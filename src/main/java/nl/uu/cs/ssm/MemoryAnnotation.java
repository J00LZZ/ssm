/**
 * Simple Stack Machine
 * <p>
 * Written by Atze Dijkstra, atze@cs.uu.nl,
 * Copyright Utrecht University.
 */

package nl.uu.cs.ssm;

import java.awt.*;

public class MemoryAnnotation extends ColoredText {
    public MemoryAnnotation(String ann, Color col) {
        super(ann, col);
    }

    public String getAnnotation() {
        return getText();
    }

}