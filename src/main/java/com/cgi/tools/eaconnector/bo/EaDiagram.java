/**
 * 
 */
package com.cgi.tools.eaconnector.bo;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EntityNotFoundException;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;

/**
 * The Class EaDiagram.
 */
@Entity
@Table(name = "t_diagram")
@SuppressWarnings("serial")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "diagram_type")
public abstract class EaDiagram extends AbstractEaObject {

    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "DIAGRAM_ID_SEQ")
    @SequenceGenerator(name = "DIAGRAM_ID_SEQ", sequenceName = "DIAGRAM_ID_SEQ", allocationSize = 1)
    @Column(name = "DIAGRAM_ID")
    private int id;

    /** The name. */
    private String name;

    /** The guid. */
    @Column(name = "EA_GUID")
    private String guid;

    /** The type. */
    @Column(name = "diagram_type", insertable = false, updatable = false)
    private String type;

    /** The notes. */
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "notes")
    private String notes;

    /** The parent package. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "package_id")
    private EaPackage parentPackage;

    /** The parent object. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentid")
    private EaObject parentObject;

    /** The diagram links. */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "eaDiagram",cascade = CascadeType.REMOVE,  orphanRemoval=true)
    private Set<EaDiagramLinks> diagramLinks;

    /** The diagram objects. */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "eaDiagram",cascade = CascadeType.REMOVE, orphanRemoval=true)
    private Set<EaDiagramObject> diagramObjects;

    /** The connectors. */
    @OneToMany(mappedBy = "diagram", fetch = FetchType.LAZY, orphanRemoval=true, cascade = CascadeType.REMOVE)
    private Set<EaConnector> connectors;

    /** The modifieddate. */
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifieddate;

    /** The createddate. */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(insertable = false, updatable = false)
    private Date createddate;

    /**
     * Instantiates a new ea diagram.
     */
    public EaDiagram() {
        guid = "{" + UUID.randomUUID().toString() + "}";
    }

    /**
     * Gets the id.
     * 
     * @return the id
     */

    public int getId() {
        return id;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return name;
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
     * Sets the name.
     * 
     * @param name
     *            the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the diagram links.
     * 
     * @return the diagram links
     */

    public Set<EaDiagramLinks> getDiagramLinks() {
        return diagramLinks;
    }

    /**
     * Sets the diagram links.
     * 
     * @param diagramLinks
     *            the new diagram links
     */

    public void setDiagramLinks(Set<EaDiagramLinks> diagramLinks) {
        this.diagramLinks = diagramLinks;
    }

    /**
     * Gets the diagram objects.
     * 
     * @return the diagram objects
     */

    public Set<EaDiagramObject> getDiagramObjects() {
        return diagramObjects;
    }

    /**
     * Sets the diagram objects.
     * 
     * @param diagramObjects
     *            the new diagram objects
     */

    public void setDiagramObjects(Set<EaDiagramObject> diagramObjects) {
        this.diagramObjects = diagramObjects;
    }

    /**
     * Gets the connectors.
     * 
     * @return the connectors
     */

    public Set<EaConnector> getConnectors() {
        return connectors;
    }

    /**
     * Sets the connectors.
     * 
     * @param tConnectors
     *            the new connectors
     */
    public void setConnectors(Set<EaConnector> tConnectors) {
        connectors = tConnectors;
    }

    /**
     * Gets the parent package.
     * 
     * @return the parent package
     */
    public EaPackage getParentPackage() {
        return parentPackage;
    }

    /**
     * Sets the parent package.
     * 
     * @param parentPackage
     *            the new parent package
     */
    public void setParentPackage(EaPackage parentPackage) {
        this.parentPackage = parentPackage;
    }

    /**
     * Gets the parent object.
     * 
     * @return the parent object
     */
    public EaObject getParentObject() {
        return parentObject;
    }

    /**
     * Sets the parent object.
     * 
     * @param parentObject
     *            the new parent object
     */
    public void setParentObject(EaObject parentObject) {
        this.parentObject = parentObject;
    }

    /**
     * Adds the diagram object.
     * 
     * @param diagramObject
     *            the diagram object
     */
    @Transient
    public void addDiagramObject(EaDiagramObject diagramObject) {
        diagramObjects.add(diagramObject);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transient
    public AbstractEaObject getParent() {
        try {
            getParentObject().getId();
            return getParentObject();
        } catch (EntityNotFoundException e) {
            return getParentPackage();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getGuid() {
        return guid;
    }

    /**
     * Gets the type.
     * 
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type.
     * 
     * @param type
     *            the new type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the notes.
     * 
     * @return the notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Sets the notes.
     * 
     * @param notes
     *            the new notes
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * Gets the modifieddate.
     * 
     * @return the modifieddate
     */
    public Date getModifieddate() {
        return modifieddate;
    }

    /**
     * Sets the modifieddate.
     * 
     * @param modifieddate
     *            the new modifieddate
     */
    public void setModifieddate(Date modifieddate) {
        this.modifieddate = modifieddate;
    }

    /**
     * Gets the createddate.
     * 
     * @return the createddate
     */
    public Date getCreateddate() {
        return createddate;
    }

    /**
     * Sets the createddate.
     * 
     * @param createddate
     *            the new createddate
     */
    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
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

}
