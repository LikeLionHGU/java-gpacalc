package gpacalc;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    //given
    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @AfterEach
    void tearDown() {
        calculator = null;
    }

    @DisplayName("과목명 공백 검사")
    @Test
    void checkNamingException() {
        String input="   ";

        assertThrows(IllegalArgumentException.class, () -> {
            calculator.checkNamingException(input);
        });
    }

    @DisplayName("학점 범위 검사")
    @Test
    void checkScoreException() {

    }

    @DisplayName("성적 범위 검사")
    @Test
    void checkRateException() {

    }

    @DisplayName("평점평균 계산")
    @Test
    void printAverageOfAll() {

    }
}