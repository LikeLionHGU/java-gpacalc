package gpacalc;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class SubjectsTest {
    Subjects subjects;

    @BeforeEach
    void setUp() {
        subjects = new Subjects();
    }

    @AfterEach
    void tearDown() {
        subjects = null;
    }

    @Test
    void isBlankTest() {
        assertThatThrownBy(() -> subjects.isBlank(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("과목명은 공백이 될 수 없습니다.");
    }
    @Test
    void 학점이_잘못된_경우() {
        //when
        subjects.input("프로그래밍언어-5-A0", "전공");

        //then
        assertThatThrownBy(() -> subjects.calculateCredit())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("학점은 1~4 사이의 숫자만 가능합니다.");
    }

    @Test
    void 성적이_잘못된_경우() {
        //when
        subjects.input("프로그래밍언어-3-S", "전공");

        //then
        assertThatThrownBy(() -> subjects.calculateGPA(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("성적은 A+, A0, B+, B0, C+, C0, D+, D0, F, P, NP만 가능합니다.");
    }
    @Test
    void calculateGPATest() {
        //given
        subjects.input("데이타구조-3-A0,자바프로그래밍언어-3-B+,컴퓨터구조-3-C0,컴퓨터네트워크-3-D+,미술의이해-3-P,교양특론3-1-NP,기독교의이해-2-F", null);

        //when
        String result = subjects.calculateGPA(null);
        //then
        assertEquals("2.36", result);
    }
}