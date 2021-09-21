/**
 * 
 */
package com.cgi.tools.eaconnector.bo.object;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.cgi.tools.eaconnector.bo.EaObject;

/**
 * The Class EaActorObject.
 */
@Entity
@DiscriminatorValue(value="Actor")
public class EaActorObject extends EaObject {
 
}
