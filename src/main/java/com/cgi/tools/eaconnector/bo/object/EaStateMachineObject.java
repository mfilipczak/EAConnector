/**
 * 
 */
package com.cgi.tools.eaconnector.bo.object;

import com.cgi.tools.eaconnector.bo.EaObject;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * The Class EaNodeObject.
 */
@Entity
@DiscriminatorValue(value="StateMachine")
public class EaStateMachineObject extends EaObject {
 
}
