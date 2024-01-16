package gpacalc;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Subjects subjects = new Subjects();

        System.out.println("Enter major subjects (Example: Data Structures-3-A+,Java Programming-3-B+):");
        String major = Console.readLine();
        subjects.input(major, "Major");

        System.out.println("Enter general education subjects (Example: Art Appreciation-3-P,General Studies-1-NP,Understanding Christianity-2-F):");
        String GE = Console.readLine();
        subjects.input(GE, "General Education");
        System.out.println();

        System.out.println("<Subject List>");
        subjects.print();
        System.out.println();

        System.out.println("<Earned Credits>");
        int credit = subjects.calculateCredit();
        System.out.println(credit + " Credits");
        System.out.println();

        System.out.println("<GPA Average>");
        String average = subjects.calculateAverage();
        System.out.println(average + " / 4.5");
        System.out.println();

        System.out.println("<Major GPA Average>");
        String majorAverage = subjects.calculateAverage("Major");
        System.out.println(majorAverage + " / 4.5");
    }
}

