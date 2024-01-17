package gpacalc;

public class Calculator {
    int point = 0; //취득학점
    int gradePoint = 0; //과목학점 총합
    double allGrade = 0.0; //과목성적가중치 총합
    int majorPoint = 0; //전공과목학점
    double majorGrade = 0.0; //전공성적가중치

    public int getPoint(String[][] major, String[][] general){
        for (String[] score : major) {
            if (!(score[2].equals("F") || score[2].equals("NP"))) {
                point += Integer.parseInt(score[1]);
            }
        }
        for (String[] score : general) {
            if (!(score[2].equals("F") || score[2].equals("NP"))) {
                point += Integer.parseInt(score[1]);
            }
        }
        return point;
    }

    public double getAllAverage(String[][] major, String[][] general){
        for (String[] point : major) {
            if(!(point[2].equals("P")||point[2].equals("NP"))) {
                double score = getScore(point[2]);
                allGrade += calculateGPA(score, point[1]);
                gradePoint += Integer.parseInt(point[1]);
            }
        }
        for (String[] point : general) {
            if(!(point[2].equals("P")||point[2].equals("NP"))) {
                double score = getScore(point[2]);
                allGrade += calculateGPA(score, point[1]);
                gradePoint += Integer.parseInt(point[1]);
            }
        }
        return allGrade/(double) gradePoint;
    }

    public double getMajorAverage(String[][] major){
        for (String[] point : major) {
            if(!(point[2].equals("P")||point[2].equals("NP"))) {
                double score = getScore(point[2]);
                majorGrade += calculateGPA(score, point[1]);
                majorPoint += Integer.parseInt(point[1]);
            }
        }
        return majorGrade/(double) majorPoint;
    }

    public double calculateGPA(double score, String point){
        return score * (double) Integer.parseInt(point);
    }

    static double getScore(String scr) {
        double score;

        switch(scr){
            case "A+" -> score = 4.5;
            case "A0" -> score = 4.0;
            case "B+" -> score = 3.5;
            case "B0" -> score = 3.0;
            case "C+" -> score = 2.5;
            case "C0" -> score = 2.0;
            case "D+" -> score = 1.5;
            case "D0" -> score = 1.0;
            case "F" -> score = 0;
            case "P" -> score = 0;
            case "NP" -> score = 0;
            default -> throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        return score;
    }
}