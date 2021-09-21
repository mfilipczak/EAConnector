/**
 * 
 */
package com.cgi.tools.eaconnector.bo.connector;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import com.cgi.tools.eaconnector.bo.EaConnector;

// TODO: Auto-generated Javadoc
/**
 * The Class EaNoteLinkConnector.
 */
@Entity
@DiscriminatorValue(value = "NoteLink")
public class EaNoteLinkConnector extends EaConnector {

    /**
     * Instantiates a new ea note link connector.
     */
    public EaNoteLinkConnector() {
        // TODO Auto-generated constructor stub
    }
}
