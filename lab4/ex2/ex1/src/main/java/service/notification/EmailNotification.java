package service.notification;

import model.BankAccount;

public class EmailNotification implements NotificationService {
    @Override
    public void notifyTransfer(BankAccount from, BankAccount to, double amount) {
        System.out.println("Email: Transfer from: " + from.getBalance() + " to " + to.getBalance() + "with amount of:" + amount
                + "was successfully executed!");
    }
}
