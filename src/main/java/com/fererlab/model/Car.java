package com.fererlab.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Entity
@Table(name = "T_CAR")
@XmlRootElement
public class Car extends BaseModelID<Integer> {

    private static final long serialVersionUID = -4713218049107541637L;

    private CarBrand carBrand;
    private Date model;
    private Long manufactureNumber;

    public Car() {
    }

    public Car(CarBrand carBrand, Date model, Long manufactureNumber) {
        this.carBrand = carBrand;
        this.model = model;
        this.manufactureNumber = manufactureNumber;
    }

    @Enumerated(EnumType.STRING)
    public CarBrand getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(CarBrand carBrand) {
        this.carBrand = carBrand;
    }

    public Date getModel() {
        return model;
    }

    public void setModel(Date model) {
        this.model = model;
    }

    public Long getManufactureNumber() {
        return manufactureNumber;
    }

    public void setManufactureNumber(Long manufactureNumber) {
        this.manufactureNumber = manufactureNumber;
    }
}
