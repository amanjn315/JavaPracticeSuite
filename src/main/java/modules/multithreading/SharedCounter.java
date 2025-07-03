package main.java.modules.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author amanjain
 **/
public class SharedCounter {
    private AtomicInteger count = new AtomicInteger(0);

    public synchronized void increment(){
        count.incrementAndGet();
    }

    public int getCount(){
        return count.get();
    }
}
