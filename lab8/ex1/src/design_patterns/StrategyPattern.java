package design_patterns;

public class StrategyPattern {
    public static void main(String[] args) {
        /**
         * What is it?
         *
         * The Strategy pattern defines a family of algorithms and allows them to be used interchangeably.
         * It eliminates the need forcomplex conditional statements by encapsulating each algorithm
         * in a separate class.
         *
         * When to Use?
         *
         * It’s helpful when you have different variations of an algorithm that can be switched dynamically,
         * such as different payment methods or sorting strategies.
         *
         * How it Works?
         *
         * A common interface defines the algorithm’s structure, and multiple concrete strategies
         * implement the interface. The client can choose the appropriate strategy based on the context.
         */
        // Create an instance of CreditCardPayment (payment strategy)
        PaymentStrategy creditCardPayment = new CreditCardPayment();

        // Create a ShoppingCart and set its payment strategy
        ShoppingCart cart = new ShoppingCart(creditCardPayment);

        // Checkout with a specific amount
        cart.checkout(150);
    }
}

interface PaymentStrategy {
    void pay(int amount);
}

class CreditCardPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid with Credit Card: " + amount);
    }
}

// ShoppingCart class that uses PaymentStrategy
class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    // Constructor to initialize the payment strategy
    public ShoppingCart(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    // Checkout method that uses the payment strategy
    public void checkout(int amount) {
        paymentStrategy.pay(amount);
    }
}