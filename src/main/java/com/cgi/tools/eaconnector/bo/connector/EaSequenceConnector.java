/**
 * 
 */
package com.cgi.tools.eaconnector.bo.connector;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import com.cgi.tools.eaconnector.bo.EaConnector;


/**
 * The Class EaSequenceConnector.
 */
@Entity
@DiscriminatorValue(value = "Sequence")
public class EaSequenceConnector extends EaConnector {

    /**
     * Instantiates a new ea control flow connector.
     */
    public EaSequenceConnector() {
        super();
    }
}
