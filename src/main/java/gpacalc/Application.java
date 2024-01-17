package gpacalc;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Vector;

public class Application {
    public static void main(String[] args) {
        Vector<Majors> majorSubjects = new Vector<Majors>();
        Vector<Refinements> refinementSubjects = new Vector<Refinements>();

        System.out.println("전공 과목명과 이수학점, 평점을 입력해주세요(예시: 데이타구조-3-A0,자바프로그래밍언어-3-B+,컴퓨터구조-3-C0,컴퓨터네트워크-3-D+):");
        String input = readLine();
        String[] majorSubjectsInfo = input.split(",|-");


        try {
            if (input.isBlank()) {
                throw new IllegalArgumentException("공백 오류");
            }
        }
        catch (IllegalArgumentException e) {
            System.err.println("오류: " + e.getMessage());
            System.exit(1);
        }

        for (int i = 0; i < majorSubjectsInfo.length / 3; i++) {
            int index = i * 3;
            Majors m = new Majors(majorSubjectsInfo[index], majorSubjectsInfo[index + 1], majorSubjectsInfo[index + 2]);
            majorSubjects.add(m);
        }


        System.out.println("교양 과목명과 이수학점, 평점을 입력해주세요(예시: 선형대수학-3-C0,인간관계와자기성장-3-P):");
        input = readLine();

        try {
            if (input.isBlank()) {
                throw new IllegalArgumentException("공백 오류");
            }
        }
        catch (IllegalArgumentException e) {
            System.err.println("오류: " + e.getMessage());
            System.exit(1);
        }

        String[] refinementSubjectsInfo = input.split(",|-");
        for (int i = 0; i < refinementSubjectsInfo.length / 3; i++) {
            int index = i * 3;
            Refinements r = new Refinements(refinementSubjectsInfo[index], refinementSubjectsInfo[index + 1], refinementSubjectsInfo[index + 2]);
            refinementSubjects.add(r);
        }

        GpaCalculator calculator = new GpaCalculator(majorSubjects, refinementSubjects);

        calculator.printSubjectList();
        calculator.printTotalGain();
        calculator.printAverage();
    }
}
