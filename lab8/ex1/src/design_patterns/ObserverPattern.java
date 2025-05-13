package design_patterns;

import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {

    /**
     * What is it?
     *
     * The Observer pattern allows an object (called the "subject") to notify other objects
     * (called "observers") when its state changes. This is particularly useful for event-driven systems.
     *
     * When to Use?
     *
     * It’s used when multiple objects need to be updated based on a change in another object,
     * such as in GUI applications or messaging systems.
     *
     * How it Works?
     *
     * The subject maintains a list of observers and notifies them whenever its state changes.
     * Observers subscribe to the subject to receive updates automatically.
     * @param args
     */
    public static void main(String[] args) {
        // Create NewsAgency (Subject)
        NewsAgency newsAgency = new NewsAgency();

        // Create Observers (NewsChannels)
        Observer channel1 = new NewsChannel();
        Observer channel2 = new NewsChannel();

        // Register observers with the news agency
        newsAgency.addObserver(channel1);
        newsAgency.addObserver(channel2);

        // Notify observers with a message
        newsAgency.notifyObservers("Breaking News: New technology released!");
    }
}

interface Observer {
    void update(String message);
}

class NewsChannel implements Observer {
    public void update(String message) {
        System.out.println("News Channel received: " + message);
    }
}

class NewsAgency {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}