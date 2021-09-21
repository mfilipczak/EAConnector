/**
 * 
 */
package com.cgi.tools.eaconnector.bo.object;

import com.cgi.tools.eaconnector.bo.EaObject;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * The Class EaActivityPartitionObject.
 */
@Entity
@DiscriminatorValue(value="ActivityParameter")
public class EaActivityParameterObject extends EaObject {
 
}
