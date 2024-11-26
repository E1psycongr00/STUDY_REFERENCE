package observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Station {
    private List<Display> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Display observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Display observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Display observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObservers();
    }
} 