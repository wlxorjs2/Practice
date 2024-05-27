import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        System.out.println(countClaps(N));
    }
    private static int countClaps(int N) {
        int totalClaps = 0;
        for (int i = 1; i <= N; i++) {
            int clapCount = Number(i);
            totalClaps += clapCount;
        }
        return totalClaps;
    }
    private static int Number(int number) {
        int clapCount = 0;
        while (number > 0) {
            int digit = number % 10;
            if (digit == 3 || digit == 6 || digit == 9) {
                clapCount++;
            }
            number /= 10;
        }
        return clapCount;
    }
}