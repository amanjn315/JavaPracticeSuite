package main.java.modules.patterns.strategy;

/**
 * @author amanjain
 **/
public class PaymentContext {
    private PaymentStrategy strategy;

    public void setStrategy(PaymentStrategy strategy){
        this.strategy = strategy;
    }

    public void makePayment(int amount){
        if(strategy == null){
            throw new IllegalStateException("Payment strategy not set.");
        }
        strategy.pay(amount);
    }
}
