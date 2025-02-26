/* 
	Runner.java

	Title:			Simple Stack Machine Runner
	Author:			atze
	Description:	
*/

package nl.uu.cs.ssmui;

import nl.uu.cs.ssm.Utils;

import java.util.Vector;

class AssemblyParseResult {
    protected int lineNr;
    protected String message;
    protected Vector<String> definedLabels;
    protected Vector<String> instrNArgs;

    protected AssemblyParseResult(int l, String m, String lb, Vector<String> ia) {
        definedLabels = new Vector<String>();
        addInfo(l, m, lb, ia);
    }

    protected AssemblyParseResult addInfo(int l, String m, String lb, Vector<String> ia) {
        lineNr = l;
        message = m;
        if (lb != null)
            definedLabels.addElement(lb);
        instrNArgs = ia;
        return this;
    }

    public String toString() {
        return "line " + lineNr + "(" + message + "), " + definedLabels + ": " + instrNArgs;
    }

    public void addLabels(Vector<String> ls) {
        Utils.addAllTo(definedLabels, ls.elements());
    }

}
