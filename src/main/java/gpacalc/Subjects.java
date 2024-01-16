package gpacalc;

import java.util.Stack;

import static org.junit.platform.commons.util.StringUtils.isBlank;

public class Subjects {
    Stack<String> stack = new Stack<>();

    public void input(String subject, String type){
        String subjects[] = subject.split(",");
        for(int i = 0; i < subjects.length; i++){
            subjects[i] = subjects[i].replace("-", ",");
            String subjectName = subjects[i].split(",")[0];
            System.out.println("subjectName: " + subjectName);
            if(isBlank(subjectName) && isValid(subjectName))
                stack.push("[" + type + "] " + subjects[i]);
        }
    }
    public boolean isBlank(String subjectName){
        if(subjectName.isBlank()){
            throw new IllegalArgumentException("과목명은 공백이 될 수 없습니다.");
        }
        return true;
    }
    public boolean isValid(String subjectName){
        if(subjectName.length() > 10){
            throw new IllegalArgumentException("과목명은 10글자 이내로 입력되어야 합니다.");
        }
        return true;
    }
    public void print(){
        for(int i = 0; i < stack.size(); i++){
            System.out.println(stack.get(i));
        }
    }
    public int calculateCredit(){
        int result = 0;
        for(int i = 0; i < stack.size(); i++){
            String info[] = stack.get(i).split(",");
            int credit = Integer.parseInt(info[1]);
            String grade = info[2];
            isValidCredit(credit);
            if(grade.equals("F") == false && grade.equals("NP") == false){
                result += credit;
            }
        }
        return result;
    }

    public void isValidCredit(int credit){
        if(credit < 1 || credit > 4){
            throw new IllegalArgumentException("학점은 1~4 사이의 숫자만 가능합니다.");
        }
    }

    public String calculateGPA(String type) {
        double result = 0;
        int credit = 0;
        for(int i = 0; i < stack.size(); i++){
            String info[] = stack.get(i).split(",");
            int subjectCredit = Integer.parseInt(info[1]);
            String subjectGrade = info[2];

            if(type == null || info[0].contains(type)){
                if(!subjectGrade.equals("P") && !subjectGrade.equals("NP")) {
                    if (subjectGrade.equals("A+")) {
                        result += 4.5 * subjectCredit;
                    } else if (subjectGrade.equals("A0")) {
                        result += 4.0 * subjectCredit;
                    } else if (subjectGrade.equals("B+")) {
                        result += 3.5 * subjectCredit;
                    } else if (subjectGrade.equals("B0")) {
                        result += 3.0 * subjectCredit;
                    } else if (subjectGrade.equals("C+")) {
                        result += 2.5 * subjectCredit;
                    } else if (subjectGrade.equals("C0")) {
                        result += 2.0 * subjectCredit;
                    } else if (subjectGrade.equals("D+")) {
                        result += 1.5 * subjectCredit;
                    } else if (subjectGrade.equals("D0")) {
                        result += 1.0 * subjectCredit;
                    }
                    else if(subjectGrade.equals("F")){
                        result += 0.0 * subjectCredit;
                    }
                    else{
                        throw new IllegalArgumentException("성적은 A+, A0, B+, B0, C+, C0, D+, D0, F, P, NP만 가능합니다.");
                    }
                    credit += subjectCredit;
                }
            }
        }
        System.out.println("result: " + result + ", credit: " + credit);
        result = result / credit;
        return String.format("%.2f", result);
    }
}
