import org.zeromq.ZMQ;

public class psenvsub {
    public static void main(String[] args) {

        // Prepare our context and subscriber
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket subscriber = context.socket(ZMQ.SUB);

        subscriber.connect("tcp://localhost:5563");
        subscriber.subscribe("B".getBytes());
        while (!Thread.currentThread().isInterrupted()) {
            // Read envelope with address
            String address = new String(subscriber.recv());
            // Read message contents
            String contents = subscriber.recvStr();
            System.out.println(address + " : " + contents);
        }
        subscriber.close();
        context.term();
    }

}
