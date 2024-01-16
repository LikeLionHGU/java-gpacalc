package gpacalc;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GradeTest {

    @Test
    void 허용되지않는성적예외처리() {
        assertThatThrownBy(() -> Grade.of("PD"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}