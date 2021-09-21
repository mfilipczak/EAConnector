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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The Class EaDiagramObject.
 */
@Entity
@Table(name="t_diagramobjects")
//@SecondaryTable(name="t_connector", pkJoinColumns=@PrimaryKeyJoinColumn(name="CONNECTOR_ID", referencedColumnName="OBJECT_ID"))
public class EaDiagramObject extends AbstractEaObject {
    
    /** The instance id. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "INSTANCE_ID_SEQ")
    @SequenceGenerator(name="INSTANCE_ID_SEQ", sequenceName="INSTANCE_ID_SEQ",allocationSize=1)
    @Column(name="INSTANCE_ID")
    private int instanceId;
    
    /** The top. */
    @Column(name = "RECTTOP")
    private int top = 0;
    
    /** The left. */
    @Column(name = "RECTLEFT")
    private int left = 0;
    
    /** The right. */
    @Column(name = "RECTRIGHT")
    private int right = 70;
    
    /** The bottom. */
    @Column(name = "RECTBOTTOM")
    private int bottom = -40;
    
    /** The ea diagram. */
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="DIAGRAM_ID")
    private EaDiagram eaDiagram;
    
    /** The ea object. */
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="OBJECT_ID")
    private EaObject eaObject;

    /**
     * Gets the ea object.
     * 
     * @return the ea object
     */
    public EaObject getEaObject() {
        return eaObject;
    }

    /**
     * Sets the ea object.
     * 
     * @param eaObject
     *            the new ea object
     */
    public void setEaObject(EaObject eaObject) {
        this.eaObject = eaObject;
    }

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
     * Gets the top.
     * 
     * @return the top
     */

    public int getTop() {
        return top;
    }

    /**
     * Sets the top.
     * 
     * @param top
     *            the new top
     */
    public void setTop(int top) {
        this.top = top;
    }

    /**
     * Gets the left.
     * 
     * @return the left
     */

    public int getLeft() {
        return left;
    }

    /**
     * Sets the left.
     * 
     * @param left
     *            the new left
     */
    public void setLeft(int left) {
        this.left = left;
    }

    /**
     * Gets the right.
     * 
     * @return the right
     */

    public int getRight() {
        return right;
    }

    /**
     * Sets the right.
     * 
     * @param right
     *            the new right
     */
    public void setRight(int right) {
        this.right = right;
    }

    /**
     * Gets the bottom.
     * 
     * @return the bottom
     */

    public int getBottom() {
        return bottom;
    }

    /**
     * Sets the bottom.
     * 
     * @param bottom
     *            the new bottom
     */
    public void setBottom(int bottom) {
        this.bottom = bottom;
    }

	public int getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(int instanceId) {
		this.instanceId = instanceId;
	}
}
