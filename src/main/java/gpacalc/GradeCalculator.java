package gpacalc;
import camp.nextstep.edu.missionutils.Console;

public class GradeCalculator {
    private Subject[] majorSubjects;
    private Subject[] nonMajorSubjects;
    private int acquiredCredit;
    private double majorAverage;
    private double average;

    public void run() {// 프로그램 실행
        inputMajorSubjects();// 전공 과목 입력
        System.out.println();
        inputNonMajorSubjects();// 교양 과목 입력
        System.out.println();
        calculate();// 취득 학점, 평점평균, 전공 평점평균 계산
        printResult();// 결과 출력
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

    private void printResult() {
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
        int totalGradeCredit = GradeCalculatorUtil.calculateTotalGradeCredit(majorSubjects, nonMajorSubjects);// 총 학점 계산
        acquiredCredit=GradeCalculatorUtil.calculateAcquiredCredit(majorSubjects,nonMajorSubjects);// 취득 학점 계산
        double weightedTotalGrade = GradeCalculatorUtil.calculateWeightedTotalGrade(majorSubjects, nonMajorSubjects);// 가중 평점 계산
        int majorGradeCredit = GradeCalculatorUtil.calculateTotalGradeCredit(majorSubjects, new Subject[0]);// 전공 과목 grade 학점 계산
        double weightedMajorGrade = GradeCalculatorUtil.calculateWeightedTotalGrade(majorSubjects, new Subject[0]);// 전공 과목 가중 평점 계산
        if (totalGradeCredit == 0) {
            average = 0;
        }else{
            average = weightedTotalGrade / totalGradeCredit;// 평점평균 계산
        }
        if (majorGradeCredit == 0) {
            majorAverage = 0;
        }else{
            majorAverage = weightedMajorGrade / majorGradeCredit;// 전공 평점평균 계산
        }
    }
}
