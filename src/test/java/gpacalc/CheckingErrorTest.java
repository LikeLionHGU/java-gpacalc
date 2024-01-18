package gpacalc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;

import static org.junit.jupiter.api.Assertions.*;

class CheckingErrorTest {

    CheckingError checkingError;

    @BeforeEach
    public void setUp() {
        checkingError = new CheckingError();
    }

    @DisplayName("공백 메서드 테스트")
    @Test
    void checkError() {
        //when
        String[][] num = {{"   ", "   "}, {"   ", "     "}};
        //then
        assertThrows(IllegalArgumentException.class, () -> {
            checkingError.checkError(num);
        });
    }

    @DisplayName("학점 범위 테스트")
    @Test
    void checkPointException() {

        //when
        String[][] mem = {{"데이타구조","5","A0"},{"자바프로그래밍언어","3","B+"},{"컴퓨터구조","3","C0"},{"컴퓨터네트워크","3","D+"}};

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            checkingError.checkError(mem);
        });

    }

    @DisplayName("성적 범위 테스트")
    @Test
    void checkScoreException() {

        //when
        String[][] mem = {{"데이타구조","2","A0"},{"자바프로그래밍언어","3","P+"},{"컴퓨터구조","3","C0"},{"컴퓨터네트워크","3","D+"}};

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            checkingError.checkError(mem);
        });

    }
}



