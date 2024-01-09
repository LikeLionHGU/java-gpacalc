package gpacalc;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Console;


public class Input {

    public String getMajorInput(){

        System.out.println(" ===  전공 과목명과 이수학점, 평점을 입력해주세요 === ");

        String major_score = Console.readLine();
        return major_score;
    }

    public String getElectiveInput(){

        System.out.println(" ===  교양 과목명과 이수학점, 평점을 입력해주세요 === ");

        String elec_score = Console.readLine();
        return elec_score;
    }
}
