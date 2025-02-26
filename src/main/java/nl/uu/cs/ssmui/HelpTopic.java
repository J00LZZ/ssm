/**
 * Simple Stack Machine
 * <p>
 * Written by Atze Dijkstra, atze@cs.uu.nl,
 * Copyright Utrecht University.
 */

package nl.uu.cs.ssmui;

import nl.uu.cs.ssm.HelpAccumulator;
import nl.uu.cs.ssm.HelpSupplier;

public class HelpTopic {
    private HelpSupplier helpSupplier;
    private String topic;

    protected HelpTopic(HelpSupplier hs, String t) {
        helpSupplier = hs;
        topic = t;
    }

    public void genTitle(HelpAccumulator acc) {
        acc.append(helpSupplier.getHelpSupplierName());
    }

    public String getTopic() {
        return topic;
    }

    public void genTopic(HelpAccumulator acc) {
        acc.append(getTopic());
    }

    public void genHelp(HelpAccumulator acc) {
        helpSupplier.getHelpForTopic(topic, acc);
    }

    public String toString() {
        //return helpSupplier.getShortSummaryForTopic( topic ) ;
        return getTopic() + " (" + helpSupplier.getHelpSupplierName().toLowerCase() + ")";
    }

}

