/**
 * Simple Stack Machine
 * <p>
 * Written by Atze Dijkstra, atze@cs.uu.nl,
 * Copyright Utrecht University.
 */

package nl.uu.cs.ssm;

import java.awt.*;

public class ColoredText {
    public static final ColoredText blankDefault = new ColoredText("", Color.gray);

    private String text;
    private Color color;

    public ColoredText(String t, Color c) {
        text = t;
        color = c;
    }

    public String getText() {
        return text;
    }

    public Color getColor() {
        return color;
    }

    public String toString() {
        return "ColoredText " + text;
    }

}