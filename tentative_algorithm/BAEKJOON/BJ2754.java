import java.util.Objects;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String score = sc.nextLine();
        if (Objects.equals(score, "A+")) {
            System.out.println("4.3");
        } else if (Objects.equals(score, "A0")) {
            System.out.println("4.0");
        } else if (Objects.equals(score, "A-")) {
            System.out.println("3.7");
        } else if (Objects.equals(score, "B+")) {
            System.out.println("3.3");
        } else if (Objects.equals(score, "B0")) {
            System.out.println("3.0");
        } else if (Objects.equals(score, "B-")) {
            System.out.println("2.7");
        } else if (Objects.equals(score, "C+")) {
            System.out.println("2.3");
        } else if (Objects.equals(score, "C0")) {
            System.out.println("2.0");
        } else if (Objects.equals(score, "C-")) {
            System.out.println("1.7");
        } else if (Objects.equals(score, "D+")) {
            System.out.println("1.3");
        } else if (Objects.equals(score, "D0")) {
            System.out.println("1.0");
        } else if (Objects.equals(score, "D-")) {
            System.out.println("0.7");
        } else if (Objects.equals(score, "F")) {
            System.out.println("0.0");
        }
    }
}
// 개노가다;; Objects.equals(비교1, 비교2) 로 점수 체크
// switch-case로 가능
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String score = sc.nextLine();
//        double gpa = getGPA(score);
//        System.out.println(gpa);
//    }
//
//    private static double getGPA(String score) {
//        switch (score) {
//            case "A+":
//                return 4.3;
//            case "A0":
//                return 4.0;
//            case "A-":
//                return 3.7;
//            case "B+":
//                return 3.3;
//            case "B0":
//                return 3.0;
//            case "B-":
//                return 2.7;
//            case "C+":
//                return 2.3;
//            case "C0":
//                return 2.0;
//            case "C-":
//                return 1.7;
//            case "D+":
//                return 1.3;
//            case "D0":
//                return 1.0;
//            case "D-":
//                return 0.7;
//            case "F":
//                return 0.0;
//            default:
//                return 0.0;
//        }
//    }
//}
//BJ2754