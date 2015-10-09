package com.fererlab.zmq;

import com.fererlab.converter.ModelConverter;
import com.fererlab.model.Car;
import com.fererlab.model.FererlabModels;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.zeromq.ZMQ;

import java.util.Arrays;

public class Client implements Runnable {

    @Override
    public void run() {


        // create zmq context
        ZMQ.Context context = ZMQ.context(1);
        System.out.println("1");
        // create socket and connect to publisher
        ZMQ.Socket requester = context.socket(ZMQ.REQ);
        System.out.println("2");
        requester.connect("tcp://localhost:5555");
        System.out.println("3");

        // sent request
        requester.send("Hi!".getBytes());

        // read bytes of carPB
        byte[] bytes = requester.recv();

        System.out.println("received");
        if (bytes != null && bytes.length > 0) {
            System.out.println("---> #bytes: " + bytes.length);
            System.out.println("---> bytes: " + Arrays.toString(bytes));
            // convert bytes to carPB
            try {
                FererlabModels.car carPB = FererlabModels.car.parseFrom(bytes);
                ModelConverter modelConverter = new ModelConverter();
                Car carModel = modelConverter.convert(carPB);
                System.out.println(ToStringBuilder.reflectionToString(carModel));
            } catch (Exception e) {
                System.out.println("exception e: " + e.getMessage());
            }
        }

        requester.close();
        context.term();
    }

}
