import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int E = scanner.nextInt();
        int S = scanner.nextInt();
        int M = scanner.nextInt();
        int year = 1;
        int countE = 1, countS = 1, countM = 1;
        while (true) {
            if (countE == E && countS == S && countM == M) {
                break;
            }
            countE++;
            countS++;
            countM++;
            if (countE > 15) {
                countE = 1;
            }
            if (countS > 28) {
                countS = 1;
            }
            if (countM > 19) {
                countM = 1;
            }
            year++;
        }
        System.out.println(year);
    }
}