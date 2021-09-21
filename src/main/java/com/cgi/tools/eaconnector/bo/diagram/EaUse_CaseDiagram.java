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
@DiscriminatorValue(value = "Use Case")
public class EaUse_CaseDiagram extends EaDiagram {

    /**
     * Instantiates a new ea object diagram.
     */
    public EaUse_CaseDiagram() {
        // TODO Auto-generated constructor stub
    }

}
