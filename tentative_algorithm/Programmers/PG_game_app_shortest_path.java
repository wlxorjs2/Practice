import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static class Position {
        int x, y, distance;

        Position(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        // 이동 방향 (동, 서, 남, 북)
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // BFS를 위한 큐
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(0, 0, 1)); // 시작 위치 (0, 0)와 거리 1

        // 방문 배열
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Position current = queue.poll();

            // 도착지에 도달한 경우
            if (current.x == n - 1 && current.y == m - 1) {
                return current.distance;
            }

            // 상하좌우 이동
            for (int[] direction : directions) {
                int newX = current.x + direction[0];
                int newY = current.y + direction[1];

                // 유효한 위치인지 확인
                if (newX >= 0 && newX < n && newY >= 0 && newY < m && !visited[newX][newY] && maps[newX][newY] == 1) {
                    visited[newX][newY] = true;
                    queue.offer(new Position(newX, newY, current.distance + 1));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Main sol = new Main();
        int[][] maps1 = {
                {1, 0, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 1, 1, 1},
                {1, 1, 1, 0, 1}
        };
        System.out.println(sol.solution(maps1)); // 출력: 11

        int[][] maps2 = {
                {1, 0, 0},
                {1, 0, 1},
                {0, 1, 1}
        };
        System.out.println(sol.solution(maps2)); // 출력: -1
    }
}
