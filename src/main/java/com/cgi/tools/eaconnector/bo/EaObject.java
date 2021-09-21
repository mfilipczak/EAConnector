/**
 * 
 */
package com.cgi.tools.eaconnector.bo;

import java.math.BigDecimal;
import java.util.*;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
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

/**
 * The Class EaObject.
 */
@Entity
@Table(name = "t_object")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "object_type")
public abstract class EaObject extends TaggedEaObject {

    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "OBJECT_ID_SEQ")
    @SequenceGenerator(name = "OBJECT_ID_SEQ", sequenceName = "OBJECT_ID_SEQ", allocationSize = 1)
    @Column(name = "OBJECT_ID")
    private int id;

    /** The guid. */
    @Column(name = "EA_GUID")
    private String guid;

    /** The name. */
    @Column(name = "NAME")
    private String name;

    /** The notes. */
    @Lob
    @Column(name = "NOTE")
    @Basic(fetch = FetchType.LAZY)
    private String notes;

    /** The ntype. */
    @Column(name = "NTYPE")
    private String ntype;

    /** The stereotype. */
    @Column(name = "STEREOTYPE")
    private String stereotype;

    /** The abstract_. */
    @Column(name = "ABSTRACT", length = 1)
    private String abstract_;

    /** The actionflags. */
    @Column(length = 255)
    private String actionflags;

    /** The alias. */
    @Column(name = "\"ALIAS\"", length = 255)
    private String alias;

    /** The author. */
    @Column(length = 255)
    private String author = "Unknown";

    /** The backcolor. */
    @Column(precision = 10)
    private BigDecimal backcolor;

    /** The bordercolor. */
    @Column(precision = 10)
    private BigDecimal bordercolor;

    /** The borderstyle. */
    @Column(precision = 10)
    private BigDecimal borderstyle;

    /** The borderwidth. */
    @Column(precision = 10)
    private BigDecimal borderwidth;

    /** The cardinality. */
    @Column(length = 50)
    private String cardinality;

    /** The classifier guid. */
    @Column(name = "CLASSIFIER_GUID", length = 40)
    private String classifierGuid;

    /** The complexity. */
    @Column(length = 50)
    private String complexity;

    /** The concurrency. */
    @Column(length = 50)
    private String concurrency;

    /** The createddate. */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(insertable = false, updatable = false)
    private Date createddate;

    /** The effort. */
    @Column(precision = 10)
    private BigDecimal effort;

    /** The eventflags. */
    @Column(length = 255)
    private String eventflags;

    /** The fontcolor. */
    @Column(precision = 10)
    private BigDecimal fontcolor;

    /** The genfile. */
    @Column(length = 255)
    private String genfile;

    /** The genlinks. */
    @Lob
    private String genlinks;

    /** The genoption. */
    @Lob
    private String genoption;

    /** The gentype. */
    @Column(length = 50)
    private String gentype;

    /** The header1. */
    @Lob
    private String header1;

    /** The header2. */
    @Lob
    private String header2;

    /** The isactive. */
    @Column(precision = 10)
    private int isactive = 0;

    /** The isleaf. */
    @Column(precision = 10)
    private int isleaf = 0;

    /** The isroot. */
    @Column(precision = 10)
    private int isroot = 0;

    /** The isspec. */
    @Column(precision = 10)
    private int isspec = 0;

    /** The modifieddate. */
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifieddate;

    /** The multiplicity. */
    @Column(length = 50)
    private String multiplicity;

    /** The packageflags. */
    @Column(length = 255)
    private String packageflags;

    /** The pdata2. */
    @Column(length = 255)
    private String pdata2;

    /** The pdata3. */
    @Column(length = 255)
    private String pdata3;

    /** The pdata4. */
    @Column(length = 255)
    private String pdata4;

    /** The pdata5. */
    @Column(length = 255)
    private String pdata5;

    /** The persistence. */
    @Column(length = 50)
    private String persistence;

    /** The phase. */
    @Column(length = 50)
    private String phase;

    /** The runstate. */
    @Lob
    private String runstate;

    /** The scope. */
    @Column(name = "\"SCOPE\"", length = 25)
    private String scope;

    /** The stateflags. */
    @Column(length = 255)
    private String stateflags;

    /** The status. */
    @Column(length = 50)
    private String status = "Proposed";

    /** The style. */
    @Column(length = 255)
    private String style;

    /** The styleex. */
    @Lob
    private String styleex;

    /** The tagged. */
    @Column(precision = 10)
    private Integer tagged = 0;

    /** The tpos. */
    @Column(precision = 10)
    private Integer tpos = 0;

    /** The version. */
    @Column(name = "\"VERSION\"", length = 50)
    private String version = "1.0";

    /** The visibility. */
    @Column(length = 50)
    private String visibility;

    /** The package id. */
    @Column(name = "PACKAGE_ID", insertable = false, updatable = false)
    private Integer packageId;

    /** The parent object. */
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "PARENTID")
    protected EaObject parentObject;

    /** The classifier. */
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "CLASSIFIER")
    private EaObject classifier;

    /** The objects. */
    @OneToMany(mappedBy = "parentObject", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    protected Set<EaObject> objects;

    /** The parent package. */
    @JoinColumn(name = "PACKAGE_ID")
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    protected EaPackage parentPackage;

    /** The pdata1. */
    @Column(name = "PDATA1", insertable = false, updatable = false)
    private String pdata1;

    /** The attributes. */
    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<EaAttribute> attributes = new HashSet<>();

    /** The diagrams. */
    @OneToMany(mappedBy = "parentObject", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    protected Set<EaDiagram> diagrams;

    /** The tagged values. */
    @OneToMany(mappedBy = "objectId", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<EaTaggedValue> taggedValues = new ArrayList<EaTaggedValue>();

    /** The tagged values. */
    @OneToMany(mappedBy = "objectId", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<EaObjectEffort> objectEfforts;

    @OneToMany(mappedBy = "objectId", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<EaObjectFiles> objectFiles;

    @OneToMany(mappedBy = "objectId", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<EaObjectMetrics> objectMetrics;

    @OneToMany(mappedBy = "objectId", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<EaObjectProblems> objectProblems;

    @OneToMany(mappedBy = "objectId", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<EaObjectRequires> objectRequires;

    @OneToMany(mappedBy = "objectId", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<EaObjectScenarios> objectScenarios;

    public List<EaObjectScenarios> getObjectScenarios() {
        return objectScenarios;
    }

    public void setObjectScenarios(List<EaObjectScenarios> objectScenarios) {
        this.objectScenarios = objectScenarios;
    }

    public List<EaObjectRequires> getObjectRequires() {
        return objectRequires;
    }

    public void setObjectRequires(List<EaObjectRequires> objectRequires) {
        this.objectRequires = objectRequires;
    }

    public List<EaObjectProblems> getObjectProblems() {
        return objectProblems;
    }

    public void setObjectProblems(List<EaObjectProblems> objectProblems) {
        this.objectProblems = objectProblems;
    }



    public List<EaObjectMetrics> getObjectMetrics() {
        return objectMetrics;
    }

    public void setObjectMetrics(List<EaObjectMetrics> objectMetrics) {
        this.objectMetrics = objectMetrics;
    }

    public List<EaObjectFiles> getObjectFiles() {
        return objectFiles;
    }

    public void setObjectFiles(List<EaObjectFiles> objectFiles) {
        this.objectFiles = objectFiles;
    }

    public List<EaObjectEffort> getObjectEfforts() {
        return objectEfforts;
    }

    public void setObjectEfforts(List<EaObjectEffort> objectEfforts) {
        this.objectEfforts = objectEfforts;
    }

    /**
     * Instantiates a new ea object.
     */
    public EaObject() {
    }

    /**
     * Gets the id.
     * 
     * @return the id
     */

    public int getId() {
        return id;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.cgi.tools.eaconnector.bo.AbstractEaObject#getName()
     */

    /**
     * {@inheritDoc}
     */
    @Override
    public String getGuid() {
        return guid;
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

    /*
     * (non-Javadoc)
     * 
     * @see com.cgi.tools.eaconnector.bo.AbstractEaObject#getName()
     */

    /**
     * {@inheritDoc}
     */
    @Override
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
     * Gets the ntype.
     * 
     * @return the ntype
     */

    public String getNtype() {
        return ntype;
    }

    /**
     * Sets the ntype.
     * 
     * @param ntype
     *            the new ntype
     */
    public void setNtype(String ntype) {
        this.ntype = ntype;
    }

    /**
     * Gets the pdata1.
     * 
     * @return the pdata1
     */

    public String getPdata1() {
        return pdata1;
    }

    /**
     * Sets the pdata1.
     * 
     * @param pdata1
     *            the new pdata1
     */
    public void setPdata1(String pdata1) {
        this.pdata1 = pdata1;
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

    /**
     * Gets the classifier.
     * 
     * @return the classifier
     */

    public EaObject getClassifier() {
        return classifier;
    }

    /**
     * Sets the classifier.
     * 
     * @param classifier
     *            the new classifier
     */
    public void setClassifier(EaObject classifier) {
        this.classifier = classifier;
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
     * @param parent
     *            the new parent object
     */
    public void setParentObject(EaObject parent) {
        this.parentObject = parent;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.cgi.tools.eaconnector.bo.AbstractEaObject#getParent()
     */
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
        } catch (Exception e) {
            return getParentPackage();
        }
    }

    /**
     * Gets the objects.
     * 
     * @return the objects
     */

    public Set<EaObject> getObjects() {
        return objects;
    }

    /**
     * Sets the objects.
     * 
     * @param objects
     *            the new objects
     */

    public void setObjects(Set<EaObject> objects) {
        this.objects = objects;
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
        this.setPackageId(parentPackage.getPackageId());
    }

    /**
     * Gets the attributes.
     * 
     * @return the attributes
     */

    public Set<EaAttribute> getAttributes() {
        return attributes;
    }

    /**
     * Sets the attributes.
     * 
     * @param attributes
     *            the new attributes
     */
    public void setAttributes(Set<EaAttribute> attributes) {
        this.attributes = attributes;
    }

    /**
     * Adds the attribute.
     * 
     * @param attribute
     *            the tv
     */
    public void addAttribute(EaAttribute attribute) {
        attributes.add(attribute);
        if (attribute.getParent() != this) {
            attribute.setParent(this);
        }
    }

    /**
     * Gets the diagrams.
     * 
     * @return the diagrams
     */
    public Set<EaDiagram> getDiagrams() {
        return diagrams;
    }

    /**
     * Sets the diagrams.
     * 
     * @param diagrams
     *            the new diagrams
     */
    public void setDiagrams(Set<EaDiagram> diagrams) {
        this.diagrams = diagrams;
    }

    /**
     * Gets the abstract_.
     * 
     * @return the abstract_
     */
    public String getAbstract_() {
        return abstract_;
    }

    /**
     * Sets the abstract_.
     * 
     * @param abstract_
     *            the new abstract_
     */
    public void setAbstract_(String abstract_) {
        this.abstract_ = abstract_;
    }

    /**
     * Gets the actionflags.
     * 
     * @return the actionflags
     */
    public String getActionflags() {
        return actionflags;
    }

    /**
     * Sets the actionflags.
     * 
     * @param actionflags
     *            the new actionflags
     */
    public void setActionflags(String actionflags) {
        this.actionflags = actionflags;
    }

    /**
     * Gets the alias.
     * 
     * @return the alias
     */
    public String getAlias() {
        return alias;
    }

    /**
     * Sets the alias.
     * 
     * @param alias
     *            the new alias
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * Gets the author.
     * 
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the author.
     * 
     * @param author
     *            the new author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Gets the backcolor.
     * 
     * @return the backcolor
     */
    public BigDecimal getBackcolor() {
        return backcolor;
    }

    /**
     * Sets the backcolor.
     * 
     * @param backcolor
     *            the new backcolor
     */
    public void setBackcolor(BigDecimal backcolor) {
        this.backcolor = backcolor;
    }

    /**
     * Gets the bordercolor.
     * 
     * @return the bordercolor
     */
    public BigDecimal getBordercolor() {
        return bordercolor;
    }

    /**
     * Sets the bordercolor.
     * 
     * @param bordercolor
     *            the new bordercolor
     */
    public void setBordercolor(BigDecimal bordercolor) {
        this.bordercolor = bordercolor;
    }

    /**
     * Gets the borderstyle.
     * 
     * @return the borderstyle
     */
    public BigDecimal getBorderstyle() {
        return borderstyle;
    }

    /**
     * Sets the borderstyle.
     * 
     * @param borderstyle
     *            the new borderstyle
     */
    public void setBorderstyle(BigDecimal borderstyle) {
        this.borderstyle = borderstyle;
    }

    /**
     * Gets the borderwidth.
     * 
     * @return the borderwidth
     */
    public BigDecimal getBorderwidth() {
        return borderwidth;
    }

    /**
     * Sets the borderwidth.
     * 
     * @param borderwidth
     *            the new borderwidth
     */
    public void setBorderwidth(BigDecimal borderwidth) {
        this.borderwidth = borderwidth;
    }

    /**
     * Gets the cardinality.
     * 
     * @return the cardinality
     */
    public String getCardinality() {
        return cardinality;
    }

    /**
     * Sets the cardinality.
     * 
     * @param cardinality
     *            the new cardinality
     */
    public void setCardinality(String cardinality) {
        this.cardinality = cardinality;
    }

    /**
     * Gets the classifier guid.
     * 
     * @return the classifier guid
     */
    public String getClassifierGuid() {
        return classifierGuid;
    }

    /**
     * Sets the classifier guid.
     * 
     * @param classifierGuid
     *            the new classifier guid
     */
    public void setClassifierGuid(String classifierGuid) {
        this.classifierGuid = classifierGuid;
    }

    /**
     * Gets the complexity.
     * 
     * @return the complexity
     */
    public String getComplexity() {
        return complexity;
    }

    /**
     * Sets the complexity.
     * 
     * @param complexity
     *            the new complexity
     */
    public void setComplexity(String complexity) {
        this.complexity = complexity;
    }

    /**
     * Gets the concurrency.
     * 
     * @return the concurrency
     */
    public String getConcurrency() {
        return concurrency;
    }

    /**
     * Sets the concurrency.
     * 
     * @param concurrency
     *            the new concurrency
     */
    public void setConcurrency(String concurrency) {
        this.concurrency = concurrency;
    }

    /**
     * {@inheritDoc}
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
     * Gets the effort.
     * 
     * @return the effort
     */
    public BigDecimal getEffort() {
        return effort;
    }

    /**
     * Sets the effort.
     * 
     * @param effort
     *            the new effort
     */
    public void setEffort(BigDecimal effort) {
        this.effort = effort;
    }

    /**
     * Gets the eventflags.
     * 
     * @return the eventflags
     */
    public String getEventflags() {
        return eventflags;
    }

    /**
     * Sets the eventflags.
     * 
     * @param eventflags
     *            the new eventflags
     */
    public void setEventflags(String eventflags) {
        this.eventflags = eventflags;
    }

    /**
     * Gets the fontcolor.
     * 
     * @return the fontcolor
     */
    public BigDecimal getFontcolor() {
        return fontcolor;
    }

    /**
     * Sets the fontcolor.
     * 
     * @param fontcolor
     *            the new fontcolor
     */
    public void setFontcolor(BigDecimal fontcolor) {
        this.fontcolor = fontcolor;
    }

    /**
     * Gets the genfile.
     * 
     * @return the genfile
     */
    public String getGenfile() {
        return genfile;
    }

    /**
     * Sets the genfile.
     * 
     * @param genfile
     *            the new genfile
     */
    public void setGenfile(String genfile) {
        this.genfile = genfile;
    }

    /**
     * Gets the genlinks.
     * 
     * @return the genlinks
     */
    public String getGenlinks() {
        return genlinks;
    }

    /**
     * Sets the genlinks.
     * 
     * @param genlinks
     *            the new genlinks
     */
    public void setGenlinks(String genlinks) {
        this.genlinks = genlinks;
    }

    /**
     * Gets the genoption.
     * 
     * @return the genoption
     */
    public String getGenoption() {
        return genoption;
    }

    /**
     * Sets the genoption.
     * 
     * @param genoption
     *            the new genoption
     */
    public void setGenoption(String genoption) {
        this.genoption = genoption;
    }

    /**
     * Gets the gentype.
     * 
     * @return the gentype
     */
    public String getGentype() {
        return gentype;
    }

    /**
     * Sets the gentype.
     * 
     * @param gentype
     *            the new gentype
     */
    public void setGentype(String gentype) {
        this.gentype = gentype;
    }

    /**
     * Gets the header1.
     * 
     * @return the header1
     */
    public String getHeader1() {
        return header1;
    }

    /**
     * Sets the header1.
     * 
     * @param header1
     *            the new header1
     */
    public void setHeader1(String header1) {
        this.header1 = header1;
    }

    /**
     * Gets the header2.
     * 
     * @return the header2
     */
    public String getHeader2() {
        return header2;
    }

    /**
     * Sets the header2.
     * 
     * @param header2
     *            the new header2
     */
    public void setHeader2(String header2) {
        this.header2 = header2;
    }

    /**
     * Gets the isactive.
     * 
     * @return the isactive
     */
    public int getIsactive() {
        return isactive;
    }

    /**
     * Sets the isactive.
     * 
     * @param isactive
     *            the new isactive
     */
    public void setIsactive(int isactive) {
        this.isactive = isactive;
    }

    /**
     * Gets the isleaf.
     * 
     * @return the isleaf
     */
    public int getIsleaf() {
        return isleaf;
    }

    /**
     * Sets the isleaf.
     * 
     * @param isleaf
     *            the new isleaf
     */
    public void setIsleaf(int isleaf) {
        this.isleaf = isleaf;
    }

    /**
     * Gets the isroot.
     * 
     * @return the isroot
     */
    public int getIsroot() {
        return isroot;
    }

    /**
     * Sets the isroot.
     * 
     * @param isroot
     *            the new isroot
     */
    public void setIsroot(int isroot) {
        this.isroot = isroot;
    }

    /**
     * Gets the isspec.
     * 
     * @return the isspec
     */
    public int getIsspec() {
        return isspec;
    }

    /**
     * Sets the isspec.
     * 
     * @param isspec
     *            the new isspec
     */
    public void setIsspec(int isspec) {
        this.isspec = isspec;
    }

    /**
     * {@inheritDoc}
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
     * Gets the multiplicity.
     * 
     * @return the multiplicity
     */
    public String getMultiplicity() {
        return multiplicity;
    }

    /**
     * Sets the multiplicity.
     * 
     * @param multiplicity
     *            the new multiplicity
     */
    public void setMultiplicity(String multiplicity) {
        this.multiplicity = multiplicity;
    }

    /**
     * Gets the packageflags.
     * 
     * @return the packageflags
     */
    public String getPackageflags() {
        return packageflags;
    }

    /**
     * Sets the packageflags.
     * 
     * @param packageflags
     *            the new packageflags
     */
    public void setPackageflags(String packageflags) {
        this.packageflags = packageflags;
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
     * Gets the pdata3.
     * 
     * @return the pdata3
     */
    public String getPdata3() {
        return pdata3;
    }

    /**
     * Sets the pdata3.
     * 
     * @param pdata3
     *            the new pdata3
     */
    public void setPdata3(String pdata3) {
        this.pdata3 = pdata3;
    }

    /**
     * Gets the pdata4.
     * 
     * @return the pdata4
     */
    public String getPdata4() {
        return pdata4;
    }

    /**
     * Sets the pdata4.
     * 
     * @param pdata4
     *            the new pdata4
     */
    public void setPdata4(String pdata4) {
        this.pdata4 = pdata4;
    }

    /**
     * Gets the pdata5.
     * 
     * @return the pdata5
     */
    public String getPdata5() {
        return pdata5;
    }

    /**
     * Sets the pdata5.
     * 
     * @param pdata5
     *            the new pdata5
     */
    public void setPdata5(String pdata5) {
        this.pdata5 = pdata5;
    }

    /**
     * Gets the persistence.
     * 
     * @return the persistence
     */
    public String getPersistence() {
        return persistence;
    }

    /**
     * Sets the persistence.
     * 
     * @param persistence
     *            the new persistence
     */
    public void setPersistence(String persistence) {
        this.persistence = persistence;
    }

    /**
     * Gets the phase.
     * 
     * @return the phase
     */
    public String getPhase() {
        return phase;
    }

    /**
     * Sets the phase.
     * 
     * @param phase
     *            the new phase
     */
    public void setPhase(String phase) {
        this.phase = phase;
    }

    /**
     * Gets the runstate.
     * 
     * @return the runstate
     */
    public String getRunstate() {
        return runstate;
    }

    /**
     * Sets the runstate.
     * 
     * @param runstate
     *            the new runstate
     */
    public void setRunstate(String runstate) {
        this.runstate = runstate;
    }

    /**
     * Gets the scope.
     * 
     * @return the scope
     */
    public String getScope() {
        return scope;
    }

    /**
     * Sets the scope.
     * 
     * @param scope
     *            the new scope
     */
    public void setScope(String scope) {
        this.scope = scope;
    }

    /**
     * Gets the stateflags.
     * 
     * @return the stateflags
     */
    public String getStateflags() {
        return stateflags;
    }

    /**
     * Sets the stateflags.
     * 
     * @param stateflags
     *            the new stateflags
     */
    public void setStateflags(String stateflags) {
        this.stateflags = stateflags;
    }

    /**
     * Gets the status.
     * 
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status.
     * 
     * @param status
     *            the new status
     */
    public void setStatus(String status) {
        this.status = status;
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

    /**
     * Gets the styleex.
     * 
     * @return the styleex
     */
    public String getStyleex() {
        return styleex;
    }

    /**
     * Sets the styleex.
     * 
     * @param styleex
     *            the new styleex
     */
    public void setStyleex(String styleex) {
        this.styleex = styleex;
    }

    /**
     * Gets the tagged.
     * 
     * @return the tagged
     */
    public int getTagged() {
        return tagged;
    }

    /**
     * Sets the tagged.
     * 
     * @param tagged
     *            the new tagged
     */
    public void setTagged(int tagged) {
        this.tagged = tagged;
    }

    /**
     * Gets the tpos.
     * 
     * @return the tpos
     */
    public int getTpos() {
        return tpos;
    }

    /**
     * Sets the tpos.
     * 
     * @param tpos
     *            the new tpos
     */
    public void setTpos(int tpos) {
        this.tpos = tpos;
    }

    /**
     * Gets the version.
     * 
     * @return the version
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the version.
     * 
     * @param version
     *            the new version
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * Gets the visibility.
     * 
     * @return the visibility
     */
    public String getVisibility() {
        return visibility;
    }

    /**
     * Sets the visibility.
     * 
     * @param visibility
     *            the new visibility
     */
    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    /**
     * Gets the type.
     * 
     * @return the type
     */
    public String getType() {
        DiscriminatorValue val = this.getClass().getAnnotation(DiscriminatorValue.class);
        return val == null ? null : val.value();
    }

    /**
     * Gets the tagged values.
     * 
     * @return the tagged values
     */
    public List<EaTaggedValue> getTaggedValues() {
        return taggedValues;
    }

    /**
     * Sets the tagged values.
     * 
     * @param taggedValues
     *            the new tagged values
     */
    public void setTaggedValues(List<EaTaggedValue> taggedValues) {
        this.taggedValues = taggedValues;
    }

    /**
     * Adds the tagged value.
     * 
     * @param tv
     *            the tv
     */
    public void addTaggedValue(EaTaggedValue tv) {
        taggedValues.add(tv);
        if (tv.getEaObject() != this) {
            tv.setEaObject(this);
        }
    }

    /**
     * Gets the full name.
     * 
     * @return the full name
     */
    @Transient
    public String getFullName() {
        StringBuilder name = new StringBuilder();

        if (getStereotype() != null) {
            name.append("<<").append(getStereotype()).append(">>");
        }
        if (getName() != null) {
            name.append(getName());
        }
        if (getStereotype() != null) {
            name.append(":");
            name.append(getClassifier().getName()).append(" ");
        }
        return name.toString();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.cgi.tools.eaconnector.bo.AbstractEaObject#save()
     */
    /**
     * {@inheritDoc}
     */
    @Override
    public void save() {
        if (guid == null) {
            guid = "{" + UUID.randomUUID().toString() + "}";
        }
        modifieddate = Calendar.getInstance().getTime();
    }


    /**
     * Checks for classifier.
     * 
     * @return true, if successful
     */
    @Transient
    public boolean hasClassifier() {
        try {
            getClassifier().getId();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.cgi.tools.eaconnector.bo.TaggedEaObject#getTextForTagParse()
     */
    /**
     * {@inheritDoc}
     */
    @Override
    protected String getTextForTagParse() {
        return getNotes();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<AbstractEaObject> getChildren() {
        Set<AbstractEaObject> list = new HashSet<>();
        list.addAll(getObjects());
        list.addAll(getDiagrams());
        list.addAll(getAttributes());
        return list;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<AbstractEaObject> getChildren(boolean recursive) {
        Set<AbstractEaObject> list = new HashSet<>(getChildren());
        if (recursive) {
            for (AbstractEaObject o : getChildren()) {
                list.addAll(o.getChildren(recursive));
            }
        }
        return list;
    }

    public Set<EaDiagram> getDiagrams(boolean recursive) {
        return getDiagrams(recursive, 0, -1);
    }
    
    public Set<EaDiagram> getDiagrams(boolean recursive, int maxLevel) {
        return getDiagrams(recursive, 0, maxLevel);
    }
    /**
     * Gets the diagrams.
     * 
     * @param recursive
     *            the recursive
     * @return the diagrams
     */
    public Set<EaDiagram> getDiagrams(boolean recursive, int level, int maxlevel) {
        Set<EaDiagram> diagrams = getDiagrams();
        if (recursive  && (level < maxlevel || maxlevel == -1)) {
            for (EaObject o : getObjects()) {
                diagrams.addAll(o.getDiagrams(recursive, level +1, maxlevel));
            }
        }
        return diagrams;
    }

    /**
     * Gets the package id.
     * 
     * @return the package id
     */
    public Integer getPackageId() {
        return packageId;
    }

    /**
     * Sets the package id.
     * 
     * @param packageId
     *            the new package id
     */
    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }

}
