package gpacalc;

public enum Grade {
    A_PLUS(4.5),
    A_ZERO(4.0),
    B_PLUS(3.5),
    B_ZERO(3.0),
    C_PLUS(2.5),
    C_ZERO(2.0),
    D_PLUS(1.5),
    D_ZERO(1.0),
    P(0),
    NP(0),
    F(0);

    private final double score;

    Grade(double score) {
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public static Grade of(String grade) {
        return Grade.valueOf(grade);
    }
}
