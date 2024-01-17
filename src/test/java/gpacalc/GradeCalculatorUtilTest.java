package gpacalc;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GradeCalculatorUtilTest {
    //given
    Subject [] majorSubjects1;
    Subject [] majorSubjects2;
    Subject [] nonMajorSubjects1;
    Subject [] nonMajorSubjects2;
    @BeforeEach
    void setup(){
        majorSubjects1 = new Subject[]{
                new Subject("데이타구조", 3, Grade.A_ZERO),
                new Subject("자바프로그래밍언어", 3, Grade.B_PLUS)
        };
        nonMajorSubjects1 = new Subject[]{
                new Subject("미술의이해", 3, Grade.A_PLUS),
                new Subject("교양특론3", 3, Grade.NP)
        };
        majorSubjects2 = new Subject[]{
                new Subject("데이타구조", 3, Grade.A_ZERO)
        };
        nonMajorSubjects2 = new Subject[]{
                new Subject("미술의이해", 2, Grade.B_ZERO)
        };
    }
    @Test
    void 평점평균계산테스트() {
        assertEquals(4.0, GradeCalculatorUtil.calculateGPA(majorSubjects1, nonMajorSubjects1));
        assertEquals(3.6, GradeCalculatorUtil.calculateGPA(majorSubjects2, nonMajorSubjects2));
    }

    @AfterEach void tearDown() {
        majorSubjects1 = null;
        majorSubjects2 = null;
        nonMajorSubjects1 = null;
        nonMajorSubjects2 = null;
    }
}