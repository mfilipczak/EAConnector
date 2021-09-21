/**
 * 
 */
package com.cgi.tools.eaconnector.bo.diagram;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import com.cgi.tools.eaconnector.bo.EaDiagram;

// TODO: Auto-generated Javadoc
/**
 * The Class EaCustomDiagram.
 */
@Entity
@DiscriminatorValue(value = "Custom")
public class EaCustomDiagram extends EaDiagram {

    /**
     * Instantiates a new ea custom diagram.
     */
    public EaCustomDiagram() {
        // TODO Auto-generated constructor stub
    }

}
