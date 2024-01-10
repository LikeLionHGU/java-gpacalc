package gpacalc;

public class GradeCalculatorUtil {
    public static int calculateAcquiredCredit(Subject[] majorSubjects, Subject[] nonMajorSubjects) {
        int majorCredit = 0;
        int nonMajorCredit = 0;
        for (Subject subject : majorSubjects) {
            majorCredit += subject.getAcquiredCredit();
        }
        for (Subject subject : nonMajorSubjects) {
            nonMajorCredit += subject.getAcquiredCredit();
        }
        return majorCredit + nonMajorCredit;
    }

    public static int calculateTotalGradeCredit(Subject[] majorSubjects, Subject[] nonMajorSubjects) {
        int majorCredit = 0;
        int nonMajorCredit = 0;
        for (Subject subject : majorSubjects) {
            if(subject.getGrade() != Grade.NP && subject.getGrade() != Grade.P)
                majorCredit += subject.getCredit();
        }
        for (Subject subject : nonMajorSubjects) {
            if(subject.getGrade() != Grade.NP && subject.getGrade() != Grade.P)
                nonMajorCredit += subject.getCredit();
        }
        return majorCredit + nonMajorCredit;
    }

    public static double calculateWeightedTotalGrade(Subject[] majorSubjects, Subject[] nonMajorSubjects) {
        double majorTotalGrade = 0;
        double nonMajorTotalGrade = 0;
        for (Subject subject : majorSubjects) {
            majorTotalGrade += subject.getGrade().getScore() * subject.getCredit();
        }
        for (Subject subject : nonMajorSubjects) {
            nonMajorTotalGrade += subject.getGrade().getScore() * subject.getCredit();
        }
        return majorTotalGrade + nonMajorTotalGrade;
    }
}
