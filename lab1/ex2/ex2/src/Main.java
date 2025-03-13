import model.Product;
import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /**
         * -tipuri de date primitive (8 tipuri de date primitive)
         *     int long short byte char boolean double float
         * -clase infasuratoare(wrapper classes) (8 tipuri)
         *      =============obiecte=============
         *     Integer Long Short Byte Character Boolean Double Float
         */

        String s1 = "Laborator numarul 2";
        String s2 = "5";

        int n1 = 4;
        Integer n2 = 6;
        Integer n3 = 7;
        /**
         *  0, -1 , 1
         */
//        System.out.println("Result of comparing n2 with n3 : " + n2.compareTo(n3));
//        System.out.println(Integer.parseInt(s2));

        /**
         * numere cu virgula mobila
         */
        float f1= 3.14f;
        double d1 = 3.14;

        Float f2 = 3.14F;
        Double d2 = 3.14;

//        f2 = null;
//        f1 = null;

        /**
         * Bigdecimal
         */
        double d3 = 0.5599 * 0.345;
        float f3 = 0.5599f * 0.345f;

//        System.out.println(d3);
//        System.out.println(f3);
        /**
         * boxing vs unboxing
         * - se fac automat din versinuea de java 1.5
         */
        Integer n4 = 1;
        //boxing
        int n5 = n4;
        //unboxing
//        Integer n6 = n5;
        //===============================================//
//        int [] arr1 = {1,2,3,4,5};
        //instructiuni de control
        //repetitive: for,enhanced for( for in), while, do while
        //conditionale: if, if else, switch
        //iesire din loop: brake, continue, return;

//        for(int i = 0; i < arr1.length; i++){
//            System.out.println("Arr " + i + " " +arr1[i]);
//        }
//
//        for(int i : arr1){
//            System.out.println(i);
//        }
//
//        Arrays.stream(arr1).forEach(System.out::println);


        //==============tipuri de operatori============
        // operatorul ternar(operatorul elvis " (conditie booleana) ?v1:v2), instanceOf

//        System.out.println(checkNumber(2));
//        System.out.println(checkNumber(6));

        //instance of verifica apartenenta unui obiect la un anumit tip de clasa
        Integer n6 = 10;

//        if(n6 instanceof Integer){
//            System.out.println("is an integer");
//        }else{
//            System.out.println("Is something else!!!");
//        }

//        switch (n6){
//            case 1 -> System.out.println("n6 value is 1");
//            case 6 -> System.out.println("n6 value is 6");
//            default -> System.out.println("n6 value is none of the values");
//        }

//        Scanner sc = new Scanner(System.in);
//        System.out.println("Introduceti ceva de la tastatura:");
//        String value = sc.nextLine();
//        System.out.println("S-a introdus de la tastatura: " + value);




        //*************************ARRAYS***************//
        //sunt colectii de date cu lungime FIXA!!!
//        int [] arr3 = {3,4,2,1,6,7};
//        int [] [] arr4 = {{1}, {4,6}, {7,8,9}};
//        System.out.println("Arr 3 before sorting: " + Arrays.toString(arr3));
//        Arrays.sort(arr3);
//        System.out.println("Arr 3 after sorting: " + Arrays.toString(arr3));


        //clasa ARRAYS
        // -sort
        // -binarySearch (pentru a folosi binary search, obiectul trebuie sortat)
        //      -daca gasim valoare  -> returnam indexul unde se gaseste valoarea
        //      -daca nu gasim valoare -> -(insertion point) - 1
//        System.out.println(Arrays.binarySearch(arr3,5));
        Scanner sc = new Scanner(System.in);

        Product [] shop = {
          new Product(5, "Pufuleti")
        };
        System.out.println(Arrays.toString(shop));

//        shop = addNewProduct(shop, new Product(10, "Ciocolata"));
//        System.out.println(Arrays.toString(shop));


        while (true){

            System.out.println("Alegeti una din urmatoarele optiuni:");
            System.out.println("1.Adauga produs");
            System.out.println("2.Afiseaza produsele din magazin");
            System.out.println("3.Inchide aplicatia");
            String opt = sc.nextLine();

            switch (opt){
                case "1" -> {
                    System.out.println("Introduceti pretul produsului:");
                    String pretAsString = sc.nextLine();
                    int pret =Integer.parseInt(pretAsString);
                    System.out.println("Introduceti numele produsului:");
                    String nume = sc.nextLine();
                    Product p = new Product(pret, nume);
                    shop = addNewProduct(shop, p);
                }
                case "2" -> {
                    System.out.println("Produse existente in aplicatie:");
                    System.out.println(Arrays.toString(shop));
                }
                default -> {
                    System.out.println("Closing program....");
                    System.exit(0);
                }
            }
        }

    }

    static Product [] addNewProduct(Product [] products, Product p){
        Product [] newProducts = new Product[products.length+1];
//        System.arraycopy(products, 0, newProducts, 0, products.length);
        for (int i = 0; i < products.length; i++){
            newProducts[i] = products[i];
        }
        newProducts[products.length] = p;
        return newProducts;
    }

    static String checkNumber(int n) {
        return n < 5 ? "Mai mic ca 5" : "Mai mare ca 5";
    }
    /**
     *  product [] -> shop
     *  vrem sa citim date de la tastatura
     *  vrem parsam datele astfel incat ca construim un produs
     *  vrem sa adaugam produsul la array ul de produse existent
     */
}
