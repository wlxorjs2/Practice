public class Main {
    public int uniquePaths(int m, int n) {
        // m x n 그리드에서 각 위치에 도달하는 경로 수를 저장할 2D 배열
        int[][] dp = new int[m][n];

        // 첫 번째 열과 첫 번째 행은 경로가 하나이므로 1로 초기화
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1; // 첫 번째 열
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1; // 첫 번째 행
        }

        // 나머지 그리드의 각 위치에 대해 경로 수 계산
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 현재 위치의 경로 수는 위쪽과 왼쪽 위치의 경로 수의 합
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        // 오른쪽 아래 모서리의 경로 수 반환
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Main solution = new Main();
        int m = 3, n = 7;
        System.out.println("Unique Paths for (" + m + ", " + n + "): " + solution.uniquePaths(m, n));

        m = 3; n = 2;
        System.out.println("Unique Paths for (" + m + ", " + n + "): " + solution.uniquePaths(m, n));
    }
}
