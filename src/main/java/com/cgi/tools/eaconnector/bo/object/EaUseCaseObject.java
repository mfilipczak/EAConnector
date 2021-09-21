/**
 * 
 */
package com.cgi.tools.eaconnector.bo.object;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.cgi.tools.eaconnector.bo.EaObject;

/**
 * The Class EaUseCaseObject.
 */
@Entity
@DiscriminatorValue(value="UseCase")
public class EaUseCaseObject extends EaObject {
 
}
