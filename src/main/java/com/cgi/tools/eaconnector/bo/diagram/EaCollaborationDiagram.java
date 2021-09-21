/**
 * 
 */
package com.cgi.tools.eaconnector.bo.diagram;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import com.cgi.tools.eaconnector.bo.EaDiagram;

// TODO: Auto-generated Javadoc
/**
 * The Class EaCollaborationDiagram.
 */
@Entity
@DiscriminatorValue(value = "Collaboration")
public class EaCollaborationDiagram extends EaDiagram {

    /**
     * Instantiates a new ea collaboration diagram.
     */
    public EaCollaborationDiagram() {
        // TODO Auto-generated constructor stub
    }

}
