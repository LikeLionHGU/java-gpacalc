package gpacalc;

import java.util.Stack;

public class Subjects {
    Stack<String> stack = new Stack<>();
    private String[] subjects;
    public void input(String subject, String type){
        String subjects[] = subject.split(",");
        this.subjects = subjects;
        for(int i = 0; i < subjects.length; i++){
            subjects[i] = subjects[i].replace("-", ",");
            stack.push("[" + type + "] " + subjects[i]);
        }
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
            if(credit < 1 || credit > 4){
                throw new IllegalArgumentException("학점은 1~4 사이의 숫자만 가능합니다.");
            }
            if(grade.equals("F") == false && grade.equals("NP") == false){
                result += credit;
            }
        }
        return result;
    }

    public String calculateAverage() {
        return calculateAverage(null);
    }
    public String calculateAverage(String type) {
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
                        throw new IllegalArgumentException("학점은 A+, A0, B+, B0, C+, C0, D+, D0, F, P, NP만 가능합니다.");
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
