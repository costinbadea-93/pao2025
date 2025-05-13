package design_patterns;

public class DecoratorPattern {
    /**
     * What is it?
     *
     * The Decorator pattern allows you to add new functionality to an existing object dynamically
     * without modifying its structure. It provides a flexible way to extend behavior.
     *
     * When to Use?
     *
     * It’s used when you need to add responsibilities to individual objects without affecting the
     * entire class. It follows the Open/Closed Principle by allowing extensions without changing
     * the core class.
     *
     * How it Works?
     *
     * The Decorator class implements the same interface as the object it decorates. The decorator
     * can modify or add behavior while delegating the base functionality to the original object.
     * @param args
     */
    public static void main(String[] args) {
        // Create a simple coffee
        Coffee simpleCoffee = new SimpleCoffee();

        // Print the description and cost of the simple coffee
        System.out.println(simpleCoffee.getDescription() + " | Cost: " + simpleCoffee.getCost());

        // Decorate the simple coffee with milk
        Coffee milkCoffee = new MilkDecorator(simpleCoffee);

        // Print the description and cost of the coffee with milk
        System.out.println(milkCoffee.getDescription() + " | Cost: " + milkCoffee.getCost());
    }
}

interface Coffee {
    String getDescription();
    double getCost();
}

class SimpleCoffee implements Coffee {
    public String getDescription() {
        return "Simple Coffee";
    }

    public double getCost() {
        return 5;
    }
}

// MilkDecorator class implementing Coffee interface to add milk
class MilkDecorator implements Coffee {
    private Coffee coffee;

    public MilkDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    public String getDescription() {
        return coffee.getDescription() + ", Milk";
    }

    public double getCost() {
        return coffee.getCost() + 1.5;
    }
}