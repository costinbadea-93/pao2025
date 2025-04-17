package service.notification;

import model.BankAccount;

@FunctionalInterface
public interface NotificationService {
    void notifyTransfer(BankAccount from, BankAccount to, double amount);
}
