package gpacalc;

abstract public class Subjects{
    String name,gain,grade ;
    float score ;
    final int MAXIMUM_LENGTH = 10, MINIMUM_SCORE = 1 , MAXIMUM_SCORE = 4 ;
    Subjects (String n1, String n2, String n3) {
        InvalidData(n1,n2,n3);
        this.name = n1;
        this.gain = n2;
        this.grade = n3;
    }
    private void InvalidData(String n1 , String n2, String n3) {
        isInvalidName(n1);
        isInvalidGain(n2);
        isInvalidGrade(n3);
    }
    public void isInvalidName(String n1) {
        if (n1.isBlank() || n1.length() > MAXIMUM_LENGTH) {
            throw new IllegalArgumentException("이름은 1자 이상 10자 이하여야 합니다.");
        }

    }

    public void isInvalidGain(String n2){
        int gainValue = Integer.parseInt(n2);
        if (gainValue < MINIMUM_SCORE || gainValue > MAXIMUM_SCORE) {
            throw new IllegalArgumentException("잘못된 학점 입력");
        }
    }

    public void isInvalidGrade(String n3){
        if (!isGrade(n3)){
            throw new IllegalArgumentException("잘못된 성적 입력");
        }
    }
    public boolean isGrade(String s) {
        return s.equals("A+") || s.equals("A0") || s.equals("B+") || s.equals("B0") ||
                s.equals("C+") || s.equals("C0") || s.equals("D+") || s.equals("D0") ||
                s.equals("F") || s.equals("P") || s.equals("PD") || s.equals("NP");
    }
    public int getGainForAverage() { // 과목성적가중치를 위한 메서드
        if(grade.equals("P") || grade.equals("NP") || grade.equals("PD"))
            return 0;
        else return Integer.parseInt(gain);
    }
    public int getGainForTotal() { // 학점총점을 위한 메서드
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
    public float getAverage() {  //과목성적가중치
        float average;
        average= getScore() * getGainForAverage();
        return average;
    }

}
class Majors extends Subjects {
    Majors(String n1, String n2, String n3) {
        super(n1, n2, n3); // 상위 클래스(Subjects)의 생성자 호출
    }
    @Override
    public String toString() {return "[전공] " + name + ',' +  gain + "," + grade;}

}

class Refinements extends Subjects {
    Refinements(String n1, String n2, String n3) {
        super(n1, n2, n3); // 상위 클래스(Subjects)의 생성자 호출
    }
    @Override
    public String toString() {return "[교양] " + name + ',' +  gain + "," + grade;}

}