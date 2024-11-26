package observer;

public class CurrentConditionsDisplay implements Display {
    private float temperature;
    private float humidity;
    private float pressure;

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    public void display() {
        System.out.println("현재 날씨 상태:");
        System.out.printf("온도: %.1f°C\n", temperature);
        System.out.printf("습도: %.1f%%\n", humidity);
        System.out.printf("기압: %.1fhPa\n", pressure);
    }
} 