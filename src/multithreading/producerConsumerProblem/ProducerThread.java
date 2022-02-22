package multithreading.producerConsumerProblem;

public class ProducerThread extends Thread {

    private Company comp;

    public ProducerThread(Company c){
        comp = c;
    }

    public void run(){
        for(int i=0; i<50; i++){
            try {
                comp.produce_item(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
