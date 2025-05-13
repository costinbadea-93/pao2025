package design_patterns;

public class PrototypePattern {
    public static void main(String[] args) {
        /**
         * What is it?
         *
         * The Prototype pattern allows for creating new objects by cloning existing ones.
         * This is especially useful when object creation is expensive and you want to avoid
         * redundant instantiation.
         *
         * When to Use?
         *
         * It’s ideal when cloning an object is more efficient than creating a new one from scratch,
         * or when an object has complex initialization that can be replicated.
         *
         * How it Works?
         *
         * A class implements the Cloneable interface and provides a method to clone itself.
         * This allows new instances to be created by copying an existing object, rather than
         * instantiating a new one.
         */

        Vehicle vehicle1 = new Vehicle("Car");
        Vehicle vehicle2 = (Vehicle) vehicle1.clone();
        System.out.println(vehicle1); // Vehicle{type='Car'}
        System.out.println(vehicle2); // Vehicle{type='Car'}

        // Modify the clone
        vehicle2.setType("Bike");
        System.out.println(vehicle1); // Vehicle{type='Car'}
        System.out.println(vehicle2); // Vehicle{type='Bike'}

    }
}

class Vehicle implements Cloneable {
    private String type;

    public Vehicle(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // Shouldn't happen since we implement Cloneable
        }
    }

    @Override
    public String toString() {
        return "Vehicle{type='" + type + "'}";
    }
}
