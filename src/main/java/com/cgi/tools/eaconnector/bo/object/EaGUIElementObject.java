/**
 * 
 */
package com.cgi.tools.eaconnector.bo.object;

import com.cgi.tools.eaconnector.bo.EaObject;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * The Class EaClassObject.
 */
@Entity
@DiscriminatorValue(value="GUIElement")
public class EaGUIElementObject extends EaObject {
 
}
