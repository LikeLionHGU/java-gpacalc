package gpacalc;

public class Main {
    public static void main(String[] args) {

        //받기
        gpacalc.Input newStr = new Input();
        String major = newStr.getMajorInput();
        String general = newStr.getElectiveInput();

        //나눠서 저장
        String[][] majorInfo = newStr.separateStr(major);
        String[][] generalInfo = newStr.separateStr(general);

        //에러 체크
        gpacalc.CheckingError errorCheck = new CheckingError();
        errorCheck.checkError(majorInfo);
        errorCheck.checkError(generalInfo);

        //계산
        gpacalc.Calculator calculator = new Calculator();
        int point = calculator.getPoint(majorInfo,generalInfo);
        double allAverage = calculator.getAllAverage(majorInfo,generalInfo);
        double majorAverage = calculator.getMajorAverage(majorInfo);

        //출력
        gpacalc.Output printOutput = new Output();
        printOutput.printInfo(majorInfo,generalInfo);
        printOutput.printScore(point,allAverage,majorAverage);
    }
}