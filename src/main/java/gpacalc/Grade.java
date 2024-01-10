package gpacalc;

public enum Grade {// 성적 enum 클래스
    A_PLUS("A+",4.5),
    A_ZERO("A0",4.0),
    B_PLUS("B+",3.5),
    B_ZERO("B0",3.0),
    C_PLUS("C+",2.5),
    C_ZERO("C0",2.0),
    D_PLUS("D+",1.5),
    D_ZERO("D0",1.0),
    P("P",0.0),
    NP("NP",0.0),
    F("F",0.0);
    private final String grade;
    private final double score;

    Grade(String grade, double score){
        this.grade = grade;
        this.score = score;
    }

    public static Grade of(String grade){// 입력받은 성적에 해당하는 enum 반환
        for(Grade g : Grade.values()){
            if(g.grade.equals(grade)){
                return g;
            }
        }
        throw new IllegalArgumentException("잘못된 성적 입력입니다.");// 잘못된 성적 입력시 예외처리
    }

    public double getScore(){
        return this.score;
    }

    public String getGrade(){
        return this.grade;
    }
}
