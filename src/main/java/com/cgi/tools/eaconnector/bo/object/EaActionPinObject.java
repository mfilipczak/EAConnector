/**
 * 
 */
package com.cgi.tools.eaconnector.bo.object;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.cgi.tools.eaconnector.bo.EaObject;

/**
 * The Class EaActionPinObject.
 */
@Entity
@DiscriminatorValue(value="ActionPin")
public class EaActionPinObject extends EaObject {
 
}
