/**
 * 
 */
package com.cgi.tools.eaconnector.bo.object;

import com.cgi.tools.eaconnector.bo.EaObject;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * The Class EaRequirementObject.
 */
@Entity
@DiscriminatorValue(value="RequiredInterface")
public class EaRequiredInterfaceObject extends EaObject {
 
}
