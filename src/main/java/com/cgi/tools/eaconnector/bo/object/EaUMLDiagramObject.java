/**
 * 
 */
package com.cgi.tools.eaconnector.bo.object;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.cgi.tools.eaconnector.bo.EaObject;

/**
 * The Class EaUMLDiagramObject.
 */
@Entity
@DiscriminatorValue(value="UMLDiagram")
public class EaUMLDiagramObject extends EaObject {
 
}
