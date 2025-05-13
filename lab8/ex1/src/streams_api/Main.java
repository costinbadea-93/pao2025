package streams_api;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * For more streams operations please visit:
 * https://stackify.com/streams-guide-java-8/
 */

public class Main {
    public static void main(String[] args) {
        Employee[] arrayOfEmps = {
                new Employee(1, "Jeff Bezos", 100000.0),
                new Employee(2, "Bill Gates", 200000.0),
                new Employee(3, "Mark Zuckerberg", 300000.0)
        };

        /**
         * ForEach
         *
         * forEach() is the simplest and most common operation; it loops over the stream elements,
         * calling the supplied function on each element.
         * forEach() is a terminal operation
         */

        Arrays.asList(arrayOfEmps)
                .stream()
                .forEach(e -> System.out.println(e));

        /**
         * Map
         *
         * map() produces a new stream after applying a function to each element of the original stream.
         * The new stream could be of a different type.
         */

        //increasing employees salary with 100
        Arrays.asList(arrayOfEmps).stream()
                .map(e -> {
                    //this can be also extracted in a separate function
                    e.setSalary(e.getSalary() + 100);
                    return e;
                })
                .forEach(e -> System.out.println(e));

        /**
         * filter()
         *
         * filter(). This produces a new stream that contains elements of the original
         * stream that pass a given test (specified by a predicate).
         */

        //filtering employees with a salary greater than 200000
        List<Employee> employees = Arrays.stream(arrayOfEmps)
                .filter(e -> e.getSalary() > 200000)
                .collect(Collectors.toList());

        /**
         * collect
         *
         * We saw how collect() works in the previous example; it’s one of the common ways to get stuff out
         * of the stream once we are done with all the processing
         */

        List<Employee> employees1 = Arrays.stream(arrayOfEmps).collect(Collectors.toList());

        /**
         * findFirst
         *
         * findFirst() returns an Optional for the first entry in the stream.
         * The Optional can, of course, be empty
         */

        Employee employee = Arrays.stream(arrayOfEmps)
                .filter(e -> e.getSalary() > 200000)
                .findFirst()
                .orElse(null);

        /**
         * flatMap
         *
         * A stream can hold complex data structures like Stream<List<String>>. In cases like this,
         * flatMap() helps us to flatten the data structure to simplify further operations
         */

        List<List<String>> namesNested = Arrays.asList(
                Arrays.asList("Jeff", "Bezos"),
                Arrays.asList("Bill", "Gates"),
                Arrays.asList("Mark", "Zuckerberg"));

        List<String> namesFlatStream = namesNested.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        System.out.println(namesFlatStream);

        /**
         * allMatch, anyMatch, and noneMatch
         * These operations all take a predicate and return a boolean. Short-circuiting is
         * applied and processing is stopped as soon as the answer is determined
         */
        List<Integer> intList = Arrays.asList(2, 4, 5, 6, 8);

        boolean allEven = intList.stream().allMatch(i -> i % 2 == 0);
        boolean oneEven = intList.stream().anyMatch(i -> i % 2 == 0);
        boolean noneMultipleOfThree = intList.stream().noneMatch(i -> i % 3 == 0);

        /**
         * As the names suggest, min() and max() return the minimum and maximum element in the stream respectively, based on a comparator.
         * They return an Optional since a result may or may not exist (due to, say, filtering)
         */

        Employee firstEmp = Arrays.stream(arrayOfEmps)
                .min((e1, e2) -> e1.getId() - e2.getId())
                .orElseThrow(() -> new RuntimeException("No employee found"));

        /**
         * sorted
         *
         * sorted() operation—this sorts the stream elements
         * based on the comparator passed we pass into it.
         */
    }
}

class Employee{
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
