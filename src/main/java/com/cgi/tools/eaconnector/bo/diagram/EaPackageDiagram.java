/**
 * 
 */
package com.cgi.tools.eaconnector.bo.diagram;

import com.cgi.tools.eaconnector.bo.EaDiagram;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

// TODO: Auto-generated Javadoc

/**
 * The Class EaLogicalDiagram.
 */
@Entity
@DiscriminatorValue(value = "Package")
public class EaPackageDiagram extends EaDiagram {

    /**
     * Instantiates a new ea logical diagram.
     */
    public EaPackageDiagram() {
        // TODO Auto-generated constructor stub
    }

}
