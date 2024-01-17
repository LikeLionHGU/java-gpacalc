package gpacalc;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MajorsTest {

    @Test
    void 이름_10글자이상이면_예외처리() {
        //given
        String name = "데이터베이스가나다라마바사";
        String credit = "3";
        String grade = "A+";

        //when

        //then
        Assertions.assertThatIllegalArgumentException().isThrownBy(
                () -> new Majors(name, credit, grade)
        );
    }

}