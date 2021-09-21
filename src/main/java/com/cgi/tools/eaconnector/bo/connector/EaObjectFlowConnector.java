/**
 * 
 */
package com.cgi.tools.eaconnector.bo.connector;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import com.cgi.tools.eaconnector.bo.EaConnector;

// TODO: Auto-generated Javadoc
/**
 * The Class EaObjectFlowConnector.
 */
@Entity
@DiscriminatorValue(value = "ObjectFlow")
public class EaObjectFlowConnector extends EaConnector {

    /**
     * Instantiates a new ea object flow connector.
     */
    public EaObjectFlowConnector() {
        // TODO Auto-generated constructor stub
    }
}
