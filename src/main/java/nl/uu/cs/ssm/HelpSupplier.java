/**
 * Simple Stack Machine
 * <p>
 * Written by Atze Dijkstra, atze@cs.uu.nl,
 * Copyright Utrecht University.
 */

package nl.uu.cs.ssm;

import java.util.Enumeration;

public interface HelpSupplier {
    Enumeration<String> getTopics();

    String getHelpSupplierName();

    String getShortSummaryForTopic(String topic);

    void getHelpForTopic(String topic, HelpAccumulator acc);

}
