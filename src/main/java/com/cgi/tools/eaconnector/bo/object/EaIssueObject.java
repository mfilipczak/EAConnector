/**
 * 
 */
package com.cgi.tools.eaconnector.bo.object;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.cgi.tools.eaconnector.bo.EaObject;

/**
 * The Class EaIssueObject.
 */
@Entity
@DiscriminatorValue(value="Issue")
public class EaIssueObject extends EaObject {
 
}
