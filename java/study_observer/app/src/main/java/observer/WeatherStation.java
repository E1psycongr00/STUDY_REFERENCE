package observer;

public interface WeatherStation {
    void registerObserver(WeatherDisplay observer);
    void removeObserver(WeatherDisplay observer);
    void notifyObservers();
} 