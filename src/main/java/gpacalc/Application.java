package gpacalc;

import java.util.ArrayList;
import java.util.Arrays;
import camp.nextstep.edu.missionutils.Console;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        //TODO:
        String[] mainSubjects;
        String[] subSubjects;

        System.out.println("전공 과목명과 이수학점, 평점을 입력해주세요(예시: 프로그래밍언어론-3-A+,소프트웨어공학-3-B+):");
        String input = readLine();

        mainSubjects = input.split(",");

        System.out.println("교양 과목명과 이수학점, 평점을 입력해주세요(예시: 선형대수학-3-C0,인간관계와자기성장-3-P):");
        input = readLine();

        subSubjects = input.split(",");

        ArrayList<Subject> mainContent = new ArrayList<>();
        ArrayList<Subject> subContent = new ArrayList<>();

        Subject main = null;
        Subject sub = null;
        String[] temp;

        for(String subject: mainSubjects){
            temp = subject.split("-");
            main = new Subject(temp[0], temp[1], temp[2]);
            mainContent.add(main);
        }

        for(String subject: subSubjects){
            temp = subject.split("-");
            sub = new Subject(temp[0], temp[1], temp[2]);
            subContent.add(sub);
        }

        for(Subject subject: mainContent){ // 전공과목의 argument validation
            try{
                if((!(subject.getGrade().equalsIgnoreCase("A+") || subject.getGrade().equalsIgnoreCase("A0")
                        || subject.getGrade().equalsIgnoreCase("B+") || subject.getGrade().equalsIgnoreCase("B0")
                        || subject.getGrade().equalsIgnoreCase("C+") || subject.getGrade().equalsIgnoreCase("C0")
                        || subject.getGrade().equalsIgnoreCase("D+") || subject.getGrade().equalsIgnoreCase("D0")
                        || subject.getGrade().equalsIgnoreCase("F")  || subject.getGrade().equalsIgnoreCase("P")
                        || subject.getGrade().equalsIgnoreCase("NP"))
                ) || (!(subject.getCredit().equalsIgnoreCase("1") || subject.getCredit().equalsIgnoreCase("2")
                        || subject.getCredit().equalsIgnoreCase("3") || subject.getCredit().equalsIgnoreCase("4"))
                ) || (subject.getName().length() > 10)){
                    IllegalArgumentException IllegalArgumentException = new IllegalArgumentException();
                    throw IllegalArgumentException;
                }
            }catch (IllegalArgumentException IllegalArgumentException){
                throw new IllegalArgumentException();
//                System.exit(0);
            }
        }

        for(Subject subject: subContent){ // 교양과목의 argument validation
            try{
                if((!(subject.getGrade().equalsIgnoreCase("A+") || subject.getGrade().equalsIgnoreCase("A0")
                        || subject.getGrade().equalsIgnoreCase("B+") || subject.getGrade().equalsIgnoreCase("B0")
                        || subject.getGrade().equalsIgnoreCase("C+") || subject.getGrade().equalsIgnoreCase("C0")
                        || subject.getGrade().equalsIgnoreCase("D+") || subject.getGrade().equalsIgnoreCase("D0")
                        || subject.getGrade().equalsIgnoreCase("F")  || subject.getGrade().equalsIgnoreCase("P")
                        || subject.getGrade().equalsIgnoreCase("NP"))
                ) || (!(subject.getCredit().equalsIgnoreCase("1") || subject.getCredit().equalsIgnoreCase("2")
                        || subject.getCredit().equalsIgnoreCase("3") || subject.getCredit().equalsIgnoreCase("4"))
                ) || (subject.getName().length() > 10)){
                    Exception IllegalArgumentException = new Exception();
                    throw IllegalArgumentException;
                }
            }catch (Exception IllegalArgumentException){
                System.exit(0);
            }
        }

        int totalCredit = 0;
        int mainCredits = 0;
        int subCredits = 0;
        double totalGrade = 0;
        double averageGradeForAll = 0;

        for(Subject subject: mainContent){
            if(!(subject.getGrade().equalsIgnoreCase("NP") || subject.getGrade().equalsIgnoreCase("F"))){
                totalCredit += Integer.parseInt(subject.getCredit());
            }
        }

        for(Subject subject: subContent){
            if(!(subject.getGrade().equalsIgnoreCase("NP") || subject.getGrade().equalsIgnoreCase("F"))){
                totalCredit += Integer.parseInt(subject.getCredit());
            }
        }

        for(Subject subject: mainContent){ //전공과목 성적가중치 계산
            if(!(subject.getGrade().equalsIgnoreCase("P") || subject.getGrade().equalsIgnoreCase("NP"))){
                mainCredits += Integer.parseInt(subject.getCredit());
                switch (subject.getGrade()){
                    case "A+":
                        totalGrade += 4.5*(Integer.parseInt(subject.getCredit()));
                        break;
                    case "A0":
                        totalGrade += 4.0*(Integer.parseInt(subject.getCredit()));
                        break;
                    case "B+":
                        totalGrade += 3.5*(Integer.parseInt(subject.getCredit()));
                        break;
                    case "B0":
                        totalGrade += 3.0*(Integer.parseInt(subject.getCredit()));
                        break;
                    case "C+":
                        totalGrade += 2.5*(Integer.parseInt(subject.getCredit()));
                        break;
                    case "C0":
                        totalGrade += 2.0*(Integer.parseInt(subject.getCredit()));
                        break;
                    case "D+":
                        totalGrade += 1.5*(Integer.parseInt(subject.getCredit()));
                        break;
                    case "D0":
                        totalGrade += 1.0*(Integer.parseInt(subject.getCredit()));
                        break;
                    default:
                        totalGrade += 0;
                        break;
                }
            }
        }

        double averageGradeForMain = totalGrade/mainCredits; //전공과목 평점평균 계산

        for(Subject subject: subContent){ //교양과목 성적가중치 계산
            if(!(subject.getGrade().equalsIgnoreCase("P") || subject.getGrade().equalsIgnoreCase("NP"))){
                subCredits += Integer.parseInt(subject.getCredit());
                switch (subject.getGrade()){
                    case "A+":
                        totalGrade += 4.5*(Integer.parseInt(subject.getCredit()));
                        break;
                    case "A0":
                        totalGrade += 4.0*(Integer.parseInt(subject.getCredit()));
                        break;
                    case "B+":
                        totalGrade += 3.5*(Integer.parseInt(subject.getCredit()));
                        break;
                    case "B0":
                        totalGrade += 3.0*(Integer.parseInt(subject.getCredit()));
                        break;
                    case "C+":
                        totalGrade += 2.5*(Integer.parseInt(subject.getCredit()));
                        break;
                    case "C0":
                        totalGrade += 2.0*(Integer.parseInt(subject.getCredit()));
                        break;
                    case "D+":
                        totalGrade += 1.5*(Integer.parseInt(subject.getCredit()));
                        break;
                    case "D0":
                        totalGrade += 1.0*(Integer.parseInt(subject.getCredit()));
                        break;
                    default:
                        totalGrade += 0;
                        break;
                }
            }
        }

        averageGradeForAll = totalGrade/(mainCredits+subCredits); //전체과목 평균평점 계산

        System.out.println("\n<과목 목록>");
        for(Subject subject: mainContent){
            System.out.println("[전공] " + subject.getName() + "," + subject.getCredit() + "," + subject.getGrade());
        }
        for(Subject subject: subContent){
            System.out.println("[교양] " + subject.getName() + "," + subject.getCredit() + "," + subject.getGrade());
        }

        System.out.println("\n<취득학점>");
        System.out.println(totalCredit + "학점");

        System.out.println("\n<평점평균>");
        System.out.println((double)Math.round(averageGradeForAll*100)/100 + " / 4.5");

        System.out.println("\n<전공 평점평균>");
        System.out.println((double)Math.round(averageGradeForMain*100)/100 + " / 4.5");

    }

}
