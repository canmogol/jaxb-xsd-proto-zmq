package com.fererlab.zmq;

import com.fererlab.model.FererlabModels;
import org.zeromq.ZMQ;

public class Publish {

    public static void main(String[] args) {
        Publish publish = new Publish();
        publish.start();
    }

    private void start() {
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket publisher = context.socket(ZMQ.PUB);
        publisher.bind("tcp://*:5560");

        FererlabModels.carBrand carBrand = FererlabModels.carBrand.carBrand_SAAB;
        FererlabModels.car car = FererlabModels.car.newBuilder()
                .setId(1)
                .setModel(1993)
                .setManufactureNumber(2131212)
                .setCarBrand(carBrand)
                .build();
        byte[] bytes = car.toByteArray();

        publisher.send(bytes);

        publisher.close();
        context.term();
    }

}
