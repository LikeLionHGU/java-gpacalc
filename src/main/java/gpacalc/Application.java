package gpacalc;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Method method = new Method();

        System.out.println("전공 과목명과 이수학점, 평점을 입력해주세요(예시: 프로그래밍언어론-3-A+,소프트웨어공학-3-B+):");
        String major = Console.readLine();
        System.out.println("교양 과목명과 이수학점, 평점을 입력해주세요(예시: 선형대수학-3-C0,인간관계와자기성장-3-P):");
        String liberal = Console.readLine();

        System.out.println("<과목 목록>");
        method.categorize(major, "전공");
        method.categorize(liberal, "교양");
        System.out.println();

        int credit = method.getCredit(major) + method.getCredit(liberal);
        System.out.println("<취득학점>");
        System.out.println(credit + "학점\n");

        System.out.println("<평점평균>");
        System.out.println(method.calculate(major + "," + liberal ,credit) + " / 4.5\n");

        System.out.println("<전공 평점평균>");
        System.out.println(method.calculate(major, method.getCredit(major)) + " / 4.5\n");

        return;
    }
}
