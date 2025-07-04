package main.java.modules.patterns.strategy;

/**
 * @author amanjain
 **/
public class CreditCardPayment implements PaymentStrategy{
    public void pay(int amount){
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}
