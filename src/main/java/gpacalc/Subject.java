package gpacalc;

public class Subject {
    private String Name;
    private String Credit;
    private String Grade;

    public Subject(String Name, String Credit, String Grade) {
        this.Name = Name;
        this.Credit = Credit;
        this.Grade = Grade;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCredit() {
        return Credit;
    }

    public void setCredit(String credit) {
        Credit = credit;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String grade) {
        this.Grade = grade;
    }
}




