package gpacalc;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {
	Method method = new Method();
	CheckException checkException = new CheckException();

	@Test
	void checkSubjectLength() {
		Exception exception = assertThrows(IllegalArgumentException.class, () ->
			checkException.checkSubjectLength(" ")
		);
	}

	@Test
	void checkGradeRange() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			checkException.checkGradeRange("E0");
			}
		);
	}

	@Test
	void checkCreditRange() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			checkException.checkCreditRange(0);
			}
		);

		Exception exception1 = assertThrows(IllegalArgumentException.class, () -> {
			checkException.checkCreditRange(5);
			}
		);
	}

	@Test
	void calculate() {
		assertThat(method.calculate("데이타구조-3-A0,자바프로그래밍언어-3-B+,컴퓨터구조-3-C0,컴퓨터네트워크-3-D+,미술의이해-3-P,교양특론3-1-NP,기독교의이해-2-F", 15)).as("계산에 오류가 있습니다.").isEqualTo(2.36);
	}
}