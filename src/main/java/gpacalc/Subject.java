package gpacalc;


public class Subject {
    private final String name;
    private final int credit;
    private final Grade grade;

    public Subject(String name, int credit, Grade grade) {
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
