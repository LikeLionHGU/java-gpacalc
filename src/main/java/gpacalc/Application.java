package gpacalc;

import java.util.List;


// ...


public class Application {
    public static void main(String[] args) {
        //TODO: 구현

        // 1. 과목 - 학점 - 점수 묶음으로 입력

        // 2. 형태에 맞춰 필요한 정보 담기 ( 제대로 담기만 하면 됨 )

        // 3. parsing 후에 계산

        // 4. 이쁘게 출력


//      1.


        Input input = new Input();
        String major_score = input.getMajorInput();
        String elec_score = input.getElectiveInput();


//      2.

        ParseString parseString = new ParseString();
        List<String> major_result = parseString.getSeparated(major_score);
        List<String> elec_result = parseString.getSeparated(elec_score);


//      3.
        System.out.println("<과목 목록>");
        Calculator calculator = new Calculator();
        calculator.printMajorInput(major_result);
        calculator.printElecInput(elec_result);

//      4.
        calculator.printSum();
        calculator.printAll();

//데이타구조-3-A0,자바프로그래밍언어-3-B+,컴퓨터구조-3-C0,컴퓨터네트워크-3-D+
//미술의이해-3-P,교양특론3-1-NP,기독교의이해-2-F


        System.out.println("=== [System] : 계산이 끝났습니다. ===");
            System.exit(0);

    }
}
