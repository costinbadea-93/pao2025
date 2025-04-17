package service.notification;

import model.AccountType;
import model.BankAccount;

public class NotificationServiceFactory {

    public NotificationService getNotificationService(BankAccount from) {
        if(from.getAccountType() == AccountType.SAVINGS) {
            return new EmailNotification();
        }else {
            return new SmsNotification();
        }
    }
}
