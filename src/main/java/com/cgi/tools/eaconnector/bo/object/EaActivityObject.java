/**
 * 
 */
package com.cgi.tools.eaconnector.bo.object;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.cgi.tools.eaconnector.bo.EaObject;

/**
 * The Class EaActivityObject.
 */
@Entity
@DiscriminatorValue(value="Activity")
public class EaActivityObject extends EaObject {
 
}
