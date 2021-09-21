/**
 * 
 */
package com.cgi.tools.eaconnector.bo.connector;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import com.cgi.tools.eaconnector.bo.EaConnector;


/**
 * The Class EaCommunicationPathConnector.
 */
@Entity
@DiscriminatorValue(value = "CommunicationPath")
public class EaCommunicationPathConnector extends EaConnector {

    /**
     * Instantiates a new ea control flow connector.
     */
    public EaCommunicationPathConnector() {
        // TODO Auto-generated constructor stub
    }
}
