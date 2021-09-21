/**
 * 
 */
package com.cgi.tools.eaconnector.bo.diagram;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import com.cgi.tools.eaconnector.bo.EaDiagram;

// TODO: Auto-generated Javadoc
/**
 * The Class EaLogicalDiagram.
 */
@Entity
@DiscriminatorValue(value = "Logical")
public class EaLogicalDiagram extends EaDiagram {

    /**
     * Instantiates a new ea logical diagram.
     */
    public EaLogicalDiagram() {
        // TODO Auto-generated constructor stub
    }

}
