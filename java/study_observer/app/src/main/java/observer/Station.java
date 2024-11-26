package observer;

public interface Station {
    void registerObserver(Display observer);
    void removeObserver(Display observer);
    void notifyObservers();
} 