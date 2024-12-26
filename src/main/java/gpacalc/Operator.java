package gpacalc;

import java.util.ArrayList;

public class Operator {

    public int getCredit_except_F_NP(ArrayList<Subject> subjects_M, ArrayList<Subject> subjects_G){
        int credit = 0;
        for(int i = 0; i<subjects_M.size(); i++){
            if(!(subjects_M.get(i).getGrade().equals("P")) && !(subjects_M.get(i).getGrade().equals("NP"))){
            credit += Integer.parseInt(subjects_M.get(i).getCredit());
            }

        }
        for(int i = 0; i<subjects_G.size(); i++){
            if(!(subjects_G.get(i).getGrade().equals("P")) && !(subjects_G.get(i).getGrade().equals("NP"))){
                credit += Integer.parseInt(subjects_G.get(i).getCredit());
            }
        }

        return credit;
    }

    public int getCredit(ArrayList<Subject> subjects_M, ArrayList<Subject> subjects_G){
        int credit = 0;
        for(int i = 0; i<subjects_M.size(); i++){
            if(!(subjects_M.get(i).getGrade().equals("F")) && !(subjects_M.get(i).getGrade().equals("NP"))){
                credit += Integer.parseInt(subjects_M.get(i).getCredit());
            }

        }
        for(int i = 0; i<subjects_G.size(); i++){
            if(!(subjects_G.get(i).getGrade().equals("F")) && !(subjects_G.get(i).getGrade().equals("NP"))){
                credit += Integer.parseInt(subjects_G.get(i).getCredit());
            }
        }

        return credit;
    }


    public float averageAllScore(ArrayList<Subject> subjects_M, ArrayList<Subject> subjects_G) {
        float allAverage = 0;
        float sgwAverage = 0.F;
        for (int i = 0; i < subjects_M.size(); i++) {
            if (!(subjects_M.get(i).getGrade().equals("P")) && !(subjects_M.get(i).getGrade().equals("NP"))) {
                if (subjects_M.get(i).getGrade().equals("A+")) {
                    sgwAverage += 4.5F * Integer.parseInt(subjects_M.get(i).getCredit());
                } else if (subjects_M.get(i).getGrade().equals("A0")) {
                    sgwAverage += 4.0F * Integer.parseInt(subjects_M.get(i).getCredit());
                } else if (subjects_M.get(i).getGrade().equals("B+")) {
                    sgwAverage += 3.5F * Integer.parseInt(subjects_M.get(i).getCredit());
                } else if (subjects_M.get(i).getGrade().equals("B0")) {
                    sgwAverage += 3.0F * Integer.parseInt(subjects_M.get(i).getCredit());
                } else if (subjects_M.get(i).getGrade().equals("C+")) {
                    sgwAverage += 2.5F * Integer.parseInt(subjects_M.get(i).getCredit());
                } else if (subjects_M.get(i).getGrade().equals("C0")) {
                    sgwAverage += 2.0F * Integer.parseInt(subjects_M.get(i).getCredit());
                } else if (subjects_M.get(i).getGrade().equals("D+")) {
                    sgwAverage += 1.5F * Integer.parseInt(subjects_M.get(i).getCredit());
                } else if (subjects_M.get(i).getGrade().equals("D0")) {
                    sgwAverage += 1.0F * Integer.parseInt(subjects_M.get(i).getCredit());
                } else if (subjects_M.get(i).getGrade().equals("F")) {
                    sgwAverage += 0.F * Integer.parseInt(subjects_M.get(i).getCredit());
                }
            }
        }


        for (int i = 0; i < subjects_G.size(); i++) {
            if (!(subjects_G.get(i).getGrade().equals("P")) && !(subjects_G.get(i).getGrade().equals("NP"))) {
                if (subjects_G.get(i).getGrade().equals("A+")) {
                    sgwAverage += 4.5F * Integer.parseInt(subjects_G.get(i).getCredit());
                } else if (subjects_G.get(i).getGrade().equals("A0")) {
                    sgwAverage += 4.0F * Integer.parseInt(subjects_G.get(i).getCredit());
                } else if (subjects_G.get(i).getGrade().equals("B+")) {
                    sgwAverage += 3.5F * Integer.parseInt(subjects_G.get(i).getCredit());
                } else if (subjects_G.get(i).getGrade().equals("B0")) {
                    sgwAverage += 3.0F * Integer.parseInt(subjects_G.get(i).getCredit());
                } else if (subjects_G.get(i).getGrade().equals("C+")) {
                    sgwAverage += 2.5F * Integer.parseInt(subjects_G.get(i).getCredit());
                } else if (subjects_G.get(i).getGrade().equals("C0")) {
                    sgwAverage += 2.0F * Integer.parseInt(subjects_G.get(i).getCredit());
                } else if (subjects_G.get(i).getGrade().equals("D+")) {
                    sgwAverage += 1.5F * Integer.parseInt(subjects_G.get(i).getCredit());
                } else if (subjects_G.get(i).getGrade().equals("D0")) {
                    sgwAverage += 1.0F * Integer.parseInt(subjects_G.get(i).getCredit());
                } else if (subjects_G.get(i).getGrade().equals("F")) {
                    sgwAverage += 0.F * Integer.parseInt(subjects_G.get(i).getCredit());
                }
            }

            allAverage = sgwAverage / getCredit_except_F_NP(subjects_M, subjects_G);
        }
        return allAverage;
    }

    public float averageMajorScore(ArrayList<Subject> subjects_M, ArrayList<Subject> subjects_G) {
        float majorAverage = 0;
        float sgwAverage = 0.F;
        int majorCredit = 0;
        for (int i = 0; i < subjects_M.size(); i++) {
            if (!(subjects_M.get(i).getGrade().equals("F")) && !(subjects_M.get(i).getGrade().equals("NP"))) {
                if (subjects_M.get(i).getGrade().equals("A+")) {
                    sgwAverage += 4.5F * Integer.parseInt(subjects_M.get(i).getCredit());
                } else if (subjects_M.get(i).getGrade().equals("A0")) {
                    sgwAverage += 4.0F * Integer.parseInt(subjects_M.get(i).getCredit());
                } else if (subjects_M.get(i).getGrade().equals("B+")) {
                    sgwAverage += 3.5F * Integer.parseInt(subjects_M.get(i).getCredit());
                } else if (subjects_M.get(i).getGrade().equals("B0")) {
                    sgwAverage += 3.0F * Integer.parseInt(subjects_M.get(i).getCredit());
                } else if (subjects_M.get(i).getGrade().equals("C+")) {
                    sgwAverage += 2.5F * Integer.parseInt(subjects_M.get(i).getCredit());
                } else if (subjects_M.get(i).getGrade().equals("C0")) {
                    sgwAverage += 2.0F * Integer.parseInt(subjects_M.get(i).getCredit());
                } else if (subjects_M.get(i).getGrade().equals("D+")) {
                    sgwAverage += 1.5F * Integer.parseInt(subjects_M.get(i).getCredit());
                } else if (subjects_M.get(i).getGrade().equals("D0")) {
                    sgwAverage += 1.0F * Integer.parseInt(subjects_M.get(i).getCredit());
                }
            }

        }
        for(int j = 0; j < subjects_M.size(); j++){
            majorCredit += Integer.parseInt(subjects_M.get(j).getCredit());
        }

        majorAverage = sgwAverage / majorCredit;

        return majorAverage;
    }

    public void listOfSubjects(ArrayList<Subject> subjects_M, ArrayList<Subject> subjects_G) {
        for (int i = 0; i < subjects_M.size(); i++) {
            System.out.print("[전공] ");
            System.out.print(subjects_M.get(i).getName());
            System.out.print(",");
            System.out.print(subjects_M.get(i).getCredit());
            System.out.print(",");
            System.out.println(subjects_M.get(i).getGrade());
        }
        for (int i = 0; i < subjects_G.size(); i++) {
            System.out.print("[교양] ");
            System.out.print(subjects_G.get(i).getName());
            System.out.print(",");
            System.out.print(subjects_G.get(i).getCredit());
            System.out.print(",");
            System.out.println(subjects_G.get(i).getGrade());
        }

    }

//    public void Check(ArrayList<Subject> subjects_M, ArrayList<Subject> subjects_G){
//        try {
//            checkError(subjects_M,subjects_G);
//        } catch (IllegalAccessException e) {
//            throw e;
//        }
//    }

    public void checkCreditError(ArrayList<Subject> subjects_M, ArrayList<Subject> subjects_G) {
        for(int i = 0; i < subjects_M.size(); i++){
            if(subjects_M.get(i).getName().length() > 10){
                throw new IllegalArgumentException();
            }
        }

        for(int i = 0; i < subjects_G.size(); i++){
            if(subjects_G.get(i).getName().length() > 10){
                throw new IllegalArgumentException();
            }
        }


        for(int i = 0; i < subjects_M.size(); i++){
            if(Integer.parseInt(subjects_M.get(i).getCredit()) < 1 || Integer.parseInt(subjects_M.get(i).getCredit()) > 4 ){
                throw new IllegalArgumentException();
            }
        }

        for(int i = 0; i < subjects_G.size(); i++){
            if(Integer.parseInt(subjects_G.get(i).getCredit()) < 1 || Integer.parseInt(subjects_G.get(i).getCredit()) > 4 ){
                throw new IllegalArgumentException();
            }
        }
    }

    public void checkGradeError(ArrayList<Subject> subjects_M, ArrayList<Subject> subjects_G) {
        for(int i = 0; i < subjects_M.size(); i++){
            if(subjects_M.get(i).getGrade().equals("A+") || subjects_M.get(i).getGrade().equals("A0") || subjects_M.get(i).getGrade().equals("B+") || subjects_M.get(i).getGrade().equals("B0")
            || subjects_M.get(i).getGrade().equals("C+") || subjects_M.get(i).getGrade().equals("C0") || subjects_M.get(i).getGrade().equals("D+") || subjects_M.get(i).getGrade().equals("D0")
            || subjects_M.get(i).getGrade().equals("F") || subjects_M.get(i).getGrade().equals("NP") || subjects_M.get(i).getGrade().equals("P")){

            }else {
                throw new IllegalArgumentException();
            }
        }
    }
}
