/**
 * 
 */
package com.cgi.tools.eaconnector.bo.diagram;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import com.cgi.tools.eaconnector.bo.EaDiagram;

// TODO: Auto-generated Javadoc
/**
 * The Class EaObjectDiagram.
 */
@Entity
@DiscriminatorValue(value = "Object")
public class EaObjectDiagram extends EaDiagram {

    /**
     * Instantiates a new ea object diagram.
     */
    public EaObjectDiagram() {
        // TODO Auto-generated constructor stub
    }

}
