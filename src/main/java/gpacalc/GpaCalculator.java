package gpacalc;

import java.util.Vector;

public class GpaCalculator {
    private Vector<Majors> majorSubjects;
    private Vector<Refinements> refinementSubjects;

    public GpaCalculator(Vector<Majors> majorSubjects, Vector<Refinements> refinementSubjects) {
        this.majorSubjects = majorSubjects;
        this.refinementSubjects = refinementSubjects;
    }

    public void printSubjectList() {
        System.out.println("<과목 목록>");
        for (Majors major : majorSubjects) {
            System.out.println(major.toString());
        }
        for (Refinements refinement : refinementSubjects) {
            System.out.println(refinement.toString());
        }
    }

    public void printTotalGain() {
        int majorGainForGain = 0;
        int refinementGainforGain = 0;

        for (Majors major : majorSubjects) {
            majorGainForGain += major.getGainForTotal();
        }

        for (Refinements refinement : refinementSubjects) {
            refinementGainforGain += refinement.getGainForTotal();
        }

        System.out.println("<취득학점>");
        System.out.println(majorGainForGain + refinementGainforGain + "학점");
    }

    public void printAverage() {
        float majorGradeWeight = 0;
        float refinementGainWeight = 0;
        int majorGain = 0;
        int refinementGain = 0;

        for (Majors major : majorSubjects) {
            majorGradeWeight += major.getAverage();
            majorGain += major.getGainForAverage();
        }

        for (Refinements refinement : refinementSubjects) {
            refinementGain += refinement.getGainForAverage();
            refinementGainWeight += refinement.getAverage();
        }

        System.out.println("<평점평균>");
        float totalWeightedScore = majorGradeWeight + refinementGainWeight;
        float totalGain = majorGain + refinementGain;
        float totalGpa = totalWeightedScore / totalGain;
        System.out.printf("%.2f / 4.5\n", totalGpa);

        System.out.println("<전공 평점평균>");
        float majorGpa = majorGradeWeight / majorGain;
        System.out.printf("%.2f / 4.5\n", majorGpa);
    }
}
