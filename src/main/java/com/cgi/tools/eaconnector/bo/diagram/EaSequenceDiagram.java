/**
 * 
 */
package com.cgi.tools.eaconnector.bo.diagram;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import com.cgi.tools.eaconnector.bo.EaDiagram;

// TODO: Auto-generated Javadoc
/**
 * The Class EaSequenceDiagram.
 */
@Entity
@DiscriminatorValue(value = "Sequence")
public class EaSequenceDiagram extends EaDiagram {

    /**
     * Instantiates a new ea sequence diagram.
     */
    public EaSequenceDiagram() {
        // TODO Auto-generated constructor stub
    }

}
