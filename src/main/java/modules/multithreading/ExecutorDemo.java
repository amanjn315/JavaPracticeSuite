package main.java.modules.multithreading;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

import static java.lang.Thread.sleep;

/**
 * @author amanjain
 **/
public class ExecutorDemo {
    public static void main(String[] args){
        Runnable task = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " executing task");
                try {
                    sleep(300);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };
        Callable<Integer> sumTask = () -> IntStream.rangeClosed(1, 100).sum();
        Callable<Integer> multiplyTask = () -> IntStream.rangeClosed(1, 10).reduce(1, (a, b) -> a * b);
        Callable<Integer> sleepTask = () -> {
            TimeUnit.SECONDS.sleep(1);
            return 42;
        };
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.submit(task);
        executor.submit(task);
        executor.submit(task);
        executor.submit(task); // extra task reuses existing thread
        List<Callable<Integer>> tasks = Arrays.asList(
                sumTask,
                multiplyTask,
                sleepTask
        );
        try {
            List<Future<Integer>> results = executor.invokeAll(tasks);
            for (Future<Integer> f : results) {
                System.out.println("Result: " + f.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}
