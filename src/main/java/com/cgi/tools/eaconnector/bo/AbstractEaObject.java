/**
 * 
 */
package com.cgi.tools.eaconnector.bo;

import java.io.Serializable;
import java.util.*;

/**
 * The Class AbstractEaObject.
 */
public abstract class AbstractEaObject implements Serializable{
    
    /**
     * Save.
     */
    public void save() {}
    
    /**
     * Gets the parent.
     * 
     * @return the parent
     */
    public AbstractEaObject getParent() {
        return null;
    }
    
    /**
     * Gets the name.
     * 
     * @return the name
     */
    public String getName() {
        return null;
    }
    /**
     * Gets the guid.
     * 
     * @return the guid
     */
    public String getGuid() {
        return null;
    }
    
    public Set<AbstractEaObject> getChildren() {
        return new HashSet<>();
    }
    
    public Set<AbstractEaObject> getChildren(boolean recursive) {
        return new HashSet<>();
    }

	public Date getCreateddate() {
		return null;
	}

	public Date getModifieddate() {
		return null;
	}

	@Override
	public String toString() {
		return "AbstractEaObject [getName()=" + getName() + ", getGuid()="
				+ getGuid() + ", getCreateddate()=" + getCreateddate()
				+ ", getModifieddate()=" + getModifieddate() + "]";
	}
	
}
