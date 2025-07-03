package main.java.modules.multithreading;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author amanjain
 **/
public class ExecutorDemoAss {
    static Callable<String> task1 = () -> "Task 1 done";
    static Callable<String> task2 = () -> "Task 2 done";
    static Callable<String> task3 = () -> "Task 3 done";
    static Callable<String> task4 = () -> "Task 4 done";
    static Callable<String> task5 = () -> "Task 5 done";
    static List<Callable<String>> list = Arrays.asList(
            task1,
            task2,
            task3,
            task4,
            task5
    );
    static ExecutorService service = Executors.newFixedThreadPool(5);

    public static void main(String[] args){
        try {
            List<Future<String>> res = service.invokeAll(list);
            for (int i = 0; i < res.size(); i++) {
                System.out.println("Result " + (i + 1) + ": " + res.get(i).get());
            }
        } catch(InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            service.shutdown();
        }
    }
}
