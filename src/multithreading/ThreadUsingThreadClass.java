package multithreading;

import java.sql.SQLOutput;

public class ThreadUsingThreadClass extends Thread {

    private String threadName;

    public ThreadUsingThreadClass(String threadName) {
        this.threadName = threadName;
    }

    public void run(){
        System.out.println(threadName+ " started at " + System.currentTimeMillis());
        printNumbers();
        System.out.println(threadName+ " ends at " + System.currentTimeMillis());
    }

    public void printNumbers(){
        for(int i=0; i<5; i++){
            System.out.println(threadName + ": " + i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
