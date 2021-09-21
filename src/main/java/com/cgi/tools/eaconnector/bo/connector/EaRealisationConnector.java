/**
 * 
 */
package com.cgi.tools.eaconnector.bo.connector;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import com.cgi.tools.eaconnector.bo.EaConnector;


/**
 * The Class EaRealisationConnector.
 */
@Entity
@DiscriminatorValue(value = "Realisation")
public class EaRealisationConnector extends EaConnector {

    /**
     * Instantiates a new ea control flow connector.
     */
    public EaRealisationConnector() {
        // TODO Auto-generated constructor stub
    }
}
