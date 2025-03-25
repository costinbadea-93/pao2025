package Utils;

import model.Produs;

public class EmailNotification extends Notificare {

    public void sendNotification(Produs p)
    {
        System.out.println("Email Notification pentru produsul: " + p.getName() + " cu pretul: " + p.getPrice());
    }
}
