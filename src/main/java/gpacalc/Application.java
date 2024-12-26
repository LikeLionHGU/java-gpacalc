package gpacalc;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Console;


public class Application {
    public static void main(String[] args) {
        ArrayList<ArrayList<Subject>> general=new ArrayList<>();
        general.add(new ArrayList<>());
        general.add(new ArrayList<>());
        String[] line=new String[2];
        String[][] parts=new String[2][];
        boolean flag=true;
        System.out.println("전공 과목명과 이수학점, 평점을 입력해주세요(예시: 프로그래밍언어론-3-A+,소프트웨어공학-3-B+):");
        line[0]=Console.readLine();
        parts[0]=line[0].split(",");
        System.out.println("교양 과목명과 이수학점, 평점을 입력해주세요(예시: 선형대수학-3-C0,인간관계와자기성장-3-P):");
        line[1]=Console.readLine();
        parts[1]=line[1].split(",");
        for(String part:parts[0]) {
            String[] subject = part.split("-");
            if (!subject[1].equals("1") && !subject[1].equals("2") && !subject[1].equals("3") && !subject[1].equals("4")) {
                flag=false;
                throw new IllegalArgumentException();
            }
            if (subject[0].length() > 10 || subject[0].replaceAll(" ", "").isEmpty()) {
                flag=false;
                throw new IllegalArgumentException();
            }
            if (!subject[2].equals("A+") && !subject[2].equals("A0") && !subject[2].equals("B+") && !subject[2].equals("B0") && !subject[2].equals("C+") && !subject[2].equals("C0") && !subject[2].equals("D+") && !subject[2].equals("D0") && !subject[2].equals("F") && !subject[2].equals("P") && !subject[2].equals("NP")) {
                flag=false;
                throw new IllegalArgumentException();
            }
        }
        for(String part:parts[1]) {
            String[] subject = part.split("-");
            if (!subject[1].equals("1") && !subject[1].equals("2") && !subject[1].equals("3") && !subject[1].equals("4")) {
                flag=false;
                throw new IllegalArgumentException();
            }
            if (subject[0].length() > 10 || subject[0].replaceAll(" ", "").isEmpty()) {
                flag=false;
                throw new IllegalArgumentException();
            }
            if (!subject[2].equals("A+") && !subject[2].equals("A0") && !subject[2].equals("B+") && !subject[2].equals("B0") && !subject[2].equals("C+") && !subject[2].equals("C0") && !subject[2].equals("D+") && !subject[2].equals("D0") && !subject[2].equals("F") && !subject[2].equals("P") && !subject[2].equals("NP")) {
                flag=false;
                throw new IllegalArgumentException();
            }
        }
        if(flag){
            for(int i=0;i<2;i++){
                for(String part:parts[i]){
                    String[] subject=part.split("-");
                    Subject newSubject=new Subject(subject[0],Integer.parseInt(subject[1]),subject[2]);
                    general.get(i).add(newSubject);
                }
            }
            double weightSum=0;
            int count=0;
            double sum2=0;
            double count2=0;
            int scoreSum=0;
            System.out.println("<과목 목록>");
            for(Subject subject:general.get(0)){
                System.out.println("[전공] "+subject.getName()+","+subject.getPoint()+","+subject.getScore());
                weightSum+=subject.getScore2()*subject.getPoint();
                sum2+=subject.getScore2()*subject.getPoint();
                if(!subject.getScore().equals("P")&&!subject.getScore().equals("NP")) {
                    count += subject.getPoint();
                    count2 += subject.getPoint();
                }
                if(!subject.getScore().equals("F")&&!subject.getScore().equals("NP")) {
                    scoreSum += subject.getPoint();
                }
            }
            for(Subject subject:general.get(1)){
                System.out.println("[교양] "+subject.getName()+","+subject.getPoint()+","+subject.getScore());
                weightSum+=subject.getScore2()*subject.getPoint();
                if(!subject.getScore().equals("P")&&!subject.getScore().equals("NP")) {
                    count += subject.getPoint();
                }
                if(!subject.getScore().equals("F")&&!subject.getScore().equals("NP")) {
                    scoreSum += subject.getPoint();
                }
            }
            double avg=weightSum/count;
            double majorAvg=sum2/count2;

            System.out.println();
            System.out.println("<취득학점>");
            System.out.println(scoreSum+"학점");
            System.out.println();
            System.out.println("<평점평균>");
            System.out.printf("%.2f / 4.5\n",avg);
            System.out.println();
            System.out.println("<전공 평점평균>");
            System.out.printf("%.2f / 4.5\n",majorAvg);
        }
    }
}

