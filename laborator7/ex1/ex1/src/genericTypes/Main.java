package genericTypes;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //wild car -> ?
        //poate fi folosit cu 2 keywords: extends, super
        // Get and put priciple -> PECS -> producer extends, consumer super
        //daca vrem sa adaugam elemente intr o colectie -> extends
        //daca vrem sa scoatem elemente dintr o colectie -> super
        //daca vrem si una si alta -> nu folosim tipuri generice

        //tip generic pe colectie
        List<? extends A> list1 = new ArrayList<B>();
        List<? super B> list2 = new ArrayList<A>();
    }

    //tip generic pe metoda
    public static <T> T doSomething(T t) {
        return t;
    }
}

class A { }

class B extends A { }