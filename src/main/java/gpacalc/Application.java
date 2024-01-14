package gpacalc;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Console;
import java.util.Vector;



public class Application {
    public static void main(String[] args) {
        //TODO: 구현

        int gain_total = 0 , gain_total2 = 0 ; // 전공취득학점, 교양취득학점
        int gain_total3 = 0 , gain_total4 = 0 ;
        float average_total = 0, average_total2 = 0 ; // 전공성적가중치, 교양성적가중치

        Vector<Majors> v1 = new Vector<Majors>();
        Vector<Refinements> v2 = new Vector<Refinements>(); // 교양 과목 벡터


        System.out.println("전공 과목명과 이수학점, 평점을 입력해주세요(예시: 데이타구조-3-A0,자바프로그래밍언어-3-B+,컴퓨터구조-3-C0,컴퓨터네트워크-3-D+):");
        String input = readLine();


        String[] subjectsInfo = input.split(",");

        for (int i = 0; i < subjectsInfo.length; i++) {
            String[] info = subjectsInfo[i].split("-");
            String name = info[0].trim();
            String gain = info[1].trim();
            String grade = info[2].trim().replace("-", "");
            Majors m = new Majors(name, gain, grade);
            v1.add(m);
        }

        System.out.println("교양 과목명과 이수학점, 평점을 입력해주세요(예시: 선형대수학-3-C0,인간관계와자기성장-3-P):");
        input = readLine();

        subjectsInfo = input.split(",");

        for (int i = 0; i < subjectsInfo.length; i++) {
            String[] info = subjectsInfo[i].split("-");
            String name = info[0].trim();
            String gain = info[1].trim();
            String grade = info[2].trim().replace("-", "");
            Refinements r = new Refinements(name,gain,grade); // 객체 생성하기
            v2.add(r); // 객체 생성후 배열에 넣기
        }

        System.out.println("<과목 목록>");
        /* 취득학점 계산 및 수강 리스트 출력*/
        for(int i = 0 ; i < v1.size(); i++) {
            gain_total +=  v1.get(i).getGain() ; // 전공 취득 학점
            gain_total3 +=  v1.get(i).getGain2() ;
            average_total += v1.get(i).getAverage(); //전공 성적 가중치
            System.out.println(v1.get(i).toString());
        }
        for(int i = 0 ; i < v2.size(); i++) {
            gain_total2 +=  v2.get(i).getGain() ; // 교양 취득 학점
            gain_total4 +=  v2.get(i).getGain2() ;
            average_total2 += v2.get(i).getAverage(); // 교양 성적 가중치
            System.out.println(v2.get(i).toString());
        }

        System.out.println("<취득학점>");
        System.out.println(gain_total3+gain_total4+"학점");


        System.out.println("<평점평균>");
        float temp = (average_total+average_total2)/(gain_total+gain_total2);
        System.out.printf("%.2f / 4.5\n",temp);


        System.out.println("<전공 평점평균>");
        float temp2 =  average_total/gain_total;
        System.out.printf("%.2f / 4.5\n",temp2 );

    }
}


