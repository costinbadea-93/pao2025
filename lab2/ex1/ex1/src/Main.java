import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {
    int a;
    static int b;

    {
//       a = 4;
        System.out.println("I am in a non-static block");
    }

    static {
//        b = 6;
        System.out.println("I am in a static block");
    }

    public Main(){
        System.out.println("I am in constructor");
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println("I am in main");
        /**
         * pilonii oop: encapsulare, mostenire(extends), polimorfism, abstractizare
         */
        /**
         * in java nu este permisa mostenirea multipla(nu puteam aveam mai multe extends)
         * insa poate fi simulata prin intermediul interfetelor(putem implementa oricate
         * interfete)
         */
        /**
         * abstractizarea poate fi realizata in java in 2 feluri:
         *  -clase abstracte(au abstract in nume,
         *      pot avea atat metode abstracte, cat si metode non abstracte
         *      putem avea constructor
         *      nu poate fi instantiata
         *  -interfetele
         */


//        Dog dog = new Dog();
        //polimorfism
//        Animal animal1 = new Dog();
//        dog.saySomething();
//        Cat cat = new Cat();
//        Animal animal2 = new Cat();
//        cat.saySomething();
//
//        //polimorfism
//        Animal [] animals = {
//                new Dog(),
//                new Cat(),
//        };

        /**
         * final(date ce nu pot suferi modificari)
         * static(o singura instanta in memorie)
         *
         * SOLID
         * -SINGLE RESPONSABILITY
         * -OPEN CLOSED
         * -LISKOV SUBSTITUTION
         * -INTERFACE SEGREGATION
         * -DEPENDENCY INJECTION
         *
         * DESIGN PATTERN:
         *    SINGLETON (enumul este cel mai relevant exemplu de singleton)
         */

        DataService dataService1 = DataService.getInstance();
        DataService dataService2 = DataService.getInstance();

//        System.out.println(dataService1.hashCode());
//        System.out.println(dataService2.hashCode());

        /**
         * clasa object (equals and hashcode)
         */

        Dog d1 = new Dog("Cutu");
        Dog d2 = new Dog("Cutu");

        System.out.println(d1.equals(d2));
        // hash colision -> in momentul in care pentru doua obiecte diferite
        //algoritmul de hash returneaza acelasi rezultat

        /**
         * -clasa produs ->name, price
         * -serviciu singleton -> Product [] arr -> adaugare produs, listare produse
         * -la adaugarea unui produs -> EmailNotification, SmsNotification
         * -daca pretul produsului este > 100 lei -> notificare prin email ca produsul
         * a fost adaugat
         * -daca pretul produsului este < 100 lei -> notificare prin sms ca produsul a fost
         * adaugat
         * -notificare ( print in consola cu detaliile produsului, specificand
         * canalul de notificare)
         *
         */

    }
}

//mostenire
//final class Animal {
//    public void saySomething(){
//        System.out.println("I am animal");
//    }
//}

abstract class Animal {
    public Animal() {}
    public abstract void saySomething();
}

//class Dog extends Animal {
//    private String name;
//
//    public Dog(String name) {
//        this.name = name;
//    }
//
//
//
//    @Override
//    public void saySomething() {
//        System.out.println("I am dog");
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//}

class Dog {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Objects.equals(name, dog.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


class Cat extends Animal {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void saySomething() {
        System.out.println("I am cat");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}