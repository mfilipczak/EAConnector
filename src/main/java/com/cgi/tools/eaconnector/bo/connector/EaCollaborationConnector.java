/**
 * 
 */
package com.cgi.tools.eaconnector.bo.connector;

import com.cgi.tools.eaconnector.bo.EaConnector;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

// TODO: Auto-generated Javadoc

/**
 * The Class EaControlFlowConnector.
 */
@Entity
@DiscriminatorValue(value = "Collaboration")
public class EaCollaborationConnector extends EaConnector {

    /**
     * Instantiates a new ea control flow connector.
     */
    public EaCollaborationConnector() {
        setStereotype("SequenceFlow");
    }
}
