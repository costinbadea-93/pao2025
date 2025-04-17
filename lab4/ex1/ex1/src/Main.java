import enums.AccountType;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
//        /**
//         * files => ????
//         * exceptions?
//         */
//
//        AccountType type1 = AccountType.SAVINGS;
//        AccountType type2 = AccountType.DEPOSITS;
//
//        /**
//         * Retrieving value from enum by string
//         */
//        System.out.println(AccountType.valueOf("SAVINGS"));
//
//        for (AccountType type : AccountType.values()) {
////            System.out.println(type);
//            type.printAccountDescription();
//        }

//        try{
//
//        }catch (Exception e){
//
//        } finally {
//
//        }

        /**
         * Exception types : checked exceptions    Exception
         *                   unchecked exceptions
         *
         *                                         Errors(probleme care tin de system(ex. ramane masina
         *                                         fara memorie
         *
         *    checked exceptions  -> compilatorul ne atentioneaza ca trebuiesc tratate (FileNotFoundException, SqlException)
         *    unchecked exceptions -> compilatoul nu ne anunta -> ramane sarcina programatorului sa fie tratate(NullPointerException)
         *
         *    Aruncarea exceptiilor : throw + numele exceptiei
         *    Prentru propagare exceptiei mai sus in ierarhie folosim:
         *
         *    try with resource(java 1.8)
         *    try(resursa(resursa trb sa implementeze interfata de cloaseble)) {
         *    }catch(Exception e) {
         *    }
         */

        String filePath = "data.txt";
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            byte[] data = fileInputStream.readAllBytes();
            System.out.println(new String(data));
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }




//        try(FileInputStream fileInputStream = new FileInputStream(filePath))   {
//
//        }  catch (FileNotFoundException e){
//            e.printStackTrace();
//        }

    }
}
