/**
 * 
 */
package com.cgi.tools.eaconnector.bo.object;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.cgi.tools.eaconnector.bo.EaObject;

/**
 * The Class EaNoteObject.
 */
@Entity
@DiscriminatorValue(value="Note")
public class EaNoteObject extends EaObject {
 
}
