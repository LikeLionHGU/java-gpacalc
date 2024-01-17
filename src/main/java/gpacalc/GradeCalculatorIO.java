package gpacalc;

import camp.nextstep.edu.missionutils.Console;

public class GradeCalculatorIO {
    public static Subject[] inputMajorSubjects() {
        System.out.println("전공 과목명과 이수학점, 평점을 입력해주세요(예시: 프로그래밍언어론-3-A+,소프트웨어공학-3-B+):");
       return inputToSubjects(Console.readLine());
    }

    public static Subject[] inputNonMajorSubjects() {
        System.out.println("교양 과목명과 이수학점, 평점을 입력해주세요(예시: 선형대수학-3-C0,인간관계와자기성장-3-P):");
        return inputToSubjects(Console.readLine());
    }

    private static Subject[] inputToSubjects(String input){
        String[] subjectStrings = input.split(",");
        Subject[] subjects = new Subject[subjectStrings.length];
        for (int i = 0; i < subjectStrings.length; i++) {
            String[] subjectString = subjectStrings[i].split("-");
            subjects[i] = new Subject(subjectString[0], Integer.parseInt(subjectString[1]), Grade.of(subjectString[2]));
        }
        return subjects;
    }

    public static void printSubjects(Subject[] subjects, String type){
        for (Subject subject : subjects) {
            System.out.println("["+type+"] "+subject.getName() + "," + subject.getCredit() + "," + subject.getGrade().getGrade());
        }
    }

    public static void printAcquiredCredit(int acquiredCredit){
        System.out.println("<취득학점>");
        System.out.println(acquiredCredit + "학점");
        System.out.println();
    }

    public static void printGPA(double gpa){
        System.out.println("<평점평균>");
        System.out.println(String.format("%.2f", gpa) + " / 4.5");
        System.out.println();
    }

    public static void printMajorGPA(double majorGPA){
        System.out.println("<전공 평점평균>");
        System.out.println(String.format("%.2f", majorGPA) + " / 4.5");
        System.out.println();
    }
}
