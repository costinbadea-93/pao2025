package service.bank_account;

import model.BankAccount;
import service.notification.NotificationService;
import service.notification.NotificationServiceFactory;

public class BankAccountUtils implements BankAccountContract {

    private NotificationServiceFactory notificationServiceFactory = new NotificationServiceFactory();

    @Override
    public void makeTransfer(BankAccount from, BankAccount to, double amount) {
        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);

        NotificationService notificationService = notificationServiceFactory.getNotificationService(from);
        notificationService.notifyTransfer(from, to, amount);
    }
}
