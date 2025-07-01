package main.java.modules.multithreading;

/**
 * @author amanjain
 **/
public class RaceConditionDemo {
    public static void main(String[] args) throws InterruptedException {
        SharedCounter sharedCounter = new SharedCounter();
        Runnable r = () -> {
            for(int i = 0; i < 1000; i++){
                sharedCounter.increment();
            }
        };
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Final Count: " + sharedCounter.getCount());
    }
}
