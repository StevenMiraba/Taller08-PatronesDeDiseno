package observer;

import java.util.ArrayList;
import java.util.List;

public class NotificationSystem implements Subject {
    private List<Observer> observers;
    private String message;

    public NotificationSystem() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void newPromotion(String message) {
        this.message = message;
        notifyObservers();
    }
}