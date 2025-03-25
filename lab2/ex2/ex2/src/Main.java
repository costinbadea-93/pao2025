import model.Produs;
import service.Service;

public class Main {

    public static void main(String[] args) {
        Service service = Service.getInstance();

        service.adaugareProdus(new Produs("placinta", 101));
        service.adaugareProdus(new Produs("tort", 50));
        service.adaugareProdus(new Produs("potato", 2000));

        service.afisareProduse();
    }
}
