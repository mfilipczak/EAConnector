/**
 * 
 */
package com.cgi.tools.eaconnector.bo.object;

import java.util.List;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.cgi.tools.eaconnector.bo.EaDiagram;
import com.cgi.tools.eaconnector.bo.EaObject;
import com.cgi.tools.eaconnector.bo.EaPackage;

/**
 * The Class EaPackageObject.
 */
@Entity
@DiscriminatorValue(value="Package")
public class EaPackageObject extends EaObject {
    
    /** The ea package. */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="PDATA1")
    private EaPackage eaPackage;
    
    
    /**
     * Gets the ea package.
     * 
     * @return the ea package
     */
    public EaPackage getEaPackage() {
        return eaPackage;
    }

    /**
     * Sets the ea package.
     * 
     * @param eaPackage
     *            the new ea package
     */
    public void setEaPackage(EaPackage eaPackage) {
        this.eaPackage = eaPackage;
        if(eaPackage != null && eaPackage.getPackageObject() != this) {
            eaPackage.setPackageObject(this);
        }
    }

    @Override
    public Set<EaObject> getObjects() {
        return eaPackage.getObjects();
    }

    @Override
    public Set<EaDiagram> getDiagrams() {
        return eaPackage.getDiagrams();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
        if(!name.equals(eaPackage.getName())) {
            eaPackage.setName(name);
        }
    }
    @Override
    public void setGuid(String guid) {
        super.setGuid(guid);
        if(!guid.equals(eaPackage.getGuid())) {
            eaPackage.setGuid(guid);
        }
    }
    @Override
    public void setNotes(String notes) {
        super.setNotes(notes);
        if(!notes.equals(eaPackage.getNotes())) {
            eaPackage.setNotes(notes);
        }
    }
}
