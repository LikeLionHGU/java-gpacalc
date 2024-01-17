package gpacalc;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RefinementsTest {

    // 과목명 유효성 검사
    @Test
    void validateSubjectName_WhenEmptyString_ThrowsIllegalArgumentException() {
        assertThatThrownBy(() -> new Refinements("", "3", "A+"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 10자 이하여야 합니다.");
    }

    // 학점 유효성 검사
    @Test
    void validateCredit_WhenInvalidValue_ThrowsIllegalArgumentException() {
        assertThatThrownBy(() -> new Refinements("Math", "5", "A+"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 학점 값입니다. 1에서 4 사이어야 합니다.");
    }

    // 성적 유효성 검사
    @Test
    void validateGrade_WhenInvalidValue_ThrowsIllegalArgumentException() {
        assertThatThrownBy(() -> new Refinements("Math", "3", "Z+"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("지원하지 않는 학점입니다.");
    }

    // 평점평균 계산 정확성 검사
    @Test
    void calculateAverage_GivenValidData_CalculatesCorrectly() {
        Refinements subject = new Refinements("Math", "3", "A+");
        assertThat(subject.getAverage()).isEqualTo(13.5f);
    }
}
