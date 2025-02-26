/* 
	Runner.java

	Title:			Simple Stack Machine Runner
	Author:			atze
	Description:	
*/

package nl.uu.cs.ssmui;

import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.Vector;

public class AssemblyParser {
    private StreamTokenizer tokens;
    private int tok;

    protected AssemblyParser(Reader input) {
        tokens = new StreamTokenizer(input);
        tokens.resetSyntax();
        tokens.wordChars('0', '9');
        tokens.wordChars('a', 'z');
        tokens.wordChars('A', 'Z');
        tokens.wordChars(0xA0, 0xF0);
        tokens.wordChars('_', '_');
        tokens.wordChars('-', '-');
        tokens.whitespaceChars(0x00, 0x20);
        tokens.commentChar(';');
        tokens.quoteChar('"');
        tokens.eolIsSignificant(true);
        tokens.slashSlashComments(true);
        next();
    }

    private void next() {
        try {
            if (!isAtEOF())
                tok = tokens.nextToken();
        } catch (IOException ex) {
            tok = StreamTokenizer.TT_EOF;
        }
    }

    public boolean isAtEOF() {
        return tok == StreamTokenizer.TT_EOF;
    }

    private boolean isAtEOL() {
        return tok == StreamTokenizer.TT_EOL || isAtEOF();
    }

    protected AssemblyParseResult parse1Line(AssemblyParseResult prevAPR) {
        int lineNr = tokens.lineno();
        String label = null;
        String msg = null;
        Vector<String> instrNArgs = new Vector<String>();

        if (!isAtEOL()) {
            if (tok == StreamTokenizer.TT_WORD) {
                String s = tokens.sval;
                next();
                if (tok == ':') {
                    label = s;
                    next();
                } else {
                    instrNArgs.addElement(s);
                }

                while (!isAtEOL()) {
                    if (tok == StreamTokenizer.TT_WORD || tok == '"') {
                        instrNArgs.addElement(tokens.sval);
                    } else if (tok == StreamTokenizer.TT_NUMBER) {
                        msg = "did not expect number " + tokens.nval;
                    } else {
                        msg = "did not expect `" + (char) tok + "'";
                    }
                    next();
                }
            } else {
                msg = "expected label or instruction";
            }
        }
        next();

        if (prevAPR == null)
            return new AssemblyParseResult(lineNr, msg, label, instrNArgs);
        else
            return prevAPR.addInfo(lineNr, msg, label, instrNArgs);
    }

}
