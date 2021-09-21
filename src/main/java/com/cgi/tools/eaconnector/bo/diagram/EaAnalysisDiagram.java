/**
 * 
 */
package com.cgi.tools.eaconnector.bo.diagram;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import com.cgi.tools.eaconnector.bo.EaDiagram;

// TODO: Auto-generated Javadoc
/**
 * The Class EaAnalysisDiagram.
 */
@Entity
@DiscriminatorValue(value = "Analysis")
public class EaAnalysisDiagram extends EaDiagram {

    /**
     * Instantiates a new ea analysis diagram.
     */
    public EaAnalysisDiagram() {
        // TODO Auto-generated constructor stub
    }

}
