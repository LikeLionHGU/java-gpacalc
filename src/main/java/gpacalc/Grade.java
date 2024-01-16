package gpacalc;

public enum Grade {
    A_PLUS(4.5, "A+"),
    A_ZERO(4.0, "A0"),
    B_PLUS(3.5, "B+"),
    B_ZERO(3.0, "B0"),
    C_PLUS(2.5, "C+"),
    C_ZERO(2.0, "C0"),
    D_PLUS(1.5, "D+"),
    D_ZERO(1.0, "D0"),
    P(0.0, "P"),
    NP(0.0, "NP"),
    F(0.0, "F");

    private final double score;
    private final String grade;

    Grade(double score, String grade) {
        this.score = score;
        this.grade = grade;
    }

    public double getScore() {
        return score;
    }

    public String getGrade() {
        return grade;
    }

    public static Grade of(String grade) {
        for (Grade value : values()) {
            if (value.grade.equals(grade)) {
                return value;
            }
        }
        throw new IllegalArgumentException("해당하는 등급이 없습니다.");
    }
}
