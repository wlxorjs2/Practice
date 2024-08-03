import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        HashSet<Integer> cardSet = new HashSet<>();
        for (int i = 0; i < N; i++) {
            cardSet.add(scanner.nextInt());
        }
        int M = scanner.nextInt();
        int[] results = new int[M];
        for (int i = 0; i < M; i++) {
            int query = scanner.nextInt();
            results[i] = cardSet.contains(query) ? 1 : 0;
        }
        for (int result : results) {
            System.out.print(result + " ");
        }
        scanner.close();
    }
}