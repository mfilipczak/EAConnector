/**
 * 
 */
package com.cgi.tools.eaconnector.bo.object;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.cgi.tools.eaconnector.bo.EaObject;

/**
 * The Class EaRequirementObject.
 */
@Entity
@DiscriminatorValue(value="Requirement")
public class EaRequirementObject extends EaObject {
 
}
