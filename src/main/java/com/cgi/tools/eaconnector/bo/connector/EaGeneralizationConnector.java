/**
 * 
 */
package com.cgi.tools.eaconnector.bo.connector;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import com.cgi.tools.eaconnector.bo.EaConnector;


/**
 * The Class EaGeneralizationConnector.
 */
@Entity
@DiscriminatorValue(value = "Generalization")
public class EaGeneralizationConnector extends EaConnector {

    /**
     * Instantiates a new ea control flow connector.
     */
    public EaGeneralizationConnector() {
        // TODO Auto-generated constructor stub
    }
}
