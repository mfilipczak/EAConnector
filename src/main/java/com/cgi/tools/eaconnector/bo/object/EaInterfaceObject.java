/**
 * 
 */
package com.cgi.tools.eaconnector.bo.object;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.cgi.tools.eaconnector.bo.EaObject;

/**
 * The Class EaInterfaceObject.
 */
@Entity
@DiscriminatorValue(value="Interface")
public class EaInterfaceObject extends EaObject {
 
}
