/**
 * 
 */
package com.cgi.tools.eaconnector.bo.connector;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import com.cgi.tools.eaconnector.bo.EaConnector;


/**
 * The Class EaDependencyConnector.
 */
@Entity
@DiscriminatorValue(value = "Dependency")
public class EaDependencyConnector extends EaConnector {

    /**
     * Instantiates a new ea control flow connector.
     */
    public EaDependencyConnector() {
        // TODO Auto-generated constructor stub
    }
}
