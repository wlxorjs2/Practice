import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    private static final int[] dx = {-1, 1, 0, 0}; // 상하좌우
    private static final int[] dy = {0, 0, -1, 1}; // 상하좌우
    private static int rows, cols;

    public static int[] solution(String[] maps) {
        rows = maps.length;
        cols = maps[0].length();
        boolean[][] visited = new boolean[rows][cols];
        List<Integer> islandFood = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (maps[i].charAt(j) != 'X' && !visited[i][j]) {
                    int food = dfs(maps, visited, i, j);
                    islandFood.add(food);
                }
            }
        }

        // 결과 정리
        if (islandFood.isEmpty()) {
            return new int[]{-1};
        }

        Collections.sort(islandFood);
        return islandFood.stream().mapToInt(i -> i).toArray();
    }

    private static int dfs(String[] maps, boolean[][] visited, int x, int y) {
        // 현재 위치 방문 처리
        visited[x][y] = true;
        int food = maps[x].charAt(y) - '0'; // 현재 칸의 식량 수

        // 상하좌우 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위 체크
            if (nx >= 0 && nx < rows && ny >= 0 && ny < cols) {
                if (maps[nx].charAt(ny) != 'X' && !visited[nx][ny]) {
                    food += dfs(maps, visited, nx, ny); // 재귀 호출
                }
            }
        }
        return food; // 총 식량 반환
    }

    public static void main(String[] args) {
        String[] maps1 = {"X591X", "X1X5X", "X231X", "1XXX1"};
        String[] maps2 = {"XXX", "XXX", "XXX"};

        int[] result1 = solution(maps1);
        int[] result2 = solution(maps2);

        // 결과 출력
        System.out.println(java.util.Arrays.toString(result1)); // [1, 1, 27]
        System.out.println(java.util.Arrays.toString(result2)); // [-1]
    }
}
