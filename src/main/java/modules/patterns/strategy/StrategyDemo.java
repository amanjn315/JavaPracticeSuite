package main.java.modules.patterns.strategy;

/**
 * @author amanjain
 **/
public class StrategyDemo {
    public static void main(String[] args){
        PaymentContext context = new PaymentContext();

        context.setStrategy(new CreditCardPayment());
        context.makePayment(500);

        context.setStrategy(new PayPalPayment());
        context.makePayment(1000);
    }
}
