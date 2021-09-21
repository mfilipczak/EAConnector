package com.cgi.tools.eaconnector.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_objectproperties")
public class EaObjectProperties {
    @Id
    @Column(name = "OBJECT_ID")
    private int id;
}
