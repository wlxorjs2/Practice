import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        List<Long> result = Solution.solution(n, x);
        for (Long num : result) {
            System.out.print(num + " ");
        }
    }

    class Solution {
        public static List<Long> solution(int x, int n) {
            List<Long> answer = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                answer.add((long) x * i);
            }
            return answer;
        }
    }
}