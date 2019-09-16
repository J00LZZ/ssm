/**
 * Simple Stack Machine
 * <p>
 * Written by Atze Dijkstra, atze@cs.uu.nl,
 * Copyright Utrecht University.
 */

package nl.uu.cs.ssm;

public interface Messenger {
    void print(String s);

    void println(String s);

    /**
     * Asks the user for an integer value (i.e. via a dialog)
     * @return Returns the integer value as provided by the user
     */
    int promptInt();

    /**
     * Asks the user for a character (i.e. via a dialog)
     * @return Returns the unicode integer code point of the provided character
     */
    int promptChar();

    /**
     * Asks the user for a string (i.e. via a dialog)
     * @return Returns an array of unicode integer code points
     */
    int[] promptCharArray();

}