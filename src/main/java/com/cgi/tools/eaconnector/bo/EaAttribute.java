package com.cgi.tools.eaconnector.bo;

import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 * The Class EaAttribute.
 */
@Entity(name = "t_attribute")
public class EaAttribute extends AbstractEaObject {

    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ID_SEQ")
    @SequenceGenerator(name = "ID_SEQ", sequenceName = "ID_SEQ", allocationSize = 1)
    @Column(name = "id")
    private int id;

    /** The guid. */
    @Column(name = "EA_GUID")
    private String guid;

    /** The parent. */
    @ManyToOne
    @JoinColumn(name = "object_id")
    private EaObject parent;

    /** The name. */
    @Column(name = "NAME")
    private String name;

    /** The notes. */
    @Column(name = "NOTES")
    @Basic(fetch = FetchType.LAZY)
    private String notes;

    /** The type. */
    @Column(name = "TYPE")
    private String type;

    /** The length. */
    @Column(name = "LENGTH")
    private Integer length;

    /** The precision. */
    @Column(name = "PRECISION")
    private Integer precision;

    /** The stereotype. */
    @Column(name = "STEREOTYPE")
    private String stereotype;

    /** The scope. */
    @Column(name = "SCOPE")
    private String scope;

    public EaAttribute() {
        guid = "{" + UUID.randomUUID().toString() + "}";
    }

    public int getId() {
        return id;
    }

    public EaObject getParent() {
        return parent;
    }

    public String getName() {
        return name;
    }

    public String getNotes() {
        return notes;
    }

    public String getType() {
        return type;
    }

    public Integer getLength() {
        return length;
    }

    public String getStereotype() {
        return stereotype;
    }

    public String getScope() {
        return scope;
    }

    @Override
    public String getGuid() {
        return guid;
    }

    public Integer getPrecision() {
        return precision;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param guid the guid to set
     */
    public void setGuid(String guid) {
        this.guid = guid;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(EaObject parent) {
        this.parent = parent;
        if(!parent.getAttributes().contains(this)) {
            parent.getAttributes().add(this);
        }
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param notes the notes to set
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @param length the length to set
     */
    public void setLength(Integer length) {
        this.length = length;
    }

    /**
     * @param precision the precision to set
     */
    public void setPrecision(Integer precision) {
        this.precision = precision;
    }

    /**
     * @param stereotype the stereotype to set
     */
    public void setStereotype(String stereotype) {
        this.stereotype = stereotype;
    }

    /**
     * @param scope the scope to set
     */
    public void setScope(String scope) {
        this.scope = scope;
    }

}
