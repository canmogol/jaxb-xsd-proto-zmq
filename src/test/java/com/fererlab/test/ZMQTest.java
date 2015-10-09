package com.fererlab.test;

import com.fererlab.zmq.Client;
import com.fererlab.zmq.Server;

public class ZMQTest {


    public static void main(String[] args) {
        ZMQTest zmqTest = new ZMQTest();
        zmqTest.runTests();
    }

    private void runTests() {
        try {
            testZMQ();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testZMQ() throws Exception {
        // create and submit server
        Server server = new Server();
        new Thread(server).start();

        // create and submit client
        Client client = new Client();
        new Thread(client).start();
    }

}
