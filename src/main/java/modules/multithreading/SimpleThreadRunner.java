package main.java.modules.multithreading;

/**
 * @author amanjain
 **/
public class SimpleThreadRunner {
    public static void main(String[] args){
        Runnable r1 = () -> {
            for(int i = 0; i < 5; i++){
                System.out.println("Launching task A");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread t1 = new Thread(r1);
        Runnable r2 = () -> {
            for(int i = 0; i < 5; i++){
                System.out.println("Launching task B");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
    }
}
