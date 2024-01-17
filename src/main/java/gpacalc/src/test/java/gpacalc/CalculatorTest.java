package gpacalc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;

import static org.junit.jupiter.api.Assertions.*;
class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @DisplayName("전체 학점 평균 테스트")
    @Test
    void allAverageTest() {
        //when
        String[][] input = {{"데이타구조","3","A0"},{"자바프로그래밍언어","3","B+"},{"컴퓨터구조","3","C0"},{"컴퓨터네트워크","3","D+"}};
        double result = calculator.getAllAverage(input,input);
        //then
        assertEquals(2.75, result);
    }

    @DisplayName("전공 학점 평균 테스트")
    @Test
    void majorAverageTest() {
        //when
        String[][] input = {{"데이타구조","3","A0"},{"자바프로그래밍언어","3","B+"},{"컴퓨터구조","3","C0"},{"컴퓨터네트워크","3","D+"}};
        double result = calculator.getMajorAverage(input);
        //then
        assertEquals(2.75, result);
    }

}