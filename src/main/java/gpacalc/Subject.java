package gpacalc;

public class Subject {
    private final String[] grades = {"A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F", "P", "NP"};
    private final double[] gradeNumbers = {4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0, -1};
    private String title;
    private int credit;
    private String grade;
    private double gradeNumber;

    public Subject(String title, int credit, String grade) {
        try {
            setTitle(title);
            setCredit(credit);
            setGrade(grade);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws IllegalArgumentException {
        if (title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        if (title.length() > 10) {
            throw new IllegalArgumentException("Title is too long");
        }
        this.title = title;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        if (credit < 1 || credit > 4) {
            throw new IllegalArgumentException("Credit must be between 1 and 4");
        }
        this.credit = credit;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        for (int i = 0; i < 9; i++) {
            if (grade.equals(grades[i])) {
                this.grade = grades[i];
                setGradeNumber(i);
                return;
            }
        }
        if (grade.equals(grades[9])) { // P인 경우
            this.grade = grades[9];
            setGradeNumber(9); // P/NP인 경우 gradeNumber 에 -1을 넣어준다
            return;
        } else if (grade.equals(grades[10])) { // NP인 경우
            this.grade = grades[10];
            setGradeNumber(9); // P/NP인 경우 gradeNumber 에 -1을 넣어준다
            return;
        }
        throw new IllegalArgumentException("Grade is not correct");
    }

    public double getGradeNumber() {
        return gradeNumber;
    }

    public void setGradeNumber(int index) {
        this.gradeNumber = gradeNumbers[index];
    }

    @Override
    public String toString() {
        return getTitle() + "," + getCredit() + "," + getGrade();
    }
}
