/**
 * 
 */
package com.cgi.tools.eaconnector.bo.diagram;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import com.cgi.tools.eaconnector.bo.EaDiagram;

// TODO: Auto-generated Javadoc
/**
 * The Class EaDeploymentDiagram.
 */
@Entity
@DiscriminatorValue(value = "Deployment")
public class EaDeploymentDiagram extends EaDiagram {

    /**
     * Instantiates a new ea deployment diagram.
     */
    public EaDeploymentDiagram() {
        // TODO Auto-generated constructor stub
    }

}
