/**
 * 
 */
package com.cgi.tools.eaconnector.bo.object;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.cgi.tools.eaconnector.bo.EaObject;

/**
 * The Class EaObjectObject.
 */
@Entity
@DiscriminatorValue(value="Object")
public class EaObjectObject extends EaObject {
 
}
