/**
 * 
 */
package com.cgi.tools.eaconnector.bo.object;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.cgi.tools.eaconnector.bo.EaObject;

/**
 * The Class EaInteractionOccurrenceObject.
 */
@Entity
@DiscriminatorValue(value="InteractionOccurrence")
public class EaInteractionOccurrenceObject extends EaObject {
 
}
