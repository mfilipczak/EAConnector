/**
 * 
 */
package com.cgi.tools.eaconnector.bo.object;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.cgi.tools.eaconnector.bo.EaObject;

/**
 * The Class EaEventObject.
 */
@Entity
@DiscriminatorValue(value="Entity")
public class EaEntityObject extends EaObject {
 
}
