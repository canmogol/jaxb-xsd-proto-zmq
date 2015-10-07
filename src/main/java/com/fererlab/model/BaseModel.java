package com.fererlab.model;


import java.io.Serializable;

public interface BaseModel<T> extends Serializable {

    T getId();

    void setId(T t);

}
