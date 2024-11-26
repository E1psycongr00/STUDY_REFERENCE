package observer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.DisplayName;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.never;
import static org.mockito.ArgumentMatchers.anyFloat;

@ExtendWith(MockitoExtension.class)
@DisplayName("날씨 데이터 관리 테스트")
class WeatherDataTest {
    private WeatherData weatherData;
    
    @Mock
    private Display mockDisplay;
    
    @Mock
    private Display mockDisplay2;

    @BeforeEach
    void setUp() {
        weatherData = new WeatherData();
    }

    @Test
    @DisplayName("옵저버 등록 시 날씨 정보를 정상적으로 받아야 한다")
    void registerObserver_ShouldAddObserver() {
        weatherData.registerObserver(mockDisplay);
        weatherData.setMeasurements(25.0f, 65.0f, 1013.0f);
        
        verify(mockDisplay).update(25.0f, 65.0f, 1013.0f);
    }

    @Test
    @DisplayName("옵저버 제거 시 더 이상 날씨 정보를 받지 않아야 한다")
    void removeObserver_ShouldRemoveObserver() {
        weatherData.registerObserver(mockDisplay);
        weatherData.removeObserver(mockDisplay);
        weatherData.setMeasurements(25.0f, 65.0f, 1013.0f);
        
        verify(mockDisplay, never()).update(anyFloat(), anyFloat(), anyFloat());
    }

    @Test
    @DisplayName("날씨 정보 변경 시 등록된 모든 옵저버에게 알림이 가야 한다")
    void notifyObservers_ShouldNotifyAllObservers() {
        weatherData.registerObserver(mockDisplay);
        weatherData.registerObserver(mockDisplay2);
        
        weatherData.setMeasurements(25.0f, 65.0f, 1013.0f);
        
        verify(mockDisplay).update(25.0f, 65.0f, 1013.0f);
        verify(mockDisplay2).update(25.0f, 65.0f, 1013.0f);
    }
} 