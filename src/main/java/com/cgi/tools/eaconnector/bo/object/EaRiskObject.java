/**
 * 
 */
package com.cgi.tools.eaconnector.bo.object;

import com.cgi.tools.eaconnector.bo.EaObject;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * The Class EaPortObject.
 */
@Entity
@DiscriminatorValue(value="Risk")
public class EaRiskObject extends EaObject {
 
}
