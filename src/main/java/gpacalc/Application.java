package gpacalc;

import static camp.nextstep.edu.missionutils.Console.readLine;

//import gpacalc.Subject; ...

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        //TODO: 구현

        String input_M;
        String input_G;
        ArrayList<Subject> subjects_M = new ArrayList<>();
        ArrayList<Subject> subjects_G = new ArrayList<>();
        Operator op = new Operator();

        System.out.println("전공 과목명과 이수학점, 평점을 입력해주세요(예시: 프로그래밍언어론-3-A+,소프트웨어공학-3-B+):");
        input_M = readLine();

        String[] input_Ms = input_M.split(",");

        for (String inputM : input_Ms) {
            String[] info = inputM.split("-");
            Subject sub = new Subject(info[0], info[1], info[2]);
            subjects_M.add(sub);
        }

        System.out.println("교양 과목명과 이수학점, 평점을 입력해주세요(예시: 선형대수학-3-C0,인간관계와자기성장-3-P):");
        input_G = readLine();
        String[] input_Gs = input_G.split(",");
        for (String inputG : input_Gs) {
            String[] info = inputG.split("-");
            Subject sub = new Subject(info[0], info[1], info[2]);
                subjects_G.add(sub);
        }

        op.checkGradeError(subjects_M, subjects_G);
        op.checkCreditError(subjects_M, subjects_G);



        System.out.println("<과목 목록>");
        op.listOfSubjects(subjects_M, subjects_G);


        System.out.println("\n<취득학점>");
        System.out.print(op.getCredit(subjects_M, subjects_G));
        System.out.println("학점");

        System.out.println("\n<평점평균>");
        System.out.print(Math.round(op.averageAllScore(subjects_M, subjects_G) * 100) / 100.0);
        System.out.println(" / 4.5");

        System.out.println("\n<전공 평점평균>");
        System.out.print(op.averageMajorScore(subjects_M, subjects_G));
        System.out.println(" / 4.5");


    }
}
