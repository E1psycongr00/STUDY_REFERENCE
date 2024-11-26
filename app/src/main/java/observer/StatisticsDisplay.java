package observer;

public class StatisticsDisplay implements Display {
    private float maxTemp = Float.MIN_VALUE;
    private float minTemp = Float.MAX_VALUE;
    private float tempSum = 0;
    private int numReadings = 0;

    @Override
    public void update(float temperature, float humidity, float pressure) {
        tempSum += temperature;
        numReadings++;

        if (temperature > maxTemp) {
            maxTemp = temperature;
        }
        if (temperature < minTemp) {
            minTemp = temperature;
        }
        display();
    }

    public void display() {
        System.out.println("\n날씨 통계:");
        System.out.printf("평균 온도: %.1f°C\n", tempSum / numReadings);
        System.out.printf("최고 온도: %.1f°C\n", maxTemp);
        System.out.printf("최저 온도: %.1f°C\n", minTemp);
    }
} 