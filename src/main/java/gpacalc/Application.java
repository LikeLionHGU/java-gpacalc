package gpacalc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); // 클래스_이름 객체_이름 = new 클래스_이름();

        List<Course> majorCourses = getCourseList("[전공] ", in); // getCourseList 매서드를 호출, majorCourses를 채움
        List<Course> electiveCourses = getCourseList("[교양] ", in);

        System.out.println("\n<과목 목록>");
        printCourseList("[전공] ", majorCourses);
        printCourseList("[교양] ", electiveCourses); // 전공, 교양과목 출력

        int totalCredits = calculateTotalCredits(majorCourses, electiveCourses);
        System.out.println("\n<취득학점>");
        System.out.println(totalCredits + "학점"); // calculateTotalCredits 매서드를 사용해 전공, 교양 총학점

        double totalAverage = calculateOverallAverage(majorCourses, electiveCourses);
        System.out.println("\n<평점평균>");
        System.out.printf("%.2f / 4.5\n", totalAverage);

        double majorAverage = calculateMajorAverage(majorCourses);
        System.out.println("\n<전공 평점평균>");
        System.out.printf("%.2f / 4.5\n", majorAverage); //소수점 두자리까지

        in.close();
    }

    private static List<Course> getCourseList(String type, Scanner scanner) {
        List<Course> courses = new ArrayList<>();
        System.out.println(type+ "과목명과 이수학점, 평점을 입력해주세요:");
        String input = scanner.nextLine();
        String[] courseStrings = input.split(",");

        for (String courseString:courseStrings) {
            String[] parts=courseString.split("-");
            String name=parts[0];
            int credits=Integer.parseInt(parts[1]);
            String grade=parts[2];
            courses.add(new Course(type + name, credits, grade));
        }

        return courses;
    }

    private static void printCourseList(String type, List<Course> courses) {
        for (Course course:courses) {
            System.out.println(course);
        }
    }

    private static int calculateTotalCredits(List<Course> majorCourses, List<Course> electiveCourses) {
        int totalCredits=0;
        for (Course course:majorCourses) {
            totalCredits+=course.getCredits();
        }
        for (Course course:electiveCourses) {
            totalCredits+=course.getCredits();
        }
        return totalCredits;
    }

    private static double calculateOverallAverage(List<Course> majorCourses, List<Course> electiveCourses) {
        double totalWeightedGrade = 0;
        int totalCredits = 0;

        for (Course course:majorCourses) {
            totalWeightedGrade+=course.getWeightedGrade();
            totalCredits+=course.getCredits();
        }

        for (Course course:electiveCourses) {
            totalWeightedGrade+=course.getWeightedGrade();
            totalCredits+=course.getCredits();
        }

        return totalCredits > 0 ? totalWeightedGrade / totalCredits : 0;
    }

    private static double calculateMajorAverage(List<Course> majorCourses) {
        double totalWeightedGrade = 0;
        int totalCredits = 0;

        for (Course course : majorCourses) {
            totalWeightedGrade+=course.getWeightedGrade();
            totalCredits+=course.getCredits();
        }

        return totalCredits>0?totalWeightedGrade/totalCredits : 0;
    }
}

class Course {
    private String name;
    private int credits;
    private String grade;

    public Course(String name, int credits, String grade) {
        this.name = name;
        this.credits = credits;
        this.grade = grade;
    }

    public int getCredits() {
        return credits;
    }

    public double getWeightedGrade() {
        switch (grade) {
            case "A+":
                return 4.5;
            case "A0":
                return 4.0;
            case "B+":
                return 3.5;
            case "B0":
                return 3.0;
            case "C+":
                return 2.5;
            case "C0":
                return 2.0;
            case "D+":
                return 1.5;
            case "D0":
                return 1.0;
            default:
                return 0;
        }
    }

    @Override
    public String toString() {
        return name + "," + credits + "," + grade;
    }
}
