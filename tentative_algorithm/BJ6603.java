import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int k = sc.nextInt();
            if (k == 0) break;

            int[] S = new int[k];
            for (int i = 0; i < k; i++) {
                S[i] = sc.nextInt();
            }
            int[] lotto = new int[6];
            result(S, lotto, 0, 0);
            System.out.println();
        }
    }
    public static void result(int[] S, int[] lotto, int b, int index) {
        if (index == 6) {
            for (int i = 0; i < lotto.length; i++) {
                System.out.print(lotto[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = b; i < S.length; i++) {
            lotto[index] = S[i];
            result(S, lotto, i + 1, index + 1);
        }
    }
}
//6603