package observer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;

@DisplayName("날씨 통계 디스플레이 테스트")
class StatisticsDisplayTest {
    private StatisticsDisplay display;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        display = new StatisticsDisplay();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    @DisplayName("평균, 최대, 최소 온도가 올바르게 계산되어야 한다")
    void testUpdate() {
        // 첫 번째 업데이트
        display.update(25.0f, 65.0f, 1013.0f);
        // 두 번째 업데이트
        display.update(27.0f, 70.0f, 1014.0f);
        
        String output = outputStream.toString();
        assertTrue(output.contains("평균 온도: 26.0°C"));
        assertTrue(output.contains("최고 온도: 27.0°C"));
        assertTrue(output.contains("최저 온도: 25.0°C"));
    }

    @Test
    @DisplayName("통계 정보가 올바른 형식으로 표시되어야 한다")
    void testDisplay() {
        display.update(-10.0f, 65.0f, 1013.0f);
        display.update(40.0f, 70.0f, 1014.0f);
        
        String output = outputStream.toString();
        assertTrue(output.contains("최고 온도: 40.0°C"));
        assertTrue(output.contains("최저 온도: -10.0°C"));
    }
} 