package gpacalc;

public class Refinements {

    String name,gain,grade ;
    float score ;

    Refinements (String n1, String n2, String n3){
        this.name = n1;
        this.gain = n2;
        this.grade = n3;
    }

    public String toString(){
        return "[교양]"+name + "," + gain + "," + grade;
    }

    // P나 NP
    public int getGain() {
        if(grade.equals("P") || grade.equals("NP") )
            return 0;
        return Integer.parseInt(gain);
    }

    public int getGain2() {
        if(grade.equals("F") || grade.equals("NP") )
            return 0;
        else return Integer.parseInt(gain);
    }

    public float getScore() {
        if (grade.equals("A+"))
            score = 4.5f;
        else if (grade.equals("A0"))
            score = 4.0f;
        else if (grade.equals("B+"))
            score = 3.5f;
        else if (grade.equals("B0"))
            score = 3.0f;
        else if (grade.equals("C+"))
            score = 2.5f;
        else if (grade.equals("C0"))
            score = 2.0f;
        else if (grade.equals("D+"))
            score = 1.5f;
        else if (grade.equals("D0"))
            score = 1.0f;
        else if (grade.equals("F"))
            score = 0.0f;


        return score;
    }

    public float getAverage() { //과목성적가중치
        float average;
        average= getScore() * getGain();
        return average;
    }

}
