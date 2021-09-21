/**
 * 
 */
package com.cgi.tools.eaconnector.bo.diagram;

import com.cgi.tools.eaconnector.bo.EaDiagram;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

// TODO: Auto-generated Javadoc

/**
 * The Class EaObjectDiagram.
 */
@Entity
@DiscriminatorValue(value = "CompositeStructure")
public class EaCompositeStructureDiagram extends EaDiagram {

    /**
     * Instantiates a new ea object diagram.
     */
    public EaCompositeStructureDiagram() {
        // TODO Auto-generated constructor stub
    }

}
