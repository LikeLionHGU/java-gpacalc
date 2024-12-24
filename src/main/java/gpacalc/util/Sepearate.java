package gpacalc.util;

import gpacalc.vo.Subject;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Sepearate {
    public static ArrayList<String> separateByComma(String line) {
        ArrayList<String> result = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(line, ",");
        while (st.hasMoreTokens()) {
            String info = st.nextToken();
            result.add(info);
        }
        return result;
    }
    public static ArrayList<Subject> separateByHyphen(ArrayList<String> subjects) {
        ArrayList<Subject> result = new ArrayList<>();
        StringTokenizer st;
        for (String s: subjects) {
            st = new StringTokenizer(s, "-");
            String subjectName = st.nextToken();
            int credit = 0;
            String score = "";
            try {
                credit = Integer.parseInt(st.nextToken());
                if (credit < 1 || credit > 4) {
                    throw new IllegalArgumentException("학점은 1부터 4까지만");
                }
                score = st.nextToken();
                if (!score.equals("A+") && !score.equals("A0") && !score.equals("B+") && !score.equals("B0") && !score.equals("C+") && !score.equals("C0") && !score.equals("D+") && !score.equals("D0") && !score.equals("F") && !score.equals("P") && !score.equals("NP")) {
                    throw new IllegalArgumentException("평점이 이상한디,,,");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("예외가 발생: "  + e.getMessage());
//                System.exit(0);

                throw new IllegalArgumentException();
            }

            result.add(new Subject(subjectName, credit, score));
        }
        return result;
    }
}
