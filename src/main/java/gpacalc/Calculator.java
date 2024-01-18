package gpacalc;

import java.util.Arrays;
import java.util.List;

public class Calculator {


    private double totalScore;
    private double majorTotalScore;
    private double majorSum;
    private double elecSum;

    private double grade;
    private double credit;
    private double rate;

    private final int minScore = 1;
    private final int maxScore = 4;

    private final int maxLength = 10;


    public void printMajorInput(List<String> infoMaj) {

        for (int i = 0; i < infoMaj.size(); i++) {
            if (i % 3 == 0) {
                System.out.print("[전공] ");
                checkNamingException(infoMaj.get(i));
            }
            System.out.print(infoMaj.get(i) + ",");

            if (i % 3 == 1) {
                credit = Integer.parseInt(infoMaj.get(i));
                checkScoreException(credit);


            } else if (i % 3 == 2) {
                System.out.println();
                checkRateException(infoMaj.get(i));


            }
        }

    }

    public double calculateMajorInputIntoGPA(List<String> infoMaj) {


        for (int i = 0; i < infoMaj.size(); i++) {
            if (i % 3 == 0) {
                checkNamingException(infoMaj.get(i));
            }


            if (i % 3 == 1) {
                credit = Integer.parseInt(infoMaj.get(i));
                checkScoreException(credit);
                calculateTotalScore(infoMaj.get(i + 1));
                calculateTotalMajorScore(infoMaj.get(i + 1));
            } else if (i % 3 == 2) {

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
            }
        }
        return majorSum / majorTotalScore;
    }


    public void printElecInput(List<String> infoElec) {

        for (int i = 0; i < infoElec.size(); i++) {
            if (i % 3 == 0) {
                System.out.print("[교양] ");
                checkNamingException(infoElec.get(i));
            }
            System.out.print(infoElec.get(i) + ",");



            if (i % 3 == 1) {
                credit = Integer.parseInt(infoElec.get(i));
                checkScoreException(credit);




            } else if (i % 3 == 2) {
                System.out.println();
                checkRateException(infoElec.get(i));

            }
        }

    }

    public double calculateElecInputIntoGPA(List<String> infoElec) {

        for (int i = 0; i < infoElec.size(); i++) {
            if (i % 3 == 0) {
                checkNamingException(infoElec.get(i));
            }

            if (i % 3 == 1) {
                credit = Integer.parseInt(infoElec.get(i));
                checkScoreException(credit);

                calculateTotalScore(infoElec.get(i + 1));

            } else if (i % 3 == 2) {

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
            }
        }

        return (majorSum + elecSum) / grade;
    }

    public void initializeNumbers() {
        setTotalScore(0);
        setMajorTotalScore(0);
        setMajorSum(0);
        setElecSum(0);
        setGrade(0);
    }

    public boolean isRightScore(double userScore) {
        boolean rightScore = true;

        if (userScore < minScore || userScore > maxScore) {
            rightScore = false;
        }

        return rightScore;
    }


    public boolean isWrongInput(String lectureName) {
        boolean moreThanTen = true;

        if (lectureName.isBlank() || lectureName.length() > maxLength) {
            moreThanTen = false;
        }

        return moreThanTen;
    }

    public void calculateTotalMajorScore(String lectureType) {
        if (!lectureType.equals("F") && !lectureType.equals("NP"))
            majorTotalScore += credit;

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
        System.out.println("\n <취득학점>");
        System.out.println((int) totalScore + "학점");
    }

    private void addMajorScore(double score, double r) {
        majorSum += score * r;

    }

    private void addElecScore(double score, double r) {
        elecSum += score * r;

    }

    public void printAverageOfAll() {
        double avg = (majorSum + elecSum) / grade;
        System.out.println("<평점평균>");
        System.out.println(String.format("%.2f / 4.5", avg));


    }

    public void printAverageOfMajor(double majorCalculateResult) {
        System.out.println("<전공 평점평균>");
        System.out.println(String.format("%.2f / 4.5", majorCalculateResult));
    }










    public double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(double totalScore) {
        this.totalScore = totalScore;
    }

    public double getMajorTotalScore() {
        return majorTotalScore;
    }

    public void setMajorTotalScore(double majorTotalScore) {
        this.majorTotalScore = majorTotalScore;
    }

    public double getMajorSum() {
        return majorSum;
    }

    public void setMajorSum(double majorSum) {
        this.majorSum = majorSum;
    }

    public double getElecSum() {
        return elecSum;
    }

    public void setElecSum(double elecSum) {
        this.elecSum = elecSum;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

}
