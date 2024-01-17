package gpacalc;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SubjectTest {

    @Test
    void 과목명_유효성_검사() {
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
    @Test
    void 과목명_유효성_검사2() {
        // given
        String name = "";
        String credit = "3";
        String grade = "A+";

        // when and then
        Assertions.assertThatIllegalArgumentException().isThrownBy(
                () -> new Majors(name, credit, grade)
        ).withMessage("이름은 1자 이상 10자 이하여야 합니다.");
    }


    @Test
    void 학점_유효성_검사() {
        //given
        String name = "데이터베이스";
        String credit = "5";
        String grade = "A+";

        //when

        //then
        Assertions.assertThatIllegalArgumentException().isThrownBy(
                () -> new Majors(name, credit, grade)
        );
    }

    @Test
    void 다양한_과목에_대한_테스트_코드() {
        // given
        Majors major1 = new Majors("과목1", "3", "A+");
        Majors major2 = new Majors("과목2", "2", "B0");
        Refinements ref1 = new Refinements("과목3", "3", "C+");
        Refinements ref2 = new Refinements("과목4", "1", "D0");

        // when
        float expectedScore1 = 4.5f;
        float expectedAverage1 = expectedScore1 * Integer.parseInt("3");

        float expectedScore2 = 3.0f;
        float expectedAverage2 = expectedScore2 * Integer.parseInt("2");

        float expectedScore3 = 2.5f;
        float expectedAverage3 = expectedScore3 * Integer.parseInt("3");

        float expectedScore4 = 1.0f;
        float expectedAverage4 = expectedScore4 * Integer.parseInt("1");

        // then
        Assertions.assertThat(major1.getScore()).isEqualTo(expectedScore1);
        Assertions.assertThat(major1.getAverage()).isEqualTo(expectedAverage1);

        Assertions.assertThat(major2.getScore()).isEqualTo(expectedScore2);
        Assertions.assertThat(major2.getAverage()).isEqualTo(expectedAverage2);

        Assertions.assertThat(ref1.getScore()).isEqualTo(expectedScore3);
        Assertions.assertThat(ref1.getAverage()).isEqualTo(expectedAverage3);

        Assertions.assertThat(ref2.getScore()).isEqualTo(expectedScore4);
        Assertions.assertThat(ref2.getAverage()).isEqualTo(expectedAverage4);
    }
}