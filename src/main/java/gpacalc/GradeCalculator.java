package gpacalc;

public class GradeCalculator {
    private Subject[] majorSubjects;
    private Subject[] nonMajorSubjects;
    private int acquiredCredit;
    private double majorGPA;

    private double gpa;

    public void run() {
        getSubjects();

        calculateAcquiredCreditAndGPA();

        printSubjectsResult();

        printCalculatedResult();
    }

    private void getSubjects() {
        majorSubjects=GradeCalculatorIO.inputMajorSubjects();
        System.out.println();

        nonMajorSubjects=GradeCalculatorIO.inputNonMajorSubjects();
        System.out.println();
    }

    private void printSubjectsResult() {
        System.out.println("<과목 목록>");
        GradeCalculatorIO.printSubjects(majorSubjects,"전공");
        GradeCalculatorIO.printSubjects(nonMajorSubjects,"교양");
        System.out.println();
    }

    private void printCalculatedResult() {
        GradeCalculatorIO.printAcquiredCredit(acquiredCredit);
        GradeCalculatorIO.printGPA(gpa);
        GradeCalculatorIO.printMajorGPA(majorGPA);
    }

    private void calculateAcquiredCreditAndGPA() {
        acquiredCredit=GradeCalculatorUtil.calculateAcquiredCredit(majorSubjects,nonMajorSubjects);
        gpa=GradeCalculatorUtil.calculateGPA(majorSubjects,nonMajorSubjects);
        majorGPA=GradeCalculatorUtil.calculateGPA(majorSubjects,new Subject[0]);
    }
}
