/**
 * 
 */
package com.cgi.tools.eaconnector.bo.connector;

import com.cgi.tools.eaconnector.bo.EaConnector;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


/**
 * The Class EaNestingConnector.
 */
@Entity
@DiscriminatorValue(value = "Manifest")
public class EaManifestConnector extends EaConnector {

    /**
     * Instantiates a new ea control flow connector.
     */
    public EaManifestConnector() {
        // TODO Auto-generated constructor stub
    }
}
