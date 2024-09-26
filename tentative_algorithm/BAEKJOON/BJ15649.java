import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        result(new ArrayList<>(), N, M);
    }

    public static void result(List<Integer> B, int N, int M) {
        if (B.size() == M) {
            System.out.println(B.toString().replace("[", "").replace("]", "").replace(",", ""));
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!B.contains(i)) {
                B.add(i);
                result(B, N, M);
                B.remove(B.size() - 1);
            }
        }
    }
}
//15649