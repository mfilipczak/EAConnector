/**
 * 
 */
package com.cgi.tools.eaconnector.bo.object;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.cgi.tools.eaconnector.bo.EaObject;

/**
 * The Class EaDecisionObject.
 */
@Entity
@DiscriminatorValue(value="Decision")
public class EaDecisionObject extends EaObject {
 
}
