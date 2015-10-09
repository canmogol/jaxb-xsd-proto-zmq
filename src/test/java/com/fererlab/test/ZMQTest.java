package com.fererlab.test;

import com.fererlab.zmq.Client;
import com.fererlab.zmq.Server;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ZMQTest {

    private ExecutorService executorService;

    public static void main(String[] args) {
        ZMQTest zmqTest = new ZMQTest();
        zmqTest.runTests();
    }

    public ZMQTest() {
        executorService = Executors.newFixedThreadPool(2);
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
        executorService.execute(server);

        // wait for a second before publishing car
        Thread.sleep(1000);

        // create and submit client
        Client client = new Client();
        executorService.execute(client);
    }

}
