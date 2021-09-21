/**
 * 
 */
package com.cgi.tools.eaconnector.bo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.*;

import com.cgi.tools.eaconnector.bo.object.EaPackageObject;

/**
 * The Class EaPackage.
 */
@Entity
@Table(name = "t_package")
public class EaPackage extends TaggedEaObject {

    /** The package id. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "PACKAGE_ID_SEQ")
    @SequenceGenerator(name = "PACKAGE_ID_SEQ", sequenceName = "PACKAGE_ID_SEQ", allocationSize = 1)
    @Column(name = "PACKAGE_ID")
    private int packageId;

    /** The name. */
    private String name;

    /** The guid. */
    @Column(name = "EA_GUID")
    private String guid;

    /** The notes. */
    @Lob
    @Column(name = "NOTES")
    @Basic(fetch = FetchType.LAZY)
    private String notes;

    /** The parent id. */
    @Column(name = "PARENT_ID", insertable = false, updatable = false)
    private int parentId;

    /** The objects. */
    @OneToMany(mappedBy = "parentPackage", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<EaObject> objects;

    /** The diagrams. */
    @OneToMany(mappedBy = "parentPackage", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<EaDiagram> diagrams;

    /** The parent. */
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID", nullable = true)
    private EaPackage parent;

    /** The package object. */
    @OneToOne(optional = false, cascade = CascadeType.ALL, mappedBy = "eaPackage", orphanRemoval = true, fetch = FetchType.LAZY)
    private EaPackageObject packageObject;

    /** The packages. */
    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<EaPackage> packages;

    /** The modifieddate. */
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifieddate;

    /** The createddate. */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(insertable = false, updatable = false)
    private Date createddate;

    public EaPackage() {
        packageObject = new EaPackageObject();
        packageObject.setEaPackage(this);
    }
    
    /**
     * {@inheritDoc}
     */
    public Date getModifieddate() {
        return modifieddate;
    }

    /**
     * {@inheritDoc}
     */
    public Date getCreateddate() {
        return createddate;
    }

    /**
     * Gets the package id.
     * 
     * @return the package id
     */
    public int getPackageId() {
        return packageId;
    }

    /**
     * Sets the package id.
     * 
     * @param packageId
     *            the new package id
     */
    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

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
        if(!name.equals(packageObject.getName())) {
            packageObject.setName(name);
        }
    }

    /**
     * Gets the objects.
     * 
     * @return the objects
     */
    public Set<EaObject> getObjects() {
        Set<EaObject> list = new HashSet<>();
        for(EaObject o : objects) {
          //  if(!(o instanceof EaPackageObject)) {
                list.add(o);
           // }
        }
        return list;
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
     * Gets the parent id.
     * 
     * @return the parent id
     */
    public int getParentId() {
        return parentId;
    }

    /**
     * Sets the parent id.
     * 
     * @param parentId
     *            the new parent id
     */
    public void setParentId(int parentId) {
        this.parentId = parentId;
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
     * Gets the diagrams.
     * 
     * @param recursive
     *            the recursive
     * @return the diagrams
     */
    public List<EaDiagram> getDiagrams(boolean recursive) {
        return getDiagrams(recursive, 0, -1);
    }
    
    public List<EaDiagram> getDiagrams(boolean recursive, int maxLevel) {
        return getDiagrams(recursive, 0, maxLevel);
    }
    
    private List<EaDiagram> getDiagrams(boolean recursive, int level, int maxlevel) {
        Set<EaDiagram> d = new HashSet<EaDiagram>();
        d.addAll(getDiagrams());
        if (recursive && (level < maxlevel || maxlevel == -1)) {
            for (EaObject object : getObjects()) {
                d.addAll(object.getDiagrams(recursive, level + 1, maxlevel));
            }
            for (EaPackage pack : getPackages()) {
                d.addAll(pack.getDiagrams(recursive, level + 1, maxlevel));
            }
        }
        return new ArrayList<EaDiagram>(d);
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
        if(!notes.equals(packageObject.getNotes())) {
            packageObject.setNotes(notes);
        }
    }

    /**
     * {@inheritDoc}
     */
    public EaPackage getParent() {
        return parent;
    }

    /**
     * Sets the parent.
     * 
     * @param parent
     *            the new parent
     */
    public void setParent(EaPackage parent) {
        this.parent = parent;
        this.setParentId(parent.getPackageId());
        packageObject.setParentPackage(parent);
    }

    /**
     * Gets the packages.
     * 
     * @return the packages
     */
    public Set<EaPackage> getPackages() {
        return packages;
    }

    /**
     * Sets the packages.
     * 
     * @param packages
     *            the new packages
     */
    public void setPackages(Set<EaPackage> packages) {
        this.packages = packages;
    }

    /**
     * Gets the packages.
     * 
     * @param recursive
     *            the recursive
     * @return the packages
     */
    public List<EaPackage> getPackages(boolean recursive) {
        List<EaPackage> list = new ArrayList<EaPackage>();
        list.addAll(getPackages());
        if (recursive) {
            for (EaPackage pac : getPackages()) {
                list.addAll(pac.getPackages(recursive));
            }
        }
        return list;
    }

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
        for (EaObject o : objects) {
            //if (o.getParent() instanceof EaPackage) {
                list.add(o);
            //}
        }
        for (EaDiagram d : diagrams) {
            //if (d.getParent() instanceof EaPackage) {
            	list.add(d);
           // }
        }
        list.addAll(getPackages());
        return list;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<AbstractEaObject> getChildren(boolean recursive) {
    	Set<AbstractEaObject> list = new HashSet<>();
    	if(recursive)
    	{
    		list.addAll(getObjects());
    		list.addAll(getDiagrams());
    		for (EaPackage eaPackage : getPackages()) {
    			list.add(eaPackage);
				list.addAll(eaPackage.getChildren(recursive));
			}
    	}
    	else{
    		list = this.getChildren();
    	}
    	return list;
    }

    /**
     * {@inheritDoc}
     */
    @Override
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
        if(!guid.equals(packageObject.getGuid())) {
            packageObject.setGuid(guid);
        }
    }

    /**
     * Gets the package object.
     * 
     * @return the package object
     */
    public EaPackageObject getPackageObject() {
        return packageObject;
    }

    /**
     * Sets the package object.
     * 
     * @param packageObject
     *            the new package object
     */
    public void setPackageObject(EaPackageObject packageObject) {
        this.packageObject = packageObject;
        if(packageObject != null && packageObject.getEaPackage() != this) {
            packageObject.setEaPackage(this);
        }
    }

    @Override
    public void save() {
        if (guid == null) {
            guid = "{" + UUID.randomUUID().toString() + "}";
        }
        modifieddate = Calendar.getInstance().getTime();
        packageObject.setGuid(guid);
        packageObject.setModifieddate(modifieddate);
    }

    
}
