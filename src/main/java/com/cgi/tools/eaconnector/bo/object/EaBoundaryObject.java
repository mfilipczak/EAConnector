/**
 * 
 */
package com.cgi.tools.eaconnector.bo.object;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.cgi.tools.eaconnector.bo.EaObject;

/**
 * The Class EaBoundaryObject.
 */
@Entity
@DiscriminatorValue(value="Boundary")
public class EaBoundaryObject extends EaObject {
 
}
