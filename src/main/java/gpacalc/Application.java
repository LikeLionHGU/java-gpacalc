package gpacalc;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;


public class Application {
    public static void main(String[] args) {
        //TODO: 구현

        Student student = new Student();
        ArrayList<Major> majors = new ArrayList<Major>();
        ArrayList<GeneralEducation> generals = new ArrayList<GeneralEducation>();
        System.out.println("전공 과목명과 이수학점, 평점을 입력해주세요(예시: 프로그래밍언어론-3-A+,소프트웨어공학-3-B+):");
        String input  = Console.readLine();
        if (input.trim().equals("")) {
            throw new IllegalArgumentException("공백으로만 구성됨");
        }
        String[] subject = input.split(",");
        for (int i = 0; i < subject.length; i++) {
            String[] token = subject[i].split("-");
            if (token.length != 3) {
                throw new IllegalArgumentException("입력 형식 오류");
            }
            String subjectName = token[0];
            String subjectCredit = token[1];
            String subjectGrade = token[2];
            Major major = new Major(subjectName, subjectCredit, subjectGrade);
            if(major.getSubjectCredit()<1 || major.getSubjectCredit()>4){
                throw new IllegalArgumentException("잘못된 학점");
            }
            student.setCreditSum(major.getSubjectCredit(), major.getSubjectGrade());
            student.setGradeSum(major.getSubjectGrade(), major.getSubjectCredit());
            student.setMajorCredit(major.getSubjectCredit());
            student.setMajorSum(major.getSubjectGrade(), major.getSubjectCredit());
            student.setMajorAvg(student.getMajorSum(), student.getMajorCredit());
            student.setGradeAvg(student.getGradeSum());
            majors.add(major);
        }
        System.out.println("교양 과목명과 이수학점, 평점을 입력해주세요(예시: 선형대수학-3-C0,인간관계와자기성장-3-P):");
        String input2 = Console.readLine();
        if (input2.trim().equals("")) {
            throw new IllegalArgumentException("공백으로만 구성됨");
        }
        String[] subject2 = input2.split(",");
        for (int i = 0; i < subject2.length; i++) {
            String[] token2 = subject2[i].split("-");
            if (token2.length != 3) {
                throw new IllegalArgumentException("입력 형식 오류");
            }
            String subjectName = token2[0];
            String subjectCredit = token2[1];
            String subjectGrade = token2[2];
            GeneralEducation general = new GeneralEducation(subjectName, subjectCredit, subjectGrade);
            if(general.getSubjectCredit()<1 || general.getSubjectCredit()>4){
                throw new IllegalArgumentException("잘못된 학점");
            }
            student.setCreditSum(general.getSubjectCredit(), general.getSubjectGrade());
            student.setGradeSum(general.getSubjectGrade(), general.getSubjectCredit());
            student.setGradeAvg(student.getGradeSum());
            generals.add(general);
        }
        System.out.println("\n<과목 목록>");;
        for (int i = 0; i < majors.size(); i++) {
            System.out.println("[전공] " + majors.get(i).getSubjectName() + "," + majors.get(i).getSubjectCredit() + "," + majors.get(i).getSubjectGrade());
        }
        for (int i = 0; i < generals.size(); i++) {
            System.out.println("[교양] " + generals.get(i).getSubjectName() + "," + generals.get(i).getSubjectCredit() + "," + generals.get(i).getSubjectGrade());
        }

        System.out.println("\n<취득학점>");
        System.out.println(student.getCreditSum() + "학점");
        System.out.println("\n<평점평균>");
        String str = String.format("%.2f", student.getGradeAvg());
        System.out.println(str + " / 4.5");

        System.out.println("\n<전공 평점평균>");
        str = String.format("%.2f", student.getMajorAvg());
        System.out.println(str + " / 4.5");
    }
}
