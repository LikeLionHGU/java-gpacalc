package gpacalc;
public class CheckingError {

    public void checkError(String[][] mem){
        for (String[] num : mem) {
            if(num[0].isBlank()){
                throw new IllegalArgumentException("공백으로만 채워지면 안됩니다.");
            }
            if(num[0].length() > 10) {
                throw new IllegalArgumentException("글자수가 10개가 넘어가면 안됩니다.");
            }
            if(Integer.parseInt(num[1]) > 4 || Integer.parseInt(num[1]) < 1) {
                throw new IllegalArgumentException("전공 학점입력이 잘못되었습니다.");
            }
            checkScore(num[2]);
        }
    }

    public void checkScore(String score){
        boolean check;
        switch(score){
            case "A+" -> check = true;
            case "A0" -> check = true;
            case "B+" -> check = true;
            case "B0" -> check = true;
            case "C+" -> check = true;
            case "C0" -> check = true;
            case "D+" -> check = true;
            case "D0" -> check = true;
            case "F" -> check = true;
            case "P" -> check = true;
            case "NP" -> check = true;
            default -> throw new IllegalArgumentException("잘못된 성적 입력입니다.");
        }
    }
}