package com.fererlab.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Entity
@Table(name = "T_USER")
@XmlRootElement
public class User extends BaseModelID<Integer> {

    private static final long serialVersionUID = -3050185694189213162L;

    private String username;

    private List<Address> addressList;

    public User() {
    }

    public User(String username, List<Address> addressList) {
        this.username = username;
        this.addressList = addressList;
    }

    @Column(name = "F_USERNAME", length = 100)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }
}