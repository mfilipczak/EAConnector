/**
 * 
 */
package com.cgi.tools.eaconnector.bo.connector;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import com.cgi.tools.eaconnector.bo.EaConnector;


/**
 * The Class EaAssociationConnector.
 */
@Entity
@DiscriminatorValue(value = "Association")
public class EaAssociationConnector extends EaConnector {

    /**
     * Instantiates a new ea control flow connector.
     */
    public EaAssociationConnector() {
        // TODO Auto-generated constructor stub
    }
}
