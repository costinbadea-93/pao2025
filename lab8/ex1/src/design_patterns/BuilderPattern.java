package design_patterns;

public class BuilderPattern {
    public static void main(String[] args) {
/**
 * What is it?
 *
 * The Builder pattern is used to construct complex objects step by step.
 * It’s particularly useful for objects with many optional parameters or
 * when you want to ensure the object is immutable after its creation.
 *
 * When to Use?
 *
 * It’s helpful when the object construction involves multiple parameters,
 * some of which might be optional, or when you want more control over the initialization process.
 *
 * How it Works?
 *
 * The Builder class provides methods to set the object’s parameters and a final method
 * to build the object. This pattern simplifies the construction process by making it more readable and flexible.
 */

        Car car = new Car.CarBuilder()
                .setEngine("V8")
                .setWheels(4)
                .build();
        System.out.println(car);
    }
}

class Car {
    private String engine;
    private int wheels;

    private Car(CarBuilder builder) {
        this.engine = builder.engine;
        this.wheels = builder.wheels;
    }

    @Override
    public String toString() {
        return "Car{" +
                "engine='" + engine + '\'' +
                ", wheels=" + wheels +
                '}';
    }

    public static class CarBuilder {
        private String engine;
        private int wheels;

        public CarBuilder setEngine(String engine) {
            this.engine = engine;
            return this;
        }

        public CarBuilder setWheels(int wheels) {
            this.wheels = wheels;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}