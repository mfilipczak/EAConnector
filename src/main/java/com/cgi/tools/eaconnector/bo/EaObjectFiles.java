package com.cgi.tools.eaconnector.bo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_objectfiles")
@Getter
@Setter
public class EaObjectFiles {
    @Id
    @Column(name = "OBJECT_ID")
    private int id;

    /** The object id. */
    @Column(name = "OBJECT_ID", insertable = false, updatable = false)
    private int objectId;
}
