/**
 * 
 */
package com.cgi.tools.eaconnector.bo.connector;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import com.cgi.tools.eaconnector.bo.EaConnector;

// TODO: Auto-generated Javadoc
/**
 * The Class EaControlFlowConnector.
 */
@Entity
@DiscriminatorValue(value = "ControlFlow")
public class EaControlFlowConnector extends EaConnector {

    /**
     * Instantiates a new ea control flow connector.
     */
    public EaControlFlowConnector() {
        setStereotype("SequenceFlow");
    }
}
