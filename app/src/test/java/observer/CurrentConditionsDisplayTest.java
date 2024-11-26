package observer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;

@DisplayName("현재 날씨 조건 디스플레이 테스트")
class CurrentConditionsDisplayTest {
    private CurrentConditionsDisplay display;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        display = new CurrentConditionsDisplay();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    @DisplayName("날씨 정보가 변경되면 디스플레이가 업데이트되어야 한다")
    void testUpdate() {
        display.update(25.0f, 65.0f, 1013.0f);
        
        String output = outputStream.toString();
        assertTrue(output.contains("온도: 25.0°C"));
        assertTrue(output.contains("습도: 65.0%"));
        assertTrue(output.contains("기압: 1013.0hPa"));
    }

    @Test
    @DisplayName("현재 날씨 상태가 올바르게 표시되어야 한다")
    void testDisplay() {
        display.update(25.0f, 65.0f, 1013.0f);
        
        String output = outputStream.toString();
        assertTrue(output.contains("온도: 25.0°C"));
        assertTrue(output.contains("습도: 65.0%"));
        assertTrue(output.contains("기압: 1013.0hPa"));
    }
} 