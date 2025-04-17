import model.AccountType;
import model.BankAccount;
import service.bank_account.BankAccountService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {

        BankAccountService bankAccountService = new BankAccountService();

        while (true) {
            System.out.println("Chose one of the following options:");
            System.out.println("1. Add new account");
            System.out.println("2. List all accounts");
            System.out.println("3. List accounts sorted by account number");
            System.out.println("4. TopUp account");
            System.out.println("5. Make Transfer");
            System.out.println("0. Exit");

            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> {
                    System.out.println("Enter account number: ");
                    String accountNumber = scanner.nextLine();
                    System.out.println("Enter account balance: ");
                    String accountBalance = scanner.nextLine();
                    System.out.println("Enter account type: ");
                    String accountType = scanner.nextLine();
                    BankAccount bankAccount = new BankAccount(accountNumber,Double.valueOf(accountBalance), AccountType.valueOf(accountType));
                    bankAccountService.addAccount(bankAccount);
                }
                case "2" -> bankAccountService.getAccounts();
                case "3" -> bankAccountService.getAccountsSortedByAccountNumber();
                case "4" -> {
                    System.out.println("Enter account number: ");
                    String accountNumber = scanner.nextLine();
                    System.out.println("Enter amount: ");
                    String amount = scanner.nextLine();
                    bankAccountService.topUpAccount(accountNumber, Double.valueOf(amount));
                }
                case "5" -> {
                    System.out.println("Enter from account number: ");
                    String from = scanner.nextLine();
                    System.out.println("Enter to account number: ");
                    String to = scanner.nextLine();
                    System.out.println("Enter amount to be transferred: ");
                    String amount = scanner.nextLine();
                    bankAccountService.transferMoney(from, to, Double.valueOf(amount));
                }
                case "0" -> System.exit(0);
            }

        }

    }
}


