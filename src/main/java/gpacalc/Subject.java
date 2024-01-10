package gpacalc;


public class Subject {
    private final String name;
    private final int credit;
    private final Grade grade;

    public Subject(String name, int credit, Grade grade) {
        if (name.length()>10 || name.isBlank()) {
            throw new IllegalArgumentException("잘못된 과목명 입력입니다.");// 잘못된 과목명 입력시 예외처리
        }
        if (credit < 1 || credit > 4) {
            throw new IllegalArgumentException("잘못된 학점 입력입니다.");// 잘못된 학점 입력시 예외처리
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

    public int getAcquiredCredit() {// 취득학점 계산
        if (grade == Grade.NP || grade == Grade.F) {// NP, F인 경우 0학점
            return 0;
        }
        return credit;
    }
}
