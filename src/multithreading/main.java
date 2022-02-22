package multithreading;

public class main {

    public static void main(String[] args) {
        for(int i=0; i<3; i++){
            String name = "thread"+i;

            //Running a thread which implements the Runnable interface
            ThreadUsingRunnable myThread = new ThreadUsingRunnable(name);
            Thread t = new Thread(myThread);
            t.start();

            //Running a thread which extends the Thread class
            ThreadUsingThreadClass t1 = new ThreadUsingThreadClass("Class"+name);
            t1.start();
        }
    }
}
