package com.fererlab.zmq;

import com.fererlab.converter.ModelConverter;
import com.fererlab.model.Car;
import com.fererlab.model.CarBrand;
import org.zeromq.ZMQ;

import java.util.Date;

public class Server implements Runnable {

    @Override
    public void run() {

        // create zmq context
        ZMQ.Context context = ZMQ.context(1);
        // create socket and bind to it, Server is stable part of the system
        ZMQ.Socket responder = context.socket(ZMQ.REP);
        responder.bind("tcp://*:5555");

        // create a Car model to simulate DB or WS
        Car car = new Car();
        car.setId(new Integer(12)/*unnecessary boxing for compiler*/);
        car.setVersion(32l);
        car.setModel(new Date());
        car.setManufactureNumber(123l);
        car.setCarBrand(CarBrand.E1_VOLVO);

        // convert model object to byte[]
        ModelConverter modelConverter = new ModelConverter();
        byte[] bytes = modelConverter.convert(car);

        // continue until interrupt
        while (!Thread.currentThread().isInterrupted()) {
            // wait for next client to send a request
            byte[] request = responder.recv(0);
            System.out.println("received #bytes: " + request.length);

            // send OK to client
            responder.send(bytes);
            System.out.println("sent #bytes: " + bytes.length);
        }

        // close and terminate
        responder.close();
        context.term();
    }

}
