package main.java.modules.patterns.singleton;

/**
 * @author amanjain
 **/
public class SingletonDemo {
    public static void main(String[] args){
        AppLogger logger1 = AppLogger.getInstance();
        AppLogger logger2 = AppLogger.getInstance();

        logger1.log("Started the application");
        logger2.log("Another part of the app logs this");

        System.out.println("Same instance? " + (logger1 == logger2));
    }
}
