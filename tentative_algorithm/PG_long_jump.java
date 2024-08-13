public class Main {
    public int solution(int n) {
        int MOD = 1234567; // 나머지로 사용할 값

        // n이 1 또는 2일 때의 기본 케이스
        if (n == 1) return 1;
        if (n == 2) return 2;

        int[] dp = new int[n + 1]; // dp 배열 선언
        dp[1] = 1; // 1칸에 도달하는 방법
        dp[2] = 2; // 2칸에 도달하는 방법

        // dp 배열을 채우기
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD; // 점화식
        }

        return dp[n]; // n번째 칸에 도달하는 방법 수 반환
    }

    public static void main(String[] args) {
        Main solution = new Main();

        System.out.println(solution.solution(4)); // 출력: 5
        System.out.println(solution.solution(3)); // 출력: 3
        System.out.println(solution.solution(2000)); // 큰 값 테스트
    }
}
