package multithreading.producerConsumerProblem;

public class Driver {

    public static void main(String[] args) {
        Company comp = new Company();
        ProducerThread prodThread = new ProducerThread(comp);
        ConsumerThread consumerThread = new ConsumerThread(comp);
        prodThread.start();
        consumerThread.start();
    }
}
