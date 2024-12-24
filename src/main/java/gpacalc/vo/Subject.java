package gpacalc.vo;

public class Subject {
    private String subjectName;
    private int credit;
    private String score;

    public Subject(String subjectName, int credit, String score) {
        this.subjectName = subjectName;
        this.credit = credit;
        this.score = score;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String toString() {
        return subjectName + "," + credit + "," + score;
    }
}
