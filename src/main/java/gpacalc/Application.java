package gpacalc;

import camp.nextstep.edu.missionutils.Console;
import gpacalc.util.ScoreValue;
import gpacalc.util.Sepearate;
import gpacalc.vo.Subject;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        //TODO: 구현
        ArrayList<String> majorString = new ArrayList<>();
        ArrayList<String> generalString = new ArrayList<>();
        ArrayList<Subject> major = new ArrayList<>();
        ArrayList<Subject> general = new ArrayList<>();

        System.out.println("전공 과목명과 이수학점, 평점을 입력해주세요(예시: 프로그래밍언어론-3-A+,소프트웨어공학-3-B+):");
        String majorInput = Console.readLine();
        System.out.println("교양 과목명과 이수학점, 평점을 입력해주세요(예시: 선형대수학-3-C0,인간관계와자기성장-3-P):");
        String generalInput = Console.readLine();

        majorString = Sepearate.separateByComma(majorInput);
        generalString = Sepearate.separateByComma(generalInput);

        major = Sepearate.separateByHyphen(majorString);
        general = Sepearate.separateByHyphen(generalString);

        int total_credit = 0;
        int total_credit_average = 0;
        double weight_total = 0.0;
        for (Subject s : major) {
            if (!s.getScore().equals("NP") && !s.getScore().equals("F")) {
                total_credit += s.getCredit();
            }

            if (!s.getScore().equals("P") && !s.getScore().equals("NP")) {
                total_credit_average += s.getCredit();
                weight_total += calculateWeight(s.getScore(), s.getCredit());
            }
        }
        double majorScore = (double) Math.round(weight_total / total_credit_average * 100) /100;

        for (Subject s : general) {
            if (!s.getScore().equals("NP") && !s.getScore().equals("F")) {
                total_credit += s.getCredit();
            }
            if (!s.getScore().equals("P") && !s.getScore().equals("NP")) {
                total_credit_average += s.getCredit();
                weight_total += calculateWeight(s.getScore(), s.getCredit());
            }
        }
        double allScore =  (double) Math.round(weight_total / total_credit_average * 100) /100;

        System.out.println("\n<과목 목록>");
        for (Subject s : major) {
            System.out.print("[전공] ");
            System.out.println(s.toString());
        }
        for (Subject s : general) {
            System.out.print("[교양] ");
            System.out.println(s.toString());
        }

        System.out.println("\n<취득학점>");
        System.out.println(total_credit+"학점\n");
        System.out.println("<평점평균>");
        System.out.println(allScore + " / 4.5\n");
        System.out.println("<전공 평점평균>");
        System.out.println(majorScore + " / 4.5");

    }

    public static double calculateWeight(String score, int credit) {
        return ScoreValue.findValue(score) * credit;
    }
}
