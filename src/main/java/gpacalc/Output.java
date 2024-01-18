package gpacalc;

public class Output {

    public void printInfo(String[][] major, String[][] general){
        System.out.println("\n<과목 목록>");
        for (String[] info : major) {
            System.out.println("[전공] " + info[0] + "," + info[1] + "," + info[2]);
        }
        for (String[] info : general) {
            System.out.println("[교양] " + info[0] + "," + info[1] + "," + info[2]);
        }
    }

    public void printScore(int point, double allAve, double majorAve){
        System.out.println("\n<취득학점>");
        System.out.println(point + "학점");

        System.out.println("\n<평점평균>");
        System.out.println(String.format("%.2f", allAve) + " / 4.5");

        System.out.println("\n<전공 평점평균>");
        System.out.println(String.format("%.2f", majorAve) + " / 4.5");
    }
}