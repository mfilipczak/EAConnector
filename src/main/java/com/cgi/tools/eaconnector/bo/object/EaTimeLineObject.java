/**
 * 
 */
package com.cgi.tools.eaconnector.bo.object;

import com.cgi.tools.eaconnector.bo.EaObject;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * The Class EaTextObject.
 */
@Entity
@DiscriminatorValue(value="TimeLine")
public class EaTimeLineObject extends EaObject {
 
}
