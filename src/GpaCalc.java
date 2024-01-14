package gpacalc;

import java.util.ArrayList;     // 순서가 있는 컬렉션을 정의하기 위함
import java.util.List;          // 배열에서의 추가 및 제거를 위함
import java.util.Scanner;

public class GpaCalc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Subject> subjects = new ArrayList<>();


        // 전공, 교양과목 입력을 받아서 Subject 리스트에 추가
        System.out.println("전공 과목명과 이수학점, 평점을 입력해주세요(예시: 자바프로그래밍-3-A+,머신러닝-3-B+):");
        addSubjects(scanner, subjects, "전공");

        System.out.println("교양 과목명과 이수학점, 평점을 입력해주세요(예시: 통계학-3-C0):");
        addSubjects(scanner, subjects, "교양");

        //subject 리스트를 통하여서 GradeCalculator 객체 생성
        GradeCalculator calculator = new GradeCalculator(subjects);
        calculator.printSubjectList();
        calculator.printGPA();
    }


    // 입력값을 Subject 객체 리스트에 추가
    private static void addSubjects(Scanner scanner, List<Subject> subjects, String type) {

        // 입력된 문자열을 ',' 기준으로 분류하여 배열에 저장
        String input = scanner.nextLine();
        String[] subjectInputs = input.split(",");


        // 각 과목 문자열을 '-'로 분할하여 과목명, 학점, 성적으로 나눔
        for (String subjectInput : subjectInputs) {
            String[] parts = subjectInput.split("-");

            // 분할된 문자열이 정확히 3부분으로 구성이 되어 있지 않으면 예외적용
            if (parts.length != 3) {
                throw new IllegalArgumentException("잘못된 형식입니다.");
            }

            // 객체 생성 및 리스트에 추가함
            subjects.add(new Subject(type, parts[0], Integer.parseInt(parts[1]), parts[2]));
        }
    }
}


// Subject 클래스 정의
class Subject {
    private String type;        // 과목의 유형 "전공" 또는 "교양"
    private String name;        // 과목의 이름
    private int credit;         // 학점
    private String grade;       // 성적

    //Subject 클래스 생성자
    public Subject(String type, String name, int credit, String grade) {
        this.type = type;
        this.name = name;
        this.credit = credit;
        this.grade = grade;
    }

    // 과목의 유형을 반환하는 메소드
    public String getType() {
        return type;
    }

    // 과목의 학점을 반환하는 메소드
    public int getCredit() {
        return credit;
    }

    // 성적을 숫자 값으로 변환하기 위함
    public double getGradeValue() {
        switch (grade) {
            case "A+": return 4.5;
            case "A0": return 4.0;
            case "B+": return 3.5;
            case "B0": return 3.0;
            case "C+": return 2.5;
            case "C0": return 2.0;
            case "D+": return 1.5;
            case "D0": return 1.0;
            case "F": return 0.0;
            default: return 0.0; // P/NP 과목은 평점 계산에서 제외
        }
    }

    // 불리언 값으로 성적이 "P" 또는 "NP"인지 확인
    public boolean isPassFailGrade() {
        return grade.equals("P") || grade.equals("NP");
    }

    //@Override
    public String toString() {
        return String.format("[%s] %s,%d,%s", type, name, credit, grade);
    }
}

// 객체들의 리스트를 통해서 평점을 계산하는 메소드
class GradeCalculator {
    private List<Subject> subjects;     // 객체들의 리스트를 저장함

    // 클래스의 생성자. 새로운 객체를 생성할 때 호출
    public GradeCalculator(List<Subject> subjects) {
        this.subjects = subjects;
    }

    // 저장된 과목 리스트를 출력
    public void printSubjectList() {
        System.out.println("<과목 목록>");
        for (Subject subject : subjects) {
            System.out.println(subject);
        }
    }

    // GPA 계산하고 출력한다.
    public void printGPA() {
        double totalGradePoints = 0.0;
        int totalCredits = 0;

        for (Subject subject : subjects) {
            if (!subject.isPassFailGrade()) {
                totalGradePoints += subject.getGradeValue() * subject.getCredit();
                totalCredits += subject.getCredit();
            }
        }

        double gpa = totalCredits > 0 ? totalGradePoints / totalCredits : 0.0;
        System.out.printf("<취득학점>\n%d학점\n", totalCredits);
        System.out.printf("<평점평균>\n%.2f / 4.5\n", gpa);
    }
}

