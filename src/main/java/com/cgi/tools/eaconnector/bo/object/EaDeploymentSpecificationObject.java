/**
 * 
 */
package com.cgi.tools.eaconnector.bo.object;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.cgi.tools.eaconnector.bo.EaObject;

/**
 * The Class EaDeploymentSpecificationObject.
 */
@Entity
@DiscriminatorValue(value="DeploymentSpecification")
public class EaDeploymentSpecificationObject extends EaObject {
 
}
