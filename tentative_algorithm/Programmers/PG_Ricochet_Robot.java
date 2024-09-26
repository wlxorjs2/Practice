import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static class Point {
        int x, y, moves;

        Point(int x, int y, int moves) {
            this.x = x;
            this.y = y;
            this.moves = moves;
        }
    }

    public int solution(String[] board) {
        int n = board.length;
        int m = board[0].length();
        boolean[][] visited = new boolean[n][m];
        Queue<Point> queue = new LinkedList<>();

        int startX = 0, startY = 0, goalX = 0, goalY = 0;

        // 시작 위치와 목표 위치 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i].charAt(j) == 'R') {
                    startX = i;
                    startY = j;
                } else if (board[i].charAt(j) == 'G') {
                    goalX = i;
                    goalY = j;
                }
            }
        }

        // BFS 초기화
        queue.add(new Point(startX, startY, 0));
        visited[startX][startY] = true;

        // BFS 진행
        int[] dx = {1, -1, 0, 0}; // 하, 상, 우, 좌
        int[] dy = {0, 0, 1, -1};

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            // 목표 지점 도달 확인
            if (current.x == goalX && current.y == goalY) {
                return current.moves;
            }

            // 4 방향으로 이동
            for (int i = 0; i < 4; i++) {
                int newX = current.x, newY = current.y;

                // 장애물에 부딪힐 때까지 계속 이동
                while (isValid(newX + dx[i], newY + dy[i], board)) {
                    newX += dx[i];
                    newY += dy[i];
                }

                // 새로운 위치가 방문되지 않았으면 큐에 추가
                if (!visited[newX][newY]) {
                    visited[newX][newY] = true;
                    queue.add(new Point(newX, newY, current.moves + 1));
                }
            }
        }

        // 목표 지점에 도달할 수 없는 경우
        return -1;
    }

    private boolean isValid(int x, int y, String[] board) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length() && board[x].charAt(y) != 'D';
    }
}
