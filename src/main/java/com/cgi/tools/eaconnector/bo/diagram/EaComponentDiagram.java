/**
 * 
 */
package com.cgi.tools.eaconnector.bo.diagram;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import com.cgi.tools.eaconnector.bo.EaDiagram;

// TODO: Auto-generated Javadoc
/**
 * The Class EaComponentDiagram.
 */
@Entity
@DiscriminatorValue(value = "Component")
public class EaComponentDiagram extends EaDiagram {

    /**
     * Instantiates a new ea component diagram.
     */
    public EaComponentDiagram() {
        // TODO Auto-generated constructor stub
    }

}
