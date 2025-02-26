/**
 * Simple Stack Machine
 * <p>
 * Written by Atze Dijkstra, atze@cs.uu.nl,
 * Copyright Utrecht University.
 */

package nl.uu.cs.ssm;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Enumeration;

public abstract class HelpAccumulator {
    //private StringBuffer accumulator ;
    protected Writer accumulator;

    public HelpAccumulator(String fileName) {
        try {
            //System.out.println( "help acc " + fileName ) ;
            if (fileName == null)
                accumulator = new StringWriter();
            else
                accumulator = new FileWriter(fileName);
        } catch (IOException ex) {
            ex.printStackTrace();
            accumulator = null;
        }
    }

    protected boolean canWrite() {
        return accumulator != null;
    }

    public abstract void beginHeadTitleBody(String t);

    public abstract void endHeadTitleBody();

    public abstract void anchor(String a);

    public abstract void a(String href, String title);

    public abstract void anchorA(String href, String title);

    public abstract void beginCentered();

    public abstract void endCentered();

    public abstract void beginPara();

    public abstract void endPara();

    public void para(String text) {
        beginPara();
        append(text);
        endPara();
    }

    public abstract void beginSectionTitle();

    public abstract void endSectionTitle();

    public void sectionTitle(String s) {
        beginSectionTitle();
        append(s);
        endSectionTitle();
    }

    public abstract void beginSubsectionTitle();

    public abstract void endSubsectionTitle();

    public void subsectionTitle(String s) {
        beginSubsectionTitle();
        append(s);
        endSubsectionTitle();
    }

    public abstract void beginTable(int nCols, int widthPerc, int[] colWidthWeight);

    public abstract void endTable();

    public abstract void beginTableRow();

    public abstract void endTableRow();

    public abstract void beginTableData();

    public abstract void endTableData();

    public void tableRow(Object[] data) // not recursive (yet)
    {
        beginTableRow();
        for (int i = 0; i < data.length; i++) {
            beginTableData();
            append(data[i].toString());
            endTableData();
        }
        endTableRow();
    }

    public void tableHeaderRow(Object[] data) // not recursive (yet)
    {
        beginTableRow();
        for (Object datum : data) {
            beginTableData();
            bold(datum.toString());
            endTableData();
        }
        endTableRow();
    }

    public abstract void beginBlockQuote();

    public abstract void endBlockQuote();

    public abstract void linebreak();

    public void append(String o) {
        if (!canWrite())
            return;

        try {
            accumulator.write(o);
        } catch (IOException ex) {
            accumulator = null;
        }
    }

    public void append(char o) {
        append("" + o);
    }

    public void append(int o) {
        append("" + o);
    }

    public void nl() {
        append('\n');
    }

    //public abstract void font( String f, String s ) ;

    public abstract void bold(String s);

    public void string(String s) {
        append("\"");
        append(s);
        append("\"");
    }


    //public abstract void define( String nm, String val ) ;

    public void close() {
        try {
            accumulator.close();
        } catch (IOException ignored) {
        }
    }

    public String toString() {
        close();
        if (accumulator instanceof StringWriter)
            return accumulator.toString();
        else
            return "";
    }

    public abstract void mathEquationList(Enumeration<String> e, char subscript);

    public abstract void beginVerbatimList();

    public abstract void endVerbatimList();

    public abstract void verbatimLine(String s);

    public void verbatimList(Enumeration<String> e) {
        if (!e.hasMoreElements())
            return;

        beginVerbatimList();
        for (; e.hasMoreElements(); ) {
            verbatimLine(e.nextElement());
        }
        endVerbatimList();
    }

    public abstract void beginAttributeList();

    public abstract void endAttributeList();

    public abstract void attributeName(String s);

    public abstract void beginAttributeValue();

    public abstract void endAttributeValue();

    public String reprAsHex(int v) {
        return Utils.asHex(v, false);
    }
}