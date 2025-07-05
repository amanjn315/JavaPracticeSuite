package main.java.modules.patterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author amanjain
 **/
public class NewsPublisher {
    private List<Observer> subscriber = new ArrayList<>();

    public void subscribe(Observer o){
        subscriber.add(o);
    }

    public void unsubscribe(Observer o){
        subscriber.remove(o);
    }

    public void notifyObservers(String news){
        for(Observer o : subscriber){
            o.update(news);
        }
    }
}
