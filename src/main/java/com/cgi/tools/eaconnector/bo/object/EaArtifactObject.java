/**
 * 
 */
package com.cgi.tools.eaconnector.bo.object;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.cgi.tools.eaconnector.bo.EaObject;

/**
 * The Class EaArtifactObject.
 */
@Entity
@DiscriminatorValue(value="Artifact")
public class EaArtifactObject extends EaObject {
 
}
