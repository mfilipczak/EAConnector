/**
 * 
 */
package com.cgi.tools.eaconnector.bo.connector;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import com.cgi.tools.eaconnector.bo.EaConnector;


/**
 * The Class EaInformationFlowConnector.
 */
@Entity
@DiscriminatorValue(value = "InformationFlow")
public class EaInformationFlowConnector extends EaConnector {

    /**
     * Instantiates a new ea control flow connector.
     */
    public EaInformationFlowConnector() {
        // TODO Auto-generated constructor stub
    }
}
