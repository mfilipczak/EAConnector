/**
 * 
 */
package com.cgi.tools.eaconnector.bo.connector;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import com.cgi.tools.eaconnector.bo.EaConnector;


/**
 * The Class EaNestingConnector.
 */
@Entity
@DiscriminatorValue(value = "Nesting")
public class EaNestingConnector extends EaConnector {

    /**
     * Instantiates a new ea control flow connector.
     */
    public EaNestingConnector() {
        // TODO Auto-generated constructor stub
    }
}
