package gpacalc;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SubjectTest {

    @Test
    void 과목명이공백만으로입력된경우예외처리() {
        assertThatThrownBy(() -> new Subject("  ", 3, Grade.A_ZERO))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Subject("     ", 3, Grade.A_ZERO))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 학점이범위밖인경우예외처리() {
        assertThatThrownBy(() -> new Subject("실전프로젝트", 0, Grade.A_ZERO))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Subject("실전프로젝트", 6, Grade.A_ZERO))
                .isInstanceOf(IllegalArgumentException.class);
    }
}