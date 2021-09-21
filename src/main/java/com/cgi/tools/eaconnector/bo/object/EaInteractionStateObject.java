/**
 * 
 */
package com.cgi.tools.eaconnector.bo.object;

import com.cgi.tools.eaconnector.bo.EaObject;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * The Class EaActionObject.
 */
@Entity
@DiscriminatorValue(value="InteractionState")
public class EaInteractionStateObject extends EaObject {
 
}
