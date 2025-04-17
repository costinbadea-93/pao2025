import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /**
         * putem extinde o singura clasa
         * putem implementa oricate interfete
         */

        MySQLDbConnection mySQLDbConnection = new MySQLDbConnection();
        OracleDbConnection oracleDbConnection = new OracleDbConnection();
        DbUtilsService dbUtilsService1 = new DbUtilsService(mySQLDbConnection);
        DbUtilsService dbUtilsService2 = new DbUtilsService(oracleDbConnection);

//        List<Integer> l1 = new ArrayList<>();
//        l1.add(1);
//        l1.add(2.3);
//        var l2 = new ArrayList<Integer>();
//        l2.add(1);
//        l2.add(2.3);

        //interfata functionala -> are o singura metoda abstracta
        //function, bifunction, supplier, consummer,  unary operator, binary opperator, predicate, bipredicate

        //vrem suma patratelor numerelor pare
//        List<Integer> l1 = Arrays.asList(1, 2, 3, 4);
//        int sum = 0;
//        for (Integer i : l1) {
//            if(i % 2 == 0) {
//                sum += i * i;
//            }
//        }
//        System.out.println(sum);
//
//        //stream -> pipe ce primeste un input, aplica o seride de operatii -> output
//        int sum2 = l1.stream().filter(e -> e % 2 == 0)
//                .mapToInt(e -> e * e)
//                .sum();
//
//        System.out.println(sum2);

        Runnable runnable1 = () -> System.out.println("Running runnable!");

        List<Animal> animals = Arrays.asList(
                new Animal("C1"),
                new Animal("A1"),
                new Animal("B1")
        );


//       Collections.sort(animals, (o1, o2) -> o1.getName().compareTo(o2.getName()));
       Collections.sort(animals, Comparator.comparing(Animal::getName));
        System.out.println(animals);




    }
}

//class AnimalComparator implements Comparator<Animal> {
//    @Override
//    public int compare(Animal o1, Animal o2) {
//        return o1.getName().compareTo(o2.getName());
//    }
//}

class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }
}


@FunctionalInterface
interface DbConnection {
    void connectToDb();

//    void disconnect();

    default void disconnectFromDb() {

    }

    static void connectToOracleDb() {

    }

    private static void disconnectFromOracleDb() {

    }
}

class OracleDbConnection implements DbConnection{
    @Override
    public void connectToDb() {
        System.out.println("Connecting to Oracle Database...");
    }
}

class MySQLDbConnection implements DbConnection{

    @Override
    public void connectToDb() {
        System.out.println("Connecting to MySQL Database...");
    }
}

class DbUtilsService{
    private DbConnection dbConn;

    public DbUtilsService(DbConnection dbConn){
        this.dbConn = dbConn;
        dbConn.connectToDb();
    }
}
