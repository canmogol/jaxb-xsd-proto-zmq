package com.fererlab.converter;

import com.fererlab.model.Car;
import com.fererlab.model.CarBrand;
import com.fererlab.model.FererlabModels;
import com.google.protobuf.Descriptors;

import java.util.Date;

public class ModelConverter {


    public byte[] convert(Car carModel) {
        // create a car model, set fields
        FererlabModels.carBrand carBrand = covert(carModel.getCarBrand());
        FererlabModels.car carProtoBuffer = FererlabModels.car.newBuilder()
                .setId(carModel.getId())
                .setModel(carModel.getManufactureNumber())
                .setManufactureNumber(carModel.getManufactureNumber())
                .setCarBrand(carBrand)
                .build();
        return carProtoBuffer.toByteArray();
    }

    private FererlabModels.carBrand covert(CarBrand carBrand) {
        for (Descriptors.EnumValueDescriptor descriptor : FererlabModels.carBrand.getDescriptor().getValues()) {
            if (descriptor.getIndex() == carBrand.getIndex()) {
                return FererlabModels.carBrand.valueOf(descriptor);
            }
        }
        return null;
    }

    public Car convert(FererlabModels.car carPB) {
        Car car = new Car();
        car.setCarBrand(convert(carPB.getCarBrand()));
        car.setManufactureNumber(carPB.getManufactureNumber());
        car.setModel(new Date(carPB.getModel()));
        car.setId(Integer.valueOf(carPB.getId()/*unnecessary boxing for compiler*/));
        car.setVersion(carPB.getVersion());
        return car;
    }

    private CarBrand convert(FererlabModels.carBrand carBrand) {
        for(CarBrand carB : CarBrand.values()){
            if(carB.getIndex() == carBrand.getDescriptorForType().getIndex()){
                return carB;
            }
        }
        return null;
    }
}
