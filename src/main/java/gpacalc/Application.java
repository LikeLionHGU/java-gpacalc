package gpacalc;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        System.out.println("전공 과목명과 이수학점, 평점을 입력해주세요(예시: 프로그래밍언어론-3-A+,소프트웨어공학-3-B+):");
        String major = Console.readLine();
        System.out.println("교양 과목명과 이수학점, 평점을 입력해주세요(예시: 선형대수학-3-C0,인간관계와자기성장-3-P):");
        String liberal = Console.readLine();

        System.out.println("<과목 목록>");
        categorize(major, "전공");
        categorize(liberal, "교양");
        System.out.println();

        int credit = getCredit(major) + getCredit(liberal);
        System.out.println("<취득학점>");
        System.out.println(credit + "학점\n");

        System.out.println("<평점평균>");
        System.out.println(calculate(major + "," + liberal ,credit) + " / 4.5\n");

        System.out.println("<전공 평점평균>");
        System.out.println(calculate(major, getCredit(major)) + " / 4.5\n");

        return;
    }

    public static void checkSubjectLength(String subject) {
        if (checkMinName(subject) || checkMaxName(subject)){
            throw new IllegalArgumentException();
        }
    }

    public static boolean checkMaxName(String subject){
        int maxNameLength = 10;
	    return maxNameLength < subject.length();
    }

    public static boolean checkMinName(String subject){
        return subject.isBlank();
    }

    public static void checkGradeRange(String Grade){
        if(Grade.equals("A+") || Grade.equals("A0") || Grade.equals("B+") || Grade.equals("B0") || Grade.equals("C+") || Grade.equals("C0") || Grade.equals("D+") || Grade.equals("D0") || Grade.equals("F") || Grade.equals("P") || Grade.equals("NP") ) return;
        throw new IllegalArgumentException();
    }

    public static void categorize(String input, String major_liberal) {
        String[] first_split = input.split(",");
        String[][] second_split = new String[first_split.length][3];
        for (int i = 0; i < first_split.length; i++) {
            second_split[i] = first_split[i].split("-");
        }

        for (int i = 0; i < first_split.length; i++) {
            checkSubjectLength(second_split[i][0]);
            checkGradeRange(second_split[i][2]);

            System.out.print("[" + major_liberal + "] ");
            for (int j = 0; j < 3; j++) {
                System.out.print(second_split[i][j]);
                if (j != 2) System.out.print(",");
            }
            System.out.println();
        }
    }

    public static int getCredit(String input) {
        int credit = 0;
        String[] first_split = input.split(",");
        String[][] second_split = new String[first_split.length][3];
        for (int i = 0; i < first_split.length; i++) second_split[i] = first_split[i].split("-");
        for (String[] strings : second_split) {
            int subject_credit = Integer.parseInt(strings[1]);
            checkCreditRange(subject_credit);

            if (strings[2].equals("F") || strings[2].equals("NP")) continue;
            credit += Integer.parseInt(strings[1]);
        }
        return credit;
    }

    public static void checkCreditRange(int subject_credit){
        int minCredit = 1,maxCredit = 4;
        if (subject_credit < minCredit|| maxCredit < subject_credit)
            throw new IllegalArgumentException("학점을 확인해주세요.");
    }


    // /// - 1 - \\\  랑 그 밑이랑 하나씩 새로운 mehtod를 사용하기!
    public static double calculate(String all, int credit){
        ///// - 1 - \\\\\\\\\
        // A+(4.5), A0(4.0), B+(3.5), B0(3.0), C+(2.5), C0(2.0), D+(1.5), D0(1.0), F(0)
        String[] first_split = all.split(",");
        String[][] second_split = new String[first_split.length][3];
        for(int i = 0 ; i < first_split.length ; i++){
            second_split[i] = first_split[i].split("-");
            if(second_split[i][2].equals("P")) credit -= Integer.parseInt(second_split[i][1]);
            if(second_split[i][2].equals("F")) credit += Integer.parseInt(second_split[i][1]);
        }

        //// - 2 - \\\\\\\\
        double sum = 0;
        for(int i = 0 ;i < first_split.length ; i++){
            sum += (Double.parseDouble(second_split[i][1]) * Matching(second_split[i][2]));
        }
        double result = sum / credit;
        result = Math.round(result*100)/(double)100 ;

        return result;
    }

    public static double Matching(String grade){
        double score = 0;
        switch(grade){
            case "A+" -> score = 4.5;
            case "A0" -> score = 4.0;
            case "B+" -> score = 3.5;
            case "B0" -> score = 3.0;
            case "C+" -> score = 2.5;
            case "C0" -> score = 2.0;
            case "D+" -> score = 1.5;
            case "D0" -> score = 1.0;
            default -> score = 0;
        }
        return score;
    }

}
