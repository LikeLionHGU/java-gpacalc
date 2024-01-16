package gpacalc;

import java.util.Arrays;
import java.util.List;

public class Calculator {

    double totalScore = 0;
    double majorTotalScore = 0;
    double majorSum = 0;
    double elecSum = 0;

    double grade = 0;
    double credit;
    double rate;


    public void printMajorInput(List<String> infoMaj) {

        for (int i = 0; i < infoMaj.size(); i++) {
            if (i % 3 == 0) {
                System.out.print("[전공] ");
                checkNamingException(infoMaj.get(i));
            }
            System.out.print(infoMaj.get(i));

            if (i % 3 == 1) {
                credit = Integer.parseInt(infoMaj.get(i));
                checkScoreException(credit);

                calculateTotalScore(infoMaj.get(i + 1));
                System.out.print(",");

            }
            else if (i % 3 == 2) {
                System.out.println();
                checkRateException(infoMaj.get(i));
                if (!infoMaj.get(i).equals("P") && !infoMaj.get(i).equals("NP")) {
                    switch (infoMaj.get(i)) {
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

                    addMajorScore(credit, rate);
                }

            } else {
                System.out.print(",");

            }
        }
    }




    public void printElecInput(List<String> infoElec) {

        for (int i = 0; i < infoElec.size(); i++) {
            if (i % 3 == 0) {
                System.out.print("[교양] ");
                checkNamingException(infoElec.get(i));
            }
            System.out.print(infoElec.get(i));


            if (i % 3 == 1) {
                credit = Integer.parseInt(infoElec.get(i));
                checkScoreException(credit);

                calculateTotalScore(infoElec.get(i + 1));

                System.out.print(",");

            } else if (i % 3 == 2) {
                System.out.println();
                checkRateException(infoElec.get(i));
                if (!infoElec.get(i).equals("P") && !infoElec.get(i).equals("NP")) {
                    switch (infoElec.get(i)) {
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

                    addElecScore(credit, rate);
                }
            } else {
                System.out.print(",");
            }
        }

    }

    public boolean isRightScore(double userScore) {
        boolean rightScore = true;

        if (userScore < 1 || userScore > 4) {
            rightScore = false;
        }

        return rightScore;
    }


    public boolean isWrongInput(String lectureName) {
        boolean moreThanTen = true;

        if (lectureName.isBlank() || lectureName.length() > 10) {
            moreThanTen = false;
        }

        return moreThanTen;
    }


    public void calculateTotalScore(String lectureType) {
        if (!lectureType.equals("F") && !lectureType.equals("NP"))
            totalScore += credit;

        if (!lectureType.equals("P") && !lectureType.equals("NP"))
            grade += credit;
    }


    public void checkNamingException(String lectureName) {
        try {
            if (!isWrongInput(lectureName)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("\n === 올바르지 않은 과목명입니다. ===");
            System.exit(0);
        }
    }

    public void checkScoreException(double lectureScore) {
        try {
            if (!isRightScore(lectureScore)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("\n === 학점이 올바르지 않습니다. ===");
            System.exit(0);
        }
    }

    public void checkRateException(String userGrade) {
        try {
            if (hasRightScore(userGrade)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("\n === 성적이 올바르지 않습니다. ===");
            System.exit(0);

        }
    }


    public boolean hasRightScore(String score) {
        boolean isRightScore = true;

        if (Arrays.asList("A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F", "P", "NP").contains(score)) {
            isRightScore = false;
        }

        return isRightScore;
    }

    public void printSum() {
        System.out.println("\n <취득 학점>");
        System.out.println(totalScore + "학점");
    }

    private void addMajorScore(double score, double r) {
        majorSum += score * r;

    }

    private void addElecScore(double score, double r) {
        elecSum += score * r;

    }

    public void printAverage() {
        double avg = (majorSum + elecSum) / grade;
        double major_avg = majorSum / majorTotalScore;

        System.out.println("<평점 평균>");
        System.out.println(String.format("%.2f / 4.5", avg));


        System.out.println("<전공 평점 평균>");
        System.out.println(String.format("%.2f / 4.5", major_avg));
    }

}
