package main.java.modules.patterns.observer;

/**
 * @author amanjain
 **/
public class MobileSubscriber implements Observer{
    private String name;

    public MobileSubscriber(String name){
        this.name = name;
    }

    public void update(String message){
        System.out.println(name + " received news: " + message);
    }
}
