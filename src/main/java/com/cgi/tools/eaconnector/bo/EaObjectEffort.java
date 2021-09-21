package com.cgi.tools.eaconnector.bo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "t_objecteffort")
@Setter
@Getter
public class EaObjectEffort {
    @Id
    @Column(name = "OBJECT_ID")
    private int id;

    /** The object id. */
    @Column(name = "OBJECT_ID", insertable = false, updatable = false)
    private int objectId;
}
