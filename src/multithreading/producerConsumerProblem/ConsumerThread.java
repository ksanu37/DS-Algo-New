package multithreading.producerConsumerProblem;

import javax.swing.plaf.TableHeaderUI;

public class ConsumerThread extends Thread {

    private Company comp;

    public ConsumerThread(Company c){
        comp = c;
    }

    public void run() {
        while(true) {
            try {
                comp.consume_item();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            try {
//                Thread.sleep(500);
//            } catch (Exception e) {
//
//            }
        }
    }
}
