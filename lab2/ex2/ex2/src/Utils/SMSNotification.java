package Utils;

import model.Produs;

public class SMSNotification extends Notificare{

    public void sendNotification(Produs p)
    {
        System.out.println("SMS Notification pentru produsul: " + p.getName() + " cu pretul: " + p.getPrice());
    }
}
