package com.cgi.tools.eaconnector.bo;

import javax.persistence.*;

@Entity
@Table(name = "t_connectorconstraint")
public class EaConnectorConstraint {

    @Id
    @Column(name = "CONNECTORID")
    private int id;

    /** The diagram. */
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="CONNECTORID", insertable=false, updatable=false)
    private EaConnector connector;


    /**
     * Gets the diagram.
     *
     * @return the diagram
     */

    public EaConnector getConnector() {
        return connector;
    }
}
