package gpacalc;


public class Subject {
    private final String name;
    private final int credit;
    private final Grade grade;

    public Subject(String name, int credit, Grade grade) {
        if (name.length()>10 || name.isBlank()) {
            throw new IllegalArgumentException("잘못된 과목명 입력입니다.");
        }
        if (credit < 1 || credit > 4) {
            throw new IllegalArgumentException("잘못된 학점 입력입니다.");
        }
        this.name = name;
        this.credit = credit;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getCredit() {
        return credit;
    }

    public Grade getGrade() {
        return grade;
    }

    public int getAcquiredCredit() {
        if (grade == Grade.NP || grade == Grade.F) {
            return 0;
        }
        return credit;
    }
}
