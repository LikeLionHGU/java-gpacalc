package gpacalc;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Console;


public class Input {

    public String getMajorInput(){

        System.out.println(" ===  전공 과목명과 이수학점, 평점을 입력해주세요 === ");

        String majorScore = Console.readLine();
        return majorScore;
    }

    public String getElectiveInput(){

        System.out.println(" ===  교양 과목명과 이수학점, 평점을 입력해주세요 === ");

        String elecScore = Console.readLine();
        return elecScore;
    }
}
