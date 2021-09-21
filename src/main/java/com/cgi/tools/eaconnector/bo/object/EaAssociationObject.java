/**
 * 
 */
package com.cgi.tools.eaconnector.bo.object;

import com.cgi.tools.eaconnector.bo.EaObject;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * The Class EaArtifactObject.
 */
@Entity
@DiscriminatorValue(value="Association")
public class EaAssociationObject extends EaObject {
 
}
