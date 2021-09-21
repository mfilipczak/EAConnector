/**
 * 
 */
package com.cgi.tools.eaconnector.bo.object;

import com.cgi.tools.eaconnector.bo.EaObject;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * The Class EaEventObject.
 */
@Entity
@DiscriminatorValue(value="Enumeration")
public class EaEnumerationObject extends EaObject {
 
}
