package com.cgi.tools.eaconnector.bo;

import javax.persistence.*;

@Entity
@Table(name = "t_objectconstraint")
public class EaObjectConstraint {

    @Id
    @Column(name = "OBJECT_ID")
    private int id;

}
