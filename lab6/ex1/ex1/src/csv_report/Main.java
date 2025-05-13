package csv_report;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Person> personList = List.of(
                new Person("Costin", 30, "111111111111111"),
                new Person("Cristi", 21, "222222222222222"),
                new Person("Alex", 25, "333333333333333")
        );

        String reportContent =  generateReportContent(personList);
        Path path = Paths.get("C:\\Users\\cbadea\\OneDrive - ENDAVA\\EnDev\\Desktop\\pao-2025-sem1\\lab6\\ex1\\ex1\\src\\csv_report\\report" + LocalDateTime.now().toEpochSecond(ZoneOffset.UTC) + ".csv");
        try {
            Files.createFile(path);
            Files.write(path, reportContent.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    private  static String generateReportContent(List<Person> personList) {
        //generating header
        StringBuilder sb = new StringBuilder();
        sb.append("NAME,AGE,CNP\n");
        personList.forEach(person -> sb.append(person.getName()).append(",").append(person.getAge()).append(",").append(person.getCnp()).append("\n"));

        return sb.toString();
    }
}


class Person {
    private String name;
    private int age;
    private String cnp;

    public Person(String name, int age, String cnp) {
        this.name = name;
        this.age = age;
        this.cnp = cnp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", cnp=" + cnp +
                '}';
    }
}