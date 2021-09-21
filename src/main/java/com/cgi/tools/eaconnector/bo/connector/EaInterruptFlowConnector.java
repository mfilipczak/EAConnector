/**
 * 
 */
package com.cgi.tools.eaconnector.bo.connector;

import com.cgi.tools.eaconnector.bo.EaConnector;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


/**
 * The Class EaInformationFlowConnector.
 */
@Entity
@DiscriminatorValue(value = "InterruptFlow")
public class EaInterruptFlowConnector extends EaConnector {

    /**
     * Instantiates a new ea control flow connector.
     */
    public EaInterruptFlowConnector() {
        // TODO Auto-generated constructor stub
    }
}
