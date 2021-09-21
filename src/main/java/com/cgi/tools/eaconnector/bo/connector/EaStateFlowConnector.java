/**
 * 
 */
package com.cgi.tools.eaconnector.bo.connector;

import com.cgi.tools.eaconnector.bo.EaConnector;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


/**
 * The Class EaAssociationConnector.
 */
@Entity
@DiscriminatorValue(value = "StateFlow")
public class EaStateFlowConnector extends EaConnector {

    /**
     * Instantiates a new ea control flow connector.
     */
    public EaStateFlowConnector() {
        // TODO Auto-generated constructor stub
    }
}
