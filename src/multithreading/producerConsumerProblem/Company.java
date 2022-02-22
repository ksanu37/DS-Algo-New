package multithreading.producerConsumerProblem;

public class Company {

    private int num;
    private boolean isProduced = false;// flag to see the current status of num, if false : consumed, producer can go ahead
                                        // If true, produced, consumer can go ahead.

    synchronized public void produce_item(int n) throws InterruptedException {
        if(isProduced){
            wait(); // wait till it is not consumed
        }

        num = n;
        System.out.println("produced: " + num);
        isProduced = true;
        notify();
    }

    synchronized public void consume_item() throws InterruptedException {
        if(!isProduced){
            wait();  // wait till it is not produced.
        }
        System.out.println("consumed: " + num);
        isProduced = false;
        notify();
    }
}
