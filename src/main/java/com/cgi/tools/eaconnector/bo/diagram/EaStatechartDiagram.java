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
@DiscriminatorValue(value = "Statechart")
public class EaStatechartDiagram extends EaDiagram {

    /**
     * Instantiates a new ea object diagram.
     */
    public EaStatechartDiagram() {
        // TODO Auto-generated constructor stub
    }

}
