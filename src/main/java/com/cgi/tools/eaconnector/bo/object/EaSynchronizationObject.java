/**
 * 
 */
package com.cgi.tools.eaconnector.bo.object;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.cgi.tools.eaconnector.bo.EaObject;

/**
 * The Class EaSynchronizationObject.
 */
@Entity
@DiscriminatorValue(value="Synchronization")
public class EaSynchronizationObject extends EaObject {
 
}
