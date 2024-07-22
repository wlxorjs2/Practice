import java.util.Scanner;

class Solution {
    public long[] solution(int n, long left, long right) {
        long[] answer = new long[(int)(right - left + 1)];
        for (int i = 0; i < answer.length; i++) {
            long value = Math.max((left + i) / n + 1, (left + i) % n + 1);
            answer[i] = value;
        }
        return answer;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution solution = new Solution();
        int n = sc.nextInt();
        int left = sc.nextInt();
        int right = sc.nextInt();
        long[] result = solution.solution(n, left, right);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}