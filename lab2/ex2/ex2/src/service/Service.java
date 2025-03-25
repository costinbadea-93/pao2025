package service;

import Utils.EmailNotification;
import Utils.Notificare;
import Utils.SMSNotification;
import model.Produs;

import java.util.Arrays;

public class Service {
    private Produs[] produs = new Produs[0];

    private Service(){}

    private final class SINGLETON_HOLDER{
        private static final Service SINGLETON_INSTANCE = new Service();
    }
    public static Service getInstance(){
        return SINGLETON_HOLDER.SINGLETON_INSTANCE;
    }

    public void afisareProduse()
    {
        System.out.println(Arrays.toString(produs));
    }

    public void adaugareProdus(Produs p)
    {
        Produs[] aux = new Produs[produs.length+1];
        for(int i=0;i< produs.length;i++)
            aux[i] = produs[i];
        aux[aux.length-1] = p;
        produs = aux;
        Notificare notificare;

        if(p.getPrice()>100)
            notificare = new EmailNotification();
        else
            notificare = new SMSNotification();
        notificare.sendNotification(p);

    }

}
