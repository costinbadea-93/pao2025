package service.bank_account;

import model.AccountType;
import model.BankAccount;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.nio.file.StandardOpenOption.APPEND;

public class BankAccountService {
    private List<BankAccount> accounts = new ArrayList<BankAccount>();

    private BankAccountUtils bankAccountUtils = new BankAccountUtils();

    public BankAccountService() {
        accounts.add(new BankAccount("0051",  2000.0, AccountType.SAVINGS));
        accounts.add(new BankAccount("0052",  1000.0, AccountType.SAVINGS));
        accounts.add(new BankAccount("0050",  3000.0, AccountType.DEPOSITS));
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
        writeLogToAuditV3("A new account with account number " + account.getAccountNumber() + " has been added.");
    }

    public void transferMoney(String from, String to, double amount) {
        BankAccount f = accounts.stream().filter(
                        b -> b.getAccountNumber().equalsIgnoreCase(from))
                .findFirst().orElseThrow(() ->{
                    writeLogToAuditV3("Account " + from + " not found. to top up.");
                    return new RuntimeException("Account not found");
                });

        BankAccount t = accounts.stream().filter(
                        b -> b.getAccountNumber().equalsIgnoreCase(to))
                .findFirst().orElseThrow(() ->{
                    writeLogToAuditV3("Account " + to + " not found. to top up.");
                    return new RuntimeException("Account not found");
                });


        bankAccountUtils.makeTransfer(f, t, amount);
        writeLogToAuditV3("Transfer from " + f.getAccountNumber() + " to " + t.getAccountNumber() + " has been successfully completed.");
        System.out.println("Transfer complete.");
    }

    public void getAccounts() {
        writeLogToAuditV3("Retrieving all accounts... ");
        System.out.println(accounts);
    }

    public void getAccountsSortedByAccountNumber() {
        Collections.sort(accounts, Comparator.comparing(BankAccount::getAccountNumber));
        System.out.println(accounts);
        writeLogToAuditV3("Retrieving all accounts sorted by account number");
    }

    public void topUpAccount(String accountNumber, double amount) {
        BankAccount bankAccount = accounts.stream().filter(
                b -> b.getAccountNumber().equalsIgnoreCase(accountNumber))
                .findFirst()
                .orElseThrow(() ->{
                            writeLogToAuditV3("Account " + accountNumber + " not found. to top up.");
                            return new RuntimeException("Account not found");
                });


        bankAccount.setBalance(bankAccount.getBalance() + amount);
        writeLogToAuditV3("Top up account: " + bankAccount.getAccountNumber());
    }

    public void drawDownAccount(String accountNumber, double amount) {
        BankAccount bankAccount = accounts.stream().filter(
                        b -> b.getAccountNumber().equalsIgnoreCase(accountNumber))
                .findFirst().orElseThrow(() ->{
                    writeLogToAuditV3("Account " + accountNumber + " not found. to top up.");
                    return new RuntimeException("Account not found");
                });

        if(bankAccount.getBalance() >= amount) {
            bankAccount.setBalance(bankAccount.getBalance() - amount);
            writeLogToAuditV3("Account " + bankAccount.getAccountNumber() + " has been drawn.");
        }else {
            writeLogToAuditV3("Insufficient balance to the account " + bankAccount.getAccountNumber() + " to complete transfer");
            throw new RuntimeException("Account not drawn due to insufficient balance!");
        }
    }

    public void writeLogToAudit(String log) {
        try {
            Files.write(Paths.get("src/main/resources/audit.txt"), log.getBytes(), APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readAuditContent() {
        try {
            Files.readAllLines(Paths.get("src/main/resources/audit.txt"))
                    .stream()
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeLogToAuditV2(String log) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src/main/resources/audit.txt", true);
            fileOutputStream.write(log.getBytes());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readLogAuditV2(String log) {
        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/audit.txt");
            byte[] bytes = fileInputStream.readAllBytes();
            System.out.println(new String(bytes));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeLogToAuditV3(String log) {
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("src/main/resources/audit.txt", true));
            bufferedOutputStream.write(log.getBytes());
            //depinde de versiunea de java
            bufferedOutputStream.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readLogAuditV3(String log) {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("src/main/resources/audit.txt"));
            byte[] bytes = bufferedInputStream.readAllBytes();
            System.out.println(new String(bytes));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
