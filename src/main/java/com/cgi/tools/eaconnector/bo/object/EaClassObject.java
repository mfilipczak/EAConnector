/**
 * 
 */
package com.cgi.tools.eaconnector.bo.object;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.cgi.tools.eaconnector.bo.EaObject;

/**
 * The Class EaClassObject.
 */
@Entity
@DiscriminatorValue(value="Class")
public class EaClassObject extends EaObject {
 
}
