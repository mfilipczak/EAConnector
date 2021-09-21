/**
 * 
 */
package com.cgi.tools.eaconnector.bo.connector;

import com.cgi.tools.eaconnector.bo.EaConnector;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


/**
 * The Class EaDependencyConnector.
 */
@Entity
@DiscriminatorValue(value = "Delegate")
public class EaDelegateConnector extends EaConnector {

    /**
     * Instantiates a new ea control flow connector.
     */
    public EaDelegateConnector() {
        // TODO Auto-generated constructor stub
    }
}
