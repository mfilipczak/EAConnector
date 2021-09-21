/**
 * 
 */
package com.cgi.tools.eaconnector.bo.object;

import com.cgi.tools.eaconnector.bo.EaObject;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * The Class EaExpansionRegionObject.
 */
@Entity
@DiscriminatorValue(value="ExpansionNode")
public class EaExpansionNodeObject extends EaObject {
 
}
