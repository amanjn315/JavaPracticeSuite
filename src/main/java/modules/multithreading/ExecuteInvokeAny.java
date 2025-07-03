package main.java.modules.multithreading;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author amanjain
 **/
public class ExecuteInvokeAny {
    static Callable<String> fastTask = () -> {
        Thread.sleep(500);
        return "Fast task finished!";
    };

    static Callable<String> mediumTask = () -> {
        Thread.sleep(1000);
        return "Medium task finished!";
    };

    static Callable<String> slowTask = () -> {
        Thread.sleep(2000);
        return "Slow task finished!";
    };

    static List<Callable<String>> taskList = Arrays.asList(fastTask, mediumTask, slowTask);

    public static void main(String[] args){
        ExecutorService executor = Executors.newFixedThreadPool(3);
        try {
            String result = executor.invokeAny(taskList);
            System.out.println("First completed: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}
