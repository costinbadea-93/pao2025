package service.bank_account;

import model.BankAccount;

public interface BankAccountContract {
    void makeTransfer(BankAccount from, BankAccount to, double amount);
}
