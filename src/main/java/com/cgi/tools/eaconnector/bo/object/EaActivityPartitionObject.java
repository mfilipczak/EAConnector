/**
 * 
 */
package com.cgi.tools.eaconnector.bo.object;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.cgi.tools.eaconnector.bo.EaObject;

/**
 * The Class EaActivityPartitionObject.
 */
@Entity
@DiscriminatorValue(value="ActivityPartition")
public class EaActivityPartitionObject extends EaObject {
 
}
