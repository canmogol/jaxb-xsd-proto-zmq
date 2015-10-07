package com.fererlab.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@MappedSuperclass
public abstract class BaseModelID<T extends Integer> implements BaseModel<T> {

    private static final long serialVersionUID = 795503695556010727L;

    private T t;

    private Long version = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "BM_SEQ")
    @SequenceGenerator(name = "BM_SEQ", sequenceName = "BM_SEQ", allocationSize = 1)
    @Column(name = "BM_ID", updatable = false, nullable = false)
    public T getId() {
        return t;
    }

    public void setId(T t) {
        this.t = t;
    }

    @Version
    @Column(name = "BM_VERSION", nullable = false)
    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

}