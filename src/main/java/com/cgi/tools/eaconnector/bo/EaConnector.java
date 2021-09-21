/**
 * 
 */
package com.cgi.tools.eaconnector.bo;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

import javax.persistence.*;

// TODO: Auto-generated Javadoc
/**
 * The Class EaConnector.
 */
@Entity
@Table(name = "t_connector")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "connector_type")
public abstract class EaConnector extends AbstractEaObject implements Serializable{

    /** The id. */
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "CONNECTOR_ID_SEQ")
    @SequenceGenerator(name="CONNECTOR_ID_SEQ", sequenceName="CONNECTOR_ID_SEQ",allocationSize=1)
    @Column(name = "CONNECTOR_ID", columnDefinition="serial")
    @Id
    private int id;
    
    /** The guid. */
    @Column(name = "EA_GUID")
    private String guid;
    
    /** The stereotype. */
    private String stereotype;
    
    /** The name. */
    private String name;
    
    /** The pdata2. */
    private String pdata2;
    
    /** The start. */
    @JoinColumn(name = "START_OBJECT_ID")
    @OneToOne(fetch = FetchType.LAZY)
    private EaObject start;
    
    /** The end. */
    @JoinColumn(name = "END_OBJECT_ID")
    @OneToOne(fetch = FetchType.LAZY)
    private EaObject end;
    
    /** The direction. */
    @Column(name = "DIRECTION")
    private String direction;

    @OneToMany(mappedBy = "connector", fetch = FetchType.LAZY, orphanRemoval=true, cascade = CascadeType.REMOVE)
    private Set<EaConnectorConstraint> constraints;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="DIAGRAMID", insertable=false, updatable=false)
    private EaDiagram diagram;

    @Column(name = "end_object_id", insertable = false, updatable = false)
    private Integer startObjectId;

    @Column(name = "start_object_id", insertable = false, updatable = false)
    private Integer endObjectId;

    /**
     * Instantiates a new ea connector.
     */
    public EaConnector() {
        guid = "{"+UUID.randomUUID().toString() +"}";
    }
    
    /**
     * Gets the id.
     * 
     * @return the id
     */

    public int getId() {
        return id;
    }

    /* (non-Javadoc)
     * @see com.cgi.tools.eaconnector.bo.AbstractEaObject#getName()
     */

    @Override
    public String getGuid() {
        return guid;
    }
    

    public String getDirection() {
        return direction;
    }
    
    
    public void setDirection(String direction) {
        this.direction=direction;
    }

    /**
     * Sets the id.
     * 
     * @param id
     *            the new id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets the guid.
     * 
     * @param guid
     *            the new guid
     */
    public void setGuid(String guid) {
        this.guid = guid;
    }

    /**
     * Gets the start.
     * 
     * @return the start
     */

    public EaObject getStart() {
        return start;
    }

    public void setStart(EaObject start) {
        this.start = start;
    }

    /**
     * Gets the end.
     * 
     * @return the end
     */
    public EaObject getEnd() {
        return end;
    }

    /**
     * Sets the end.
     * 
     * @param end
     *            the new end
     */
    public void setEnd(EaObject end) {
        this.end = end;
    }

    /**
     * Gets the stereotype.
     * 
     * @return the stereotype
     */
    public String getStereotype() {
        return stereotype;
    }

    /**
     * Sets the stereotype.
     * 
     * @param stereotype
     *            the new stereotype
     */
    public void setStereotype(String stereotype) {
        this.stereotype = stereotype;
    }

    /* (non-Javadoc)
     * @see com.cgi.tools.eaconnector.bo.AbstractEaObject#getName()
     */
    @Override
    public String getName() {
        return name ;
    }

    /**
     * Sets the name.
     * 
     * @param name
     *            the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the pdata2.
     * 
     * @return the pdata2
     */
    public String getPdata2() {
        return pdata2;
    }

    /**
     * Sets the pdata2.
     * 
     * @param pdata2
     *            the new pdata2
     */
    public void setPdata2(String pdata2) {
        this.pdata2 = pdata2;
    }

    /**
     * Gets the connector name.
     * 
     * @return the connector name
     */
    @Transient
    public String getConnectorName() {
        String name = null;
        if (getName() != null) {
            name = getName();
        } else {
            name = getPdata2();
        }
        return name;
    }
    

    /** The diagram. */



    public Integer getEndObjectId() {
        return endObjectId;
    }

    public void setEndObjectId(Integer endObjectId) {
        this.endObjectId = endObjectId;
    }


    public Integer getStartObjectId() {
        return startObjectId;
    }

    public void setStartObjectId(Integer startObjectId) {
        this.startObjectId = startObjectId;
    }



    /**
     * Gets the diagram.
     * 
     * @return the diagram
     */

    
    public EaDiagram getDiagram() {
        return diagram;
    }

    /**
     * Sets the diagram.
     * 
     * @param tDiagram
     *            the new diagram
     */
    public void setDiagram(EaDiagram tDiagram) {
        diagram = tDiagram;
    }


    public Set<EaConnectorConstraint> getConstraints() {
        return constraints;
    }

    public void setConstraints(Set<EaConnectorConstraint> constraints) {
        this.constraints = constraints;
    }

    /* (non-Javadoc)
     * @see com.cgi.tools.eaconnector.bo.AbstractEaObject#save()
     */
    @Override
    public void save() {
/*        if(id == 0) {
            id = ((BigDecimal)EaEntityManager.getInstance().getManager().createNativeQuery("select CONNECTOR_ID_SEQ.nextval from dual").getResultList().get(0)).intValue();
        }*/
    }
    
    
}
