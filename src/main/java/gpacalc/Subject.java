package gpacalc;


public class Subject {

    private static final int MAX_CREDIT = 4;

    private static final int MIN_CREDIT = 1;

    private static final int MAX_NAME_LENGTH = 10;

    private final String name;
    private final int credit;
    private final Grade grade;

    public Subject(String name, int credit, Grade grade) {
        checkNameValidation(name);
        checkCreditValidation(credit);
        this.name = name;
        this.credit = credit;
        this.grade = grade;
    }

    private void checkNameValidation(String name) {
        if (name.length()>MAX_NAME_LENGTH || name.isBlank()) {
            throw new IllegalArgumentException("잘못된 과목명 입력입니다.");
        }
    }

    private void checkCreditValidation(int credit) {
        if (credit < MIN_CREDIT || credit > MAX_CREDIT) {
            throw new IllegalArgumentException("잘못된 학점 입력입니다.");
        }
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
