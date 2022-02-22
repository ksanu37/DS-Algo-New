package multithreading;

public class ThreadUsingRunnable implements Runnable {

    private String threadName;

    public ThreadUsingRunnable(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        System.out.println(threadName+ " started at " + System.currentTimeMillis());
        printNumbers();
        System.out.println(threadName+ " ends at " + System.currentTimeMillis());
    }

    public void printNumbers(){
        for(int i=0; i<5; i++){
            System.out.println(threadName + ": " + i);
            try {
                Thread.sleep(1000);
            } catch (Exception e){

            }
        }
    }
}
