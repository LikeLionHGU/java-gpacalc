package gpacalc;


import java.util.ArrayList;
import java.util.List;

public class Subjects {
    private List<Subject> subjectList;

    public Subjects() {
        this.subjectList = new ArrayList<>();
    }

    public class Subject {
        private String name;
        private int credit;
        private String grade;
        private String type;

        public Subject(String name, int credit, String grade, String type) {
            this.name = name;
            this.credit = credit;
            this.grade = grade;
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public int getCredit() {
            return credit;
        }

        public String getGrade() {
            return grade;
        }

        public String getType() {
            return type;
        }

        @Override
        public String toString() {
            return "[" + type + "] " + name + "," + credit + "," + grade;
        }
    }

    public void input(String input, String type) {
        String[] subjectsInfo = input.split(",");
        for (String subjectInfo : subjectsInfo) {
            String[] info = subjectInfo.split("-");

            String name = info[0].trim();
            int credit = Integer.parseInt(info[1].trim());
            String grade = info[2].trim();
            Subject subject = new Subject(name, credit, grade, type);
            subjectList.add(subject);
        }
    }

    public void print() {
        for (Subject subject : subjectList) {
            System.out.println(subject);
        }
    }

    public int calculateCredit() {
        int totalCredit = 0;
        for (Subject subject : subjectList) {
            totalCredit += subject.getCredit();
        }
        return totalCredit;
    }

    public String calculateAverage() {//
        int totalCredit = 0;
        double totalGrade = 0.0;
        for (Subject subject : subjectList) {
            totalCredit += subject.getCredit();
            totalGrade += convertGradeToGPA(subject.getGrade()) * subject.getCredit();
        }
        double average = totalGrade / totalCredit;
        return String.format("%.2f", average);
    }

    public String calculateAverage(String type) {
        int totalCredit = 0;
        double totalGrade = 0.0;
        for (Subject subject : subjectList) {
            if (subject.getType().equals(type)) {
                totalCredit += subject.getCredit();
                totalGrade += convertGradeToGPA(subject.getGrade()) * subject.getCredit();
            }
        }
        double average = totalGrade / totalCredit;
        return String.format("%.2f", average);
    }

    private double convertGradeToGPA(String grade) {
        switch (grade) {
            case "A+":
                return 4.5;
            case "A":
                return 4.0;
            case "B+":
                return 3.5;
            case "B":
                return 3.0;
            case "C+":
                return 2.5;
            case "C":
                return 2.0;
            case "D+":
                return 1.5;
            case "D":
                return 1.0;
            case "F":
                return 0.0;
            case "P":
                return 0.0;
            case "NP":
                return 0.0;
            default:
                return 0.0;
        }
    }
}
