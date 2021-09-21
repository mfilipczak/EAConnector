/**
 * 
 */
package com.cgi.tools.eaconnector.bo;

import javax.persistence.Transient;

// TODO: Auto-generated Javadoc
/**
 * The Class TaggedEaObject.
 */
public abstract class TaggedEaObject extends AbstractEaObject {
    
    /** The tags. */
    protected EaTags tags;

    /**
     * Gets the tags.
     * 
     * @return the tags
     */
    @Transient
    public EaTags getTags() {
        if (tags == null) {
            parseTags();
        }
        return tags;
    }

    /**
     * Parses the tags.
     */
    protected void parseTags() {
        tags = new EaTags(getTextForTagParse());
    }

    /**
     * Gets the text for tag parse.
     * 
     * @return the text for tag parse
     */
    protected abstract String getTextForTagParse();
}
