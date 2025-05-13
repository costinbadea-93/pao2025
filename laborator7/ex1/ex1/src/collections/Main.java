package collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    /** 28 si 4 iunie => prezentare de proiect **/
    /**
     * list
     * queue
     * set
     * sorted set ===========> implementeaza iterable
     *
     * map(tip de colectie particulara) => nu implementeaza iterable
     * tip de colectie key value
     **/

        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new LinkedList<>();

        //FIFI -> FIRST IN FIRST OUT
        Queue<Integer> q1 = new LinkedList<>();
        q1.add(1);
        q1.add(2);
        q1.add(3);
        System.out.println(q1.poll());
        Queue<Integer> q2 = new ArrayDeque<>();

        //LIFO -> LAST IN FIRST OUT
        Stack<Integer> s1 = new Stack<>();
        s1.push(1);
        s1.push(2);
        s1.push(3);
        System.out.println(s1.pop());

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new TreeSet<>();

        //Asigura unicitatea si sortarea pt tipurile de clase primitive
        //unicitate -> equals si hashcode
        //sortare -> Comparator
        SortedSet<Integer> set3 = new TreeSet<>();
        SortedSet<Animal> set4 = new TreeSet<>(Comparator.comparing(Animal::getName));

        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new TreeMap<>();

        List<Integer> list1 = List.of(1, 2, 3, 4, 5);
        Map<Integer, String> map3 = new HashMap<>();
        map3.put(1, "Ana");
        map3.put(2, "Alin");
        map3.put(3, "Anca");

        list1.stream().forEach(e -> System.out.println(e));

        //sortare map dupa valoare
        Map<Integer, String> sortedMap = map3.entrySet()
                .stream()
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(e1, e2) ->e1, LinkedHashMap::new));
//                .forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));

        /**
         * SOLID principals
         * S-> single resp
         * O-> open closed
         * L ->liskov substitution
         * I -> interface segregation
         * D -> dependency inversion
         */

    }

//    public static SortedSet<Integer> getSet() {
//        return new HashSet<>();
//    }
}

class Animal {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}