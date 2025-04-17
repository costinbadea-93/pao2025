package service.notification;

import model.BankAccount;

public class SmsNotification implements NotificationService {
    @Override
    public void notifyTransfer(BankAccount from, BankAccount to, double amount) {
        System.out.println("SMS: Transfer from: " + from.getBalance() + " to " + to.getBalance() + "with amount of:" + amount
                + "was successfully executed!");
    }
}
