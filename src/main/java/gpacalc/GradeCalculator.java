package gpacalc;
import static camp.nextstep.edu.missionutils.Console.readLine;
import camp.nextstep.edu.missionutils.Console;

public class GradeCalculator {
    private Subject[] majorSubjects;
    private Subject[] nonMajorSubjects;

    private int acquiredCredit;
    private double majorAverage;
    private double average;

    public void run() {
        inputMajorSubjects();
        System.out.println();
        inputNonMajorSubjects();
        System.out.println();
        calculate();
        printData();
        System.out.println();

    }

    private void inputMajorSubjects() {
        System.out.println("전공 과목명과 이수학점, 평점을 입력해주세요(예시: 프로그래밍언어론-3-A+,소프트웨어공학-3-B+):");
        String input = Console.readLine();
        String[] subjectStrings = input.split(",");
        majorSubjects = new Subject[subjectStrings.length];
        for (int i = 0; i < subjectStrings.length; i++) {
            String[] subjectString = subjectStrings[i].split("-");
            majorSubjects[i] = new Subject(subjectString[0], Integer.parseInt(subjectString[1]), Grade.of(subjectString[2]));
        }
    }

    private void inputNonMajorSubjects() {
        System.out.println("교양 과목명과 이수학점, 평점을 입력해주세요(예시: 선형대수학-3-C0,인간관계와자기성장-3-P):");
        String input = Console.readLine();
        String[] subjectStrings = input.split(",");
        nonMajorSubjects = new Subject[subjectStrings.length];
        for (int i = 0; i < subjectStrings.length; i++) {
            String[] subjectString = subjectStrings[i].split("-");
            nonMajorSubjects[i] = new Subject(subjectString[0], Integer.parseInt(subjectString[1]), Grade.of(subjectString[2]));
        }
    }

    private void printData() {
        System.out.println("<과목 목록>");
        for (Subject subject : majorSubjects) {
            System.out.println("[전공] " + subject.getName() + "," + subject.getCredit() + "," + subject.getGrade().getGrade());
        }
        for (Subject subject : nonMajorSubjects) {
            System.out.println("[교양] " + subject.getName() + "," + subject.getCredit() + "," + subject.getGrade().getGrade());
        }
        System.out.println();
        System.out.println("<취득학점>");
        System.out.println(acquiredCredit + "학점");
        System.out.println();
        System.out.println("<평점평균>");
        System.out.println(String.format("%.2f", average) + " / 4.5");
        System.out.println();
        System.out.println("<전공 평점평균>");
        System.out.println(String.format("%.2f", majorAverage) + " / 4.5");
    }

    private void calculate() {
        int totalGradeCredit = GradeCalculatorUtil.calculateTotalGradeCredit(majorSubjects, nonMajorSubjects);
        acquiredCredit=GradeCalculatorUtil.calculateAcquiredCredit(majorSubjects,nonMajorSubjects);
        double weightedTotalGrade = GradeCalculatorUtil.calculateWeightedTotalGrade(majorSubjects, nonMajorSubjects);
        int majorGradeCredit = GradeCalculatorUtil.calculateTotalGradeCredit(majorSubjects, new Subject[0]);
        double weightedMajorGrade = GradeCalculatorUtil.calculateWeightedTotalGrade(majorSubjects, new Subject[0]);
        average = weightedTotalGrade / totalGradeCredit;
        majorAverage = weightedMajorGrade / majorGradeCredit;
    }
}
