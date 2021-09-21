/**
 * 
 */
package com.cgi.tools.eaconnector.bo.object;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.cgi.tools.eaconnector.bo.EaObject;

/**
 * The Class EaPortObject.
 */
@Entity
@DiscriminatorValue(value="State")
public class EaStateObject extends EaObject {
 
}
