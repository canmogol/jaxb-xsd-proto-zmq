package com.fererlab.model;


import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "T_ADDRESS")
@XmlRootElement
public class Address extends BaseModelID<Integer> {

    private static final long serialVersionUID = -1802864421402080066L;

    private String street;
    private String city;
    private Integer postCode;
    private User user;

    public Address() {
        //Class t = Out.class;
        //generated.Out.car.getDefaultInstance();
    }

    public Address(String street, String city, Integer postCode, User user) {
        this.street = street;
        this.city = city;
        this.postCode = postCode;
        this.user = user;
    }

    @Column(name = "F_STREET", length = 200)
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Column(name = "F_CITY", length = 50)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "F_POST_CODE")
    public Integer getPostCode() {
        return postCode;
    }

    public void setPostCode(Integer postCode) {
        this.postCode = postCode;
    }

    @ManyToOne
    @JoinColumn(name = "F_USER_ID", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}