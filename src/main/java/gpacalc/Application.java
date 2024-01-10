package gpacalc;

import static camp.nextstep.edu.missionutils.Console.readLine;
import camp.nextstep.edu.missionutils.Console;

public class Application {
  public static void main(String[] args) {
    //TODO: 구현

    // -> args로 적은 것을 이제, Console에서 입력해준 것으로 바꿔주면 될 듯!
    // 전공과 교양 구분을 해야하네. 2번 입력 받는 걸로 해야함.
//    Scanner scanner = new Scanner(System.in);

    System.out.println("전공 과목명과 이수학점, 평점을 입력해주세요(예시: 프로그래밍언어론-3-A+,소프트웨어공학-3-B+):");
    String major = Console.readLine();
//    String major = scanner.nextLine();

    System.out.println("교양 과목명과 이수학점, 평점을 입력해주세요(예시: 선형대수학-3-C0,인간관계와자기성장-3-P):");
    String liberal = Console.readLine();
//    String liberal = scanner.nextLine();

    Categorize(major, "전공");
    Categorize(liberal, "교양");
    System.out.println();

    int credit = GetCredit(major) + GetCredit(liberal);
    System.out.println("<취득학점>");
    System.out.println(credit + "학점\n");

    System.out.println("<평점평균>");
    Calculate(major + "," + liberal ,credit);

    System.out.println("<전공 평점평균>");
    Calculate(major, GetCredit(major));
  }

  // Exception handler는 전체적으로 손 좀 봐야할 듯..
  public static void Check(String subject) {
    if (subject.length() < 1 || 10 < subject.length()) {
      throw new IllegalArgumentException();
    }
  }
  public static void Categorize(String input, String major_liberal) {
    // 문자열시킨 것을 , 단위 split하기 -> - 단위 split
    String[] first_split = input.split(",");
    String[][] second_split = new String[first_split.length][3];
    for (int i = 0; i < first_split.length; i++) {
      second_split[i] = first_split[i].split("-");
    }

    // 입력받은 것 중 공백 or 10자리 넘는 것에 대한 예외처리!!
    for (int i = 0; i < first_split.length; i++) {
      Check(second_split[i][0]);
    }

    // check
    for (int i = 0; i < first_split.length; i++) {
      System.out.print("[" + major_liberal + "] ");
      for (int j = 0; j < 3; j++) {
        System.out.print(second_split[i][j]);
        if (j != 2) System.out.print(",");
      }
      System.out.println();
    }
  }

  public static int GetCredit(String all) {
    int credit = 0;
    String[] first_split = all.split(",");
    String[][] second_split = new String[first_split.length][3];
    for (int i = 0; i < first_split.length; i++) second_split[i] = first_split[i].split("-");
    for (String[] strings : second_split) {
      if (Integer.parseInt(strings[1]) < 1 || 4 < Integer.parseInt(strings[1]))
        throw new IllegalArgumentException("학점을 확인해주세요.");
      if (strings[2].equals("F") || strings[2].equals("NP")) continue;
      credit += Integer.parseInt(strings[1]);
    }
    return credit;
  }
  public static void Calculate(String all, int credit){
    // A+(4.5), A0(4.0), B+(3.5), B0(3.0), C+(2.5), C0(2.0), D+(1.5), D0(1.0), F(0)
    // 평점평균 = 과목성적가중치의 총합 / 과목학점의 총합
    // 과목성적가중치 = 과목평점 * 과목학점

    String[] first_split = all.split(",");
    String[][] second_split = new String[first_split.length][3];
    for(int i = 0 ; i < first_split.length ; i++){
      second_split[i] = first_split[i].split("-");
    }

    // credit에서 P받은 것만큼은 다시 빼줘야해.. -> P, NP 제외하고, 학점 계산이래.. 음음..
    for(int i = 0 ; i < first_split.length ; i++){
      if(second_split[i][2].equals("P")) credit -= Integer.parseInt(second_split[i][1]);
      if(second_split[i][2].equals("F")) credit += Integer.parseInt(second_split[i][1]);
    }

    // 전체 확인
    double sum = 0;
    for(int i = 0 ;i < first_split.length ; i++){
      sum += (Double.parseDouble(second_split[i][1]) * matching(second_split[i][2]));
    }
    double result = sum / credit;
    System.out.println("credit  : " + credit);
    System.out.println(Math.round(result*100)/(double)100 + " / 4.5\n");
  }

  public static double matching(String grade){
    double score = 0;
    switch(grade){
      case "A+" -> score = 4.5;
      case "A0" -> score = 4.0;
      case "B+" -> score = 3.5;
      case "B0" -> score = 3.0;
      case "C+" -> score = 2.5;
      case "C0" -> score = 2.0;
      case "D+" -> score = 1.5;
      case "D0" -> score = 1.0;
      default -> score = 0;
    }
    return score;
  }

}
