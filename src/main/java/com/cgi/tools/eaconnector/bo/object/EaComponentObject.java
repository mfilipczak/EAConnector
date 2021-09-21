/**
 * 
 */
package com.cgi.tools.eaconnector.bo.object;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.cgi.tools.eaconnector.bo.EaObject;

/**
 * The Class EaComponentObject.
 */
@Entity
@DiscriminatorValue(value="Component")
public class EaComponentObject extends EaObject {
 
}
