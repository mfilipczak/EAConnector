/**
 * 
 */
package com.cgi.tools.eaconnector.bo.object;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.cgi.tools.eaconnector.bo.EaObject;

/**
 * The Class EaSequenceObject.
 */
@Entity
@DiscriminatorValue(value="Sequence")
public class EaSequenceObject extends EaObject {
 
}
