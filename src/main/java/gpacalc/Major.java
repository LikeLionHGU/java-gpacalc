package gpacalc;

import javax.security.auth.Subject;

public class Major {
    private String subjectName;
    private int subjectCredit;
    private String subjectGrade;

    Major(String subjectName, String subjectCredit, String subjectGrade) {
        setSubjectName(subjectName);
        setSubjectCredit(subjectCredit);
        setSubjectGrade(subjectGrade);
    }

    public String getSubjectName() {
        return subjectName;
    }
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
    public int getSubjectCredit() {
        return subjectCredit;
    }
    public void setSubjectCredit(String subjectCredit) {
        this.subjectCredit = Integer.parseInt(subjectCredit);
    }
    public String getSubjectGrade() {
        return subjectGrade;
    }
    public void setSubjectGrade(String subjectGrade) {
        this.subjectGrade = subjectGrade;
    }
}
