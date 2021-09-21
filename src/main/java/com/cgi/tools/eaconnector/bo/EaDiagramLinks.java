/**
 * 
 */
package com.cgi.tools.eaconnector.bo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class EaDiagramLinks.
 */
@Entity
@Table(name = "t_diagramlinks")
public class EaDiagramLinks extends AbstractEaObject {

    /** The instance id. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "INSTANCE_ID_SEQ")
    @SequenceGenerator(name="INSTANCE_ID_SEQ", sequenceName="INSTANCE_ID_SEQ",allocationSize=1)
    @Column(name="INSTANCE_ID")
    private int instanceId;

    /**
     * Gets the instance id.
     * 
     * @return the instance id
     */
    public int getInstanceId() {
		return instanceId;
	}

	/** The ea diagram. */
    @JoinColumn(name = "DIAGRAMID")
    @ManyToOne(fetch = FetchType.LAZY)
    private EaDiagram eaDiagram;

    /** The ea connector. */
    @JoinColumn(name = "CONNECTORID", referencedColumnName="CONNECTOR_ID")
    @OneToOne(fetch = FetchType.LAZY)
    private EaConnector eaConnector;

    /** The geometry. */
    private String geometry;

    /** The path. */
    private String path;
    
    /** The style. */
    private String style;
    
    /**
     * Gets the ea diagram.
     * 
     * @return the ea diagram
     */
    public EaDiagram getEaDiagram() {
        return eaDiagram;
    }

    /**
     * Sets the ea diagram.
     * 
     * @param eaDiagram
     *            the new ea diagram
     */
    public void setEaDiagram(EaDiagram eaDiagram) {
        this.eaDiagram = eaDiagram;
    }

    /**
     * Gets the ea connector.
     * 
     * @return the ea connector
     */

    public EaConnector getEaConnector() {
        return eaConnector;
    }

    /**
     * Sets the ea connector.
     * 
     * @param eaConnector
     *            the new ea connector
     */
    public void setEaConnector(EaConnector eaConnector) {
        this.eaConnector = eaConnector;
    }

    /**
     * Gets the geometry.
     * 
     * @return the geometry
     */
    public String getGeometry() {
        return geometry;
    }

    /**
     * Sets the geometry.
     * 
     * @param geometry
     *            the new geometry
     */
    public void setGeometry(String geometry) {
        this.geometry = geometry;
    }

    /**
     * Gets the path.
     * 
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * Sets the path.
     * 
     * @param path
     *            the new path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Gets the style.
     * 
     * @return the style
     */
    public String getStyle() {
        return style;
    }

    /**
     * Sets the style.
     * 
     * @param style
     *            the new style
     */
    public void setStyle(String style) {
        this.style = style;
    }

    
}
