/**
 * 
 */
package com.cgi.tools.eaconnector.bo.object;

import com.cgi.tools.eaconnector.bo.EaObject;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * The Class EaComponentObject.
 */
@Entity
@DiscriminatorValue(value="Collaboration")
public class EaCollaborationObject extends EaObject {
 
}
