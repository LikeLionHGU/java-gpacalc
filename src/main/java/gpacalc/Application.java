package gpacalc;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("전공 과목명과 이수학점, 평점을 입력해주세요(예시: 프로그래밍언어론-3-A+,소프트웨어공학-3-B+):");
        String majorLine = in.nextLine();     // 전공 입력

        System.out.println("교양 과목명과 이수학점, 평점을 입력해주세요(예시: 선형대수학-3-C0,인간관계와자기성장-3-P):");
        String generalLine = in.nextLine();   // 교양 입력

        // 변수들 생성하기
        int getCredits = 0;

        double totalWeightedSum = 0.0;
        int totalGpaCredits = 0;

        double majorWeightedSum = 0.0;
        int majorGpaCredits = 0;

        System.out.println("<과목 목록>");

        // 전공수업 확인하기
        String[] majors = majorLine.split(",");
        for (String raw : majors) {
            String[] info = parseAndValidate(raw); // [0]=name, [1]=credit, [2]=grade
            String name = info[0];
            int credit = parseCredit(info[1]);
            String grade = info[2];

            System.out.println("[전공] " + name + "," + credit + "," + grade);

            // 취득학점: F, NP 제외
            if (!grade.equals("F") && !grade.equals("NP")) {
                getCredits += credit;
            }

            // 평점평균: P, NP 제외
            if (!grade.equals("P") && !grade.equals("NP")) {
                double point = toPoint(grade);

                totalWeightedSum += point * credit;
                totalGpaCredits += credit;

                majorWeightedSum += point * credit;
                majorGpaCredits += credit;
            }
        }

        // 교양과목 확인
        String[] generals = generalLine.split(",");
        for (String raw : generals) {
            String[] info = parseAndValidate(raw);
            String name = info[0];
            int credit = parseCredit(info[1]);
            String grade = info[2];

            System.out.println("[교양] " + name + "," + credit + "," + grade);

            // 취득학점: F, NP 제외
            if (!grade.equals("F") && !grade.equals("NP")) {
                getCredits += credit;
            }

            // 평점평균: P, NP 제외
            if (!grade.equals("P") && !grade.equals("NP")) {
                double point = toPoint(grade);

                totalWeightedSum += point * credit;
                totalGpaCredits += credit;
            }
        }

        System.out.println("<취득학점>");
        System.out.println(getCredits + "학점");

        System.out.println("<평점평균>");
        double totalGpa = totalWeightedSum / totalGpaCredits;
        System.out.printf("%.2f/4.5\n", totalGpa);

        System.out.println("<전공 평점평균>");
        double majorGpa = majorWeightedSum / majorGpaCredits;
        System.out.println(majorGpa+"/ 4.5");
    }

    // 과목명-학점-성적 -이걸로 split 하고 길이 확인하기
    private static String[] parseAndValidate(String raw) {
        String t = raw.trim();
        String[] parts = t.split("-");
        if (parts.length != 3)
            throw new IllegalArgumentException();

        String name = parts[0].trim();
        String credit = parts[1].trim();
        String grade = parts[2].trim();


        validateGrade(grade); //검증해줘야 나중에 오류 X

        return new String[]{name, credit, grade};
    }

    private static void validateGrade(String grade) {
        String[] allowed = {"A+","A0","B+","B0","C+","C0","D+","D0","F","P","NP"};
        for (String g : allowed) {
            if (g.equals(grade))
                return;
        }
        throw new IllegalArgumentException();
    }

    // 학점 문자열 -> int 변환 + 1~4 확인하기
    private static int parseCredit(String creditStr) {
        int credit;
        try {
            credit = Integer.parseInt(creditStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        if (credit < 1 || credit > 4) throw new IllegalArgumentException();
        return credit;
    }

    private static double toPoint(String grade) {
        if (grade.equals("A+")) return 4.5;
        if (grade.equals("A0")) return 4.0;
        if (grade.equals("B+")) return 3.5;
        if (grade.equals("B0")) return 3.0;
        if (grade.equals("C+")) return 2.5;
        if (grade.equals("C0")) return 2.0;
        if (grade.equals("D+")) return 1.5;
        if (grade.equals("D0")) return 1.0;
        if (grade.equals("F"))  return 0.0;
        throw new IllegalArgumentException();
    }
}

