/**
 * 
 */
package com.cgi.tools.eaconnector.bo.object;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.cgi.tools.eaconnector.bo.EaObject;

/**
 * The Class EaMergeNodeObject.
 */
@Entity
@DiscriminatorValue(value="MergeNode")
public class EaMergeNodeObject extends EaObject {
 
}
