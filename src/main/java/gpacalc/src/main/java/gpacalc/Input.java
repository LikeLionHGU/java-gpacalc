package gpacalc;
import camp.nextstep.edu.missionutils.Console;

public class Input {

    public String getMajorInput(){
        System.out.println("전공 과목명과 이수학점, 평점을 입력해주세요(예시: 프로그래밍언어론-3-A+,소프트웨어공학-3-B+):");
        return Console.readLine();
    }

    public String getElectiveInput(){
        System.out.println("교양 과목명과 이수학점, 평점을 입력해주세요(예시: 선형대수학-3-C0,인간관계와자기성장-3-P):");
        return Console.readLine();
    }

    public String[][] separateStr (String str){
        String[] firstSplit = str.split(",");
        String[][] lastSplit = new String[firstSplit.length][];  //전공과목 저장을 위한 배열(문자열 형태)
        for (int i = 0; i < firstSplit.length; i++) {
            lastSplit[i] = firstSplit[i].split("-");
        }
        return lastSplit;
    }
}