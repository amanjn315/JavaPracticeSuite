package main.java.modules.multithreading;

/**
 * @author amanjain
 **/
public class SharedCounter {
    private int count = 0;

    public synchronized void increment(){
        count++;
    }

    public int getCount(){
        return count;
    }
}
