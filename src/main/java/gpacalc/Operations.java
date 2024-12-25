package gpacalc;

import java.util.ArrayList;

public class Operations {
    public Operations() {
    }

    public ArrayList<Subject> MakeSubjects(String input){ // 입력받은 과목 저장
        ArrayList<Subject> result = new ArrayList<>();
        String[] subjects = input.split(",");
        for(int i = 0; i < subjects.length; i++) {
            String[] info = subjects[i].split("-");
            Subject s = null;
            try {
                s = new Subject(info[0], Integer.parseInt(info[1]), info[2]);
            } catch (NumberFormatException e) {
                throw e;
            }
            result.add(s);
        }
        return result;
    }

    public void printSubjects(ArrayList<Subject> major, ArrayList<Subject> general) { // 과목 출력
        System.out.println("<과목 목록>");
        for(Subject s : major) {
            System.out.println("[전공] "+s.toString());
        }
        for(Subject s : general) {
            System.out.println("[교양] "+s.toString());
        }
    }

//    평점평균 = 과목성적가중치의 총합 / 과목학점의 총합
//    과목성적가중치 = 과목평점 * 과목학점
//    평점평균은 소수점 셋째 자리에서 반올림하여 둘째 자리까지 표현한다.
//    P/NP 과목은 평점평균 계산에서 제외한다.
    public double CalTotalWeightSG_M(ArrayList<Subject> major) { // 전공의 "과목성적가중치의 총합"
        double totalWeightSG = 0;
        for(Subject s : major) {
            if(s.getGradeNumber() != -1){
                totalWeightSG += s.getCredit() * s.getGradeNumber();
            }
        }
        return totalWeightSG;
    }

    public double CalGPA_M(ArrayList<Subject> major) { // 전공의 "평점평균"
        double gpa = 0;
        int totalCredits = 0;
        double totalWeightSG;
        // 과목학점의 총합
        for(Subject s : major) {
            if(s.getGradeNumber() != -1) {//P, NP는 해당 안 됨
                totalCredits += s.getCredit();
            }
        }
        // 과목성적가중치의 총합
        totalWeightSG = CalTotalWeightSG_M(major);

        //GPA 계산부분
        gpa = totalWeightSG / totalCredits;
        return Math.round(gpa*100)/100.0 ; // 소수점 셋째 자리에서 반올림
    }

    public double CalTotalWeightSG(ArrayList<Subject> major, ArrayList<Subject> general) { // 전체의 "과목성적가중치의 총합"
        double totalWeightSG_G = 0;
        double totalWeightSG_M = CalTotalWeightSG_M(major);
        for(Subject s : general) {
            if(s.getGradeNumber() != -1){
                totalWeightSG_G += s.getCredit() * s.getGradeNumber();
            }
        }
        return totalWeightSG_G + totalWeightSG_M;
    }

    public double CalGPA(ArrayList<Subject> major, ArrayList<Subject> general) { // 전체의 "평점평균"
        double gpa = 0;
        int totalCredits = 0;
        double totalWeightSG;
        // 과목학점의 총합
        for(Subject s : major) {
            if(s.getGradeNumber() != -1) {//P, NP는 해당 안 됨
                totalCredits += s.getCredit();
            }
        }
        for(Subject s : general) {
            if(s.getGradeNumber() != -1) {
                totalCredits += s.getCredit();
            }
        }
        // 과목성적가중치의 총합
        totalWeightSG = CalTotalWeightSG(major, general);

        //GPA 계산부분
        gpa = totalWeightSG / totalCredits;
        return Math.round(gpa*100)/100.0 ; // 소수점 셋째 자리에서 반올림
    }

    public int CalTakenCredits(ArrayList<Subject> major, ArrayList<Subject> general) { // 취득학점 계산
        int result = 0;
        for(Subject s : major) {
            if(s.getGradeNumber() != 0 && !s.getGrade().equals("NP")){
                result += s.getCredit();
            }
        }
        for(Subject s : general) {
            if(s.getGradeNumber() != 0 && !s.getGrade().equals("NP")){
                result += s.getCredit();
            }
        }
        return result;
    }
}
