/**
 * 
 */
package com.cgi.tools.eaconnector.bo.diagram;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import com.cgi.tools.eaconnector.bo.EaConnector;
import com.cgi.tools.eaconnector.bo.EaDiagram;
import com.cgi.tools.eaconnector.bo.EaDiagramLinks;

// TODO: Auto-generated Javadoc
/**
 * The Class EaActivityDiagram.
 */
@Entity
@DiscriminatorValue(value = "Activity")
public class EaActivityDiagram extends EaDiagram {

    /**
     * Instantiates a new ea activity diagram.
     */
    public EaActivityDiagram() {
        // TODO Auto-generated constructor stub
    }
    
    /* (non-Javadoc)
     * @see com.cgi.tools.eaconnector.bo.EaDiagram#getConnectors()
     */
    @Override
    public Set<EaConnector> getConnectors() {
        Set<EaConnector> connectors = new HashSet<EaConnector>();
        for(EaDiagramLinks link : getDiagramLinks()){
            connectors.add(link.getEaConnector());
        }
        return connectors;
    }
}
