package gpacalc;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    //given
    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }


    @DisplayName("과목명 공백 검사")
    @Test
    void checkNamingException() {
        //when
        String lectureName = "    ";

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.checkNamingException(lectureName);
        });
    }

    @DisplayName("학점 범위 검사")
    @Test
    void checkScoreException() {

        //when
        int score = 6;

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.checkScoreException(score);
        });


    }

    @DisplayName("성적 범위 검사")
    @Test
    void checkRateException() {

        //when
        String grade = "E+";

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.checkRateException(grade);
        });
    }

    @DisplayName("평점평균 계산")
    @Test
    void printAverageOfAll() {


        List<String> lectureDump = Arrays.asList("데이타구조", "3", "A0", "자바프로그래밍언어", "3", "B+", "컴퓨터구조", "3", "C0",
                "네트워크", "3", "D+", "미술의이해", "3", "P", "교양특론", "1", "NP", "기독교의 이해", "2", "F");

        assertEquals(2.357142857142857, calculator.calculateElecInputIntoGPA(lectureDump));
    }


    @AfterEach
    void tearDown() {
        calculator = null;
    }


}