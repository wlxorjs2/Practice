public class Main {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 그리드의 행과 열 크기
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // 경로 수를 저장할 2D 배열
        int[][] dp = new int[m][n];

        // 시작 위치가 장애물인 경우 경로 수는 0
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        // 시작 위치 초기화
        dp[0][0] = 1;

        // 첫 번째 행: 장애물이 없으면 경로 수를 이어감
        for (int j = 1; j < n; j++) {
            dp[0][j] = (obstacleGrid[0][j] == 0) ? dp[0][j - 1] : 0;
        }

        // 첫 번째 열: 장애물이 없으면 경로 수를 이어감
        for (int i = 1; i < m; i++) {
            dp[i][0] = (obstacleGrid[i][0] == 0) ? dp[i - 1][0] : 0;
        }

        // 나머지 그리드의 각 위치에 대해 경로 수 계산
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1]; // 위쪽과 왼쪽 경로 수의 합
                } else {
                    dp[i][j] = 0; // 장애물이 있는 경우 경로 수는 0
                }
            }
        }

        // 오른쪽 아래 모서리의 경로 수 반환
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Main solution = new Main();

        int[][] obstacleGrid1 = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println("Unique Paths with Obstacles (Test 1): " + solution.uniquePathsWithObstacles(obstacleGrid1)); // 출력: 2

        int[][] obstacleGrid2 = {
                {0, 1},
                {0, 0}
        };
        System.out.println("Unique Paths with Obstacles (Test 2): " + solution.uniquePathsWithObstacles(obstacleGrid2)); // 출력: 1
    }
}
