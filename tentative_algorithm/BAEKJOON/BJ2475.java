import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();
        int sum = (a*a + b*b + c*c + d*d + e*e) % 10;
        System.out.println(sum);
    }
}
//5개의 값을 받아 각 각의 제곱의 값을 더한 값에 10으로 나눈 나머지를 구하는 문제
//BJ2475