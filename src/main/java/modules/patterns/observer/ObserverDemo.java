package main.java.modules.patterns.observer;

/**
 * @author amanjain
 **/
public class ObserverDemo {
    public static void main(String[] args){
        NewsPublisher publisher = new NewsPublisher();

        Observer aman = new MobileSubscriber("Aman");
        Observer tanu = new MobileSubscriber("Tanu");

        publisher.subscribe(aman);
        publisher.subscribe(tanu);

        publisher.notifyObservers("Breaking: Java 22 Released!");
        publisher.unsubscribe(tanu);
        publisher.notifyObservers("New Spring Boot version now available!");
    }
}
