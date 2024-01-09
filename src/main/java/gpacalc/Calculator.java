package gpacalc;

import java.util.Arrays;
import java.util.List;

public class Calculator {

    double total_score = 0; // 총 취득 학점
    double major_total_score = 0;
    double major_sum = 0;
    double elec_sum = 0;

    double grade =0;
    double tmp;
    double rate;

    public void printMajorInput(List<String> info_maj) {

        for (int i = 0; i < info_maj.size(); i++) {
            if (i % 3 == 0)
                if (info_maj.get(i) == null || info_maj.get(i).length() > 10) {
                    throw new IllegalArgumentException();
                }
                System.out.print("[전공] ");

            System.out.print(info_maj.get(i));


            if (i % 3 == 1) {
                tmp = Integer.parseInt(info_maj.get(i));
                if (tmp < 1 || tmp > 4) {
                    throw new IllegalArgumentException();
                }

                if (!info_maj.get(i + 1).equals("F") && !info_maj.get(i + 1).equals("NP")) {
                    total_score += tmp;
                    major_total_score += tmp;

                }

                if (!info_maj.get(i + 1).equals("P") && !info_maj.get(i + 1).equals("NP"))
                    grade += tmp;


                System.out.print(",");

            } else if (i % 3 == 2) {
                System.out.println();
                if (!Arrays.asList("A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F","P","NP").contains(info_maj.get(i))) {
                    throw new IllegalArgumentException();
                }
                if (!info_maj.get(i).equals("P") && !info_maj.get(i).equals("NP")) {
                    switch (info_maj.get(i)) {
                        case "A+":
                            rate = 4.5;
                            break;
                        case "A0":
                            rate = 4.0;
                            break;
                        case "B+":
                            rate = 3.5;
                            break;
                        case "B0":
                            rate = 3.0;
                            break;
                        case "C+":
                            rate = 2.5;
                            break;
                        case "C0":
                            rate = 2.0;
                            break;
                        case "D+":
                            rate = 1.5;
                            break;
                        case "D0":
                            rate = 1.0;
                            break;
                        case "F":
                            rate = 0;
                            break;
                    }

                    addMajorScore(tmp, rate);
                }

            } else {
                System.out.print(",");
            }
        }


    }

    public void printElecInput(List<String> info_elec) {

        for (int i = 0; i < info_elec.size(); i++) {
            if (i % 3 == 0)
                if (info_elec.get(i) == null || info_elec.get(i).length() > 10) {
                    throw new IllegalArgumentException();
                }
                System.out.print("[교양] ");

            System.out.print(info_elec.get(i));


            if (i % 3 == 1) {
                tmp = Integer.parseInt(info_elec.get(i));
                if (tmp < 1 || tmp > 4) {
                    throw new IllegalArgumentException();
                }
                if (!info_elec.get(i + 1).equals("F") && !info_elec.get(i + 1).equals("NP"))
                    total_score += tmp;

                if (!info_elec.get(i + 1).equals("P") && !info_elec.get(i + 1).equals("NP"))
                    grade += tmp;

                    System.out.print(",");

            } else if (i % 3 == 2) {
                System.out.println();
                if (!Arrays.asList("A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F","P","NP").contains(info_elec.get(i))) {
                    throw new IllegalArgumentException();
                }
                if (!info_elec.get(i).equals("P") && !info_elec.get(i).equals("NP")) {
                    switch (info_elec.get(i)) {
                        case "A+":
                            rate = 4.5;
                            break;
                        case "A0":
                            rate = 4.0;
                            break;
                        case "B+":
                            rate = 3.5;
                            break;
                        case "B0":
                            rate = 3.0;
                            break;
                        case "C+":
                            rate = 2.5;
                            break;
                        case "C0":
                            rate = 2.0;
                            break;
                        case "D+":
                            rate = 1.5;
                            break;
                        case "D0":
                            rate = 1.0;
                            break;
                        case "F":
                            rate = 0;
                            break;
                    }

                    addElecScore(tmp, rate);
                }
            } else {
                System.out.print(",");
            }
        }

    }

    public void printSum() {
        System.out.println("\n <취득 학점>");
        System.out.println(total_score + "학점");
    }

    private void addMajorScore(double score, double r) {
        major_sum += score * r;

    }

    private void addElecScore(double score, double r) {
        elec_sum += score * r;

    }

    public void printAll() {
        double avg = (major_sum + elec_sum) / grade;
        double major_avg = major_sum / major_total_score;

        System.out.println("<평점 평균>");
        System.out.println(String.format("%.2f / 4.5", avg));


        System.out.println("<전공 평점 평균>");
        System.out.println(String.format("%.2f / 4.5", major_avg));
    }

}
