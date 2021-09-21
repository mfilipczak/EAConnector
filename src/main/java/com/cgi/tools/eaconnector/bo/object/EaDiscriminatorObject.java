/**
 * 
 */
package com.cgi.tools.eaconnector.bo.object;

import com.cgi.tools.eaconnector.bo.EaObject;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * The Class EaDecisionObject.
 */
@Entity
@DiscriminatorValue(value="Discriminator")
public class EaDiscriminatorObject extends EaObject {
 
}
