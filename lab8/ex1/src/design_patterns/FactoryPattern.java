package design_patterns;

public class FactoryPattern {
    public static void main(String[] args) {
        /**
         * What is it?
         *
         * The Factory pattern provides a method to create objects, but the exact class type
         * to be instantiated is decided at runtime. The Factory pattern abstracts the object
         * creation process and promotes loose coupling between the client and the object it uses.
         *
         * When to Use?
         *
         * When you want to decouple the object creation logic from the rest of the application,
         * particularly when the client code should not be aware of the specific classes being used.
         *
         * How it Works?
         *
         * A Factory class is used to instantiate objects based on specific inputs or conditions.
         * The client interacts with the Factory, not directly with the objects themselves
         */
        // Create a ShapeFactory instance
        ShapeFactory shapeFactory = new ShapeFactory();

        // Get a Circle shape using ShapeFactory
//        Shape shape = shapeFactory.getShape("CIRCLE");
        Shape shape = shapeFactory.getShape("TRIANGLE");

        // Call the draw method
        if (shape != null) {
            shape.draw();  // Output: Drawing Circle
        } else {
            System.out.println("Shape not found");
        }
    }
}

interface Shape{
    void draw();
}

class ShapeFactory {
    public Shape getShape(String shapeType) {
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("TRIANGLE")) {
            return new Triangle();
        }
        return null;
    }
}

class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

class Triangle implements Shape{
    @Override
    public void draw() {
        System.out.println("Drawing Triangle");
    }
}