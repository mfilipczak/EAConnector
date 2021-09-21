/**
 * 
 */
package com.cgi.tools.eaconnector.bo.object;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.cgi.tools.eaconnector.bo.EaObject;

/**
 * The Class EaMessageEndpointObject.
 */
@Entity
@DiscriminatorValue(value="MessageEndpoint")
public class EaMessageEndpointObject extends EaObject {
 
}
