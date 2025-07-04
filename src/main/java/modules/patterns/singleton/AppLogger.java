package main.java.modules.patterns.singleton;

/**
 * @author amanjain
 **/
public class AppLogger {
    private static volatile AppLogger instance;

    private AppLogger(){
        System.out.println("Logger Initialised");
    }

    public static AppLogger getInstance() {
        if(instance == null){
            synchronized (AppLogger.class){
                if(instance == null){
                    instance = new AppLogger();
                }
            }
        }
        return instance;
    }

    public void log(String message){
        System.out.println("[LOG] " + message);
    }
}
