package com.cgi.tools.eaconnector.bo;

import java.util.UUID;

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
 * The Class EaTaggedValue.
 */
@Entity
@Table(name = "t_objectproperties")
public class EaTaggedValue extends AbstractEaObject {

    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "PROPERTYID_SEQ")
    @SequenceGenerator(name = "PROPERTYID_SEQ", sequenceName = "PROPERTYID_SEQ", allocationSize = 1)
    @Column(name = "PROPERTYID")
    private int id;

    /** The object id. */
    @Column(name = "OBJECT_ID", insertable = false, updatable = false)
    private int objectId;

    /** The name. */
    @Column(name = "PROPERTY")
    private String name;

    /** The value. */
    @Column(name = "VALUE")
    private String value;

    /** The guid. */
    @Column(name = "EA_GUID")
    private String guid;

    /** The ea object. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OBJECT_ID")
    private EaObject eaObject;

    /**
     * Instantiates a new ea tagged value.
     */
    public EaTaggedValue() {
        guid = "{" + UUID.randomUUID().toString() + "}";
    }

    /**
     * Gets the object id.
     * 
     * @return the object id
     */
    public int getObjectId() {
        return objectId;
    }

    /**
     * Sets the object id.
     * 
     * @param objectId
     *            the new object id
     */
    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }

    /**
     * Gets the name.
     * 
     * @return the name
     */
    public String getName() {
        return name;
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
     * Gets the value.
     * 
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value.
     * 
     * @param value
     *            the new value
     */
    public void setValue(String value) {
        this.value = value;
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
     * Sets the id.
     * 
     * @param id
     *            the new id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the guid.
     * 
     * @return the guid
     */
    public String getGuid() {
        return guid;
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
        if(!eaObject.getTaggedValues().contains(this)) {
            eaObject.getTaggedValues().add(this);
        }
    }

}
