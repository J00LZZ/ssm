/**
 * Simple Stack Machine
 * <p>
 * Written by Atze Dijkstra, atze@cs.uu.nl,
 * Copyright Utrecht University.
 */

package nl.uu.cs.ssm;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.Enumeration;

public class HelpLaTeXAccumulator extends HelpAccumulator {
    private final static int MATH_NORMAL = 0;
    private final static int MATH_SUBSCRIPT = 1;

    public HelpLaTeXAccumulator(String fileName) {
        super(fileName);
    }

    private void beginEnv(String t, String param) {
        macro("begin", t);
        if (param != null)
            bracket(param);
    }

    private void beginEnv(String t) {
        beginEnv(t, null);
    }

    private void endEnv(String t) {
        macro("end", t);
    }

    private void beginMath() {
        macro("(");
    }

    private void endMath() {
        macro(")");
    }

    private void beginParen() {
        append('(');
    }

    private void endParen() {
        append(')');
    }

    private void beginBracket() {
        append('{');
    }

    private void endBracket() {
        append('}');
    }

    private void bracket(String t) {
        beginBracket();
        append(t);
        endBracket();
    }

    private void beginMacro(String t) {
        append('\\');
        append(t);
        beginBracket();
    }

    private void endMacro() {
        endBracket();
    }

    private void macro(String t, String a1) {
        append('\\');
        append(t);
        if (a1 != null)
            bracket(a1);
        else
            append(" ");
    }

    private void macro(String t) {
        macro(t, null);
    }

    public void beginHeadTitleBody(String t) {
    }

    public void endHeadTitleBody() {
    }

    public void anchor(String a) {
        macro("label", "ssmanchor:" + a);
        macro("Ix", a);
    }

    public void a(String href, String title) {
        append(title);
        beginParen();
        macro("Ref", href);
        endParen();
    }

    public void anchorA(String href, String title) {
        a("ssmanchor:" + href, title);
    }

    public void beginPara() {
        nl();
        nl();
    }

    public void endPara() {
        nl();
        nl();
    }

    public void beginCentered() {
        beginEnv("center");
    }

    public void endCentered() {
        endEnv("center");
    }

    public void beginSectionTitle() {
        beginMacro("Sec");
    }

    public void endSectionTitle() {
        endMacro();
    }

    public void beginSubsectionTitle() {
        beginMacro("Par");
    }

    public void endSubsectionTitle() {
        endMacro();
    }

    public void beginTable(int nCols, int widthPerc, int[] colWidthWeight) {
        int perc = Math.min(99, widthPerc);
        StringBuffer colFmt = new StringBuffer();
        colFmt.append("l");
        beginEnv("tabular*", "0." + perc + "\\textwidth");
        if (colWidthWeight == null) {
            colFmt.append("l" + Utils.repeat("p{0." + (perc / nCols) + "\\textwidth}", nCols));
        } else {
            int sum = 0;
            for (int i = 0; i < colWidthWeight.length; i++)
                sum += colWidthWeight[i];
            for (int i = 0; i < colWidthWeight.length; i++)
                colFmt.append("p{0." + (perc * colWidthWeight[i] / sum) + "\\textwidth}");
        }
        bracket(colFmt.toString());
    }

    public void endTable() {
        endEnv("tabular*");
    }

    public void beginTableRow() {
    }

    public void endTableRow() {
        linebreak();
    }

    public void beginTableData() {
        append("& ");
        macro("begingroup");
        macro("raggedright");
    }

    public void endTableData() {
        macro("endgroup");
    }

    public void beginBlockQuote() {
    }

    public void endBlockQuote() {
    }

    public void linebreak() {
        append("\\\\");
        nl();
    }

    public void bold(String s) {
        beginBracket();
        macro("bf");
        append(s);
        endBracket();
    }

    private void mathMangle(String s, char subscript) {
        StreamTokenizer t = new StreamTokenizer(new StringReader(s));
        t.resetSyntax();
        t.wordChars('a', 'z');
        t.wordChars('A', 'Z');
        int tok;
        int state = MATH_NORMAL;
        beginMath();
        try {
            while ((tok = t.nextToken()) != StreamTokenizer.TT_EOF) {
                if (tok == StreamTokenizer.TT_WORD) {
                    if (state == MATH_SUBSCRIPT) {
                        bracket(t.sval);
                        state = MATH_NORMAL;
                    } else
                        append(t.sval);
                } else {
                    if (tok == subscript)
                        state = MATH_SUBSCRIPT;
                    if (tok == '&' || tok == '%')
                        append('\\');
                    append((char) tok);
                }
            }
        } catch (IOException ex) {
            append(ex.toString());
        }
        endMath();
    }

    public void mathEquationList(Enumeration<String> e, char subscript) {
        for (; e.hasMoreElements(); ) {
            mathMangle(e.nextElement(), subscript);
            if (e.hasMoreElements())
                linebreak();
        }
    }

    public void beginAttributeList() {
        beginBracket();
        macro("renewcommand", "\\arraystretch");
        bracket("1.7");
        beginTable(2, 90, new int[]{1, 2});
    }

    public void endAttributeList() {
        endTable();
        endBracket();
    }

    public void attributeName(String s) {
        beginTableRow();
        beginTableData();
        bold(s);
        endTableData();
    }

    public void beginAttributeValue() {
        beginTableData();
        beginEnv("minipage");
        append("[t]");
        bracket("0.6\\textwidth");
    }

    public void endAttributeValue() {
        endEnv("minipage");
        endTableData();
        endTableRow();
    }

    public void beginVerbatimList() {
        beginEnv("Verbatim");
        nl();
    }

    public void endVerbatimList() {
        endEnv("Verbatim");
        nl();
    }

    public void verbatimLine(String s) {
        append(s);
        nl();
    }


}