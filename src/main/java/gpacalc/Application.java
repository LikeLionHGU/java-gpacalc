package gpacalc;
import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        Subjects subjects = new Subjects();

        System.out.println("전공 과목명과 이수학점, 평점을 입력해주세요(예시: 프로그래밍언어론-3-A+,소프트웨어공학-3-B+):");
        String major = Console.readLine();

        subjects.input(major, "전공");

        System.out.println("교양 과목명과 이수학점, 평점을 입력해주세요(예시: 선형대수학-3-C0,인간관계와자기성장-3-P):");
        String GE = Console.readLine();

        subjects.input(GE, "교양");
        System.out.println();

        System.out.println("<과목 목록>");
        subjects.print();
        System.out.println();

        System.out.println("<취득학점>");
        int credit = subjects.calculateCredit();
        System.out.println(credit + "학점");
        System.out.println();

        System.out.println("<평점평균>");
        String average = subjects.calculateAverage();
        System.out.println(average + " / 4.5");
        System.out.println();

        System.out.println("<전공 평점평균>");
        String majorAverage = subjects.calculateAverage("전공");
        System.out.println(majorAverage + " / 4.5");
    }
}
