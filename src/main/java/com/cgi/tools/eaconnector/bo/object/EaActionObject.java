/**
 * 
 */
package com.cgi.tools.eaconnector.bo.object;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.cgi.tools.eaconnector.bo.EaObject;

/**
 * The Class EaActionObject.
 */
@Entity
@DiscriminatorValue(value="Action")
public class EaActionObject extends EaObject {
 
}
