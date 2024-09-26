import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 돌의 개수 n
        int n = scanner.nextInt();
        // 각 돌에서 점프할 수 있는 거리
        int[] jumps = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            jumps[i] = scanner.nextInt();
        }
        // 출발점 s
        int start = scanner.nextInt();
        // 방문 배열과 BFS 큐 초기화
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        // 시작 위치를 큐에 추가하고 방문 체크
        queue.offer(start);
        visited[start] = true;
        int count = 0; // 방문 가능한 돌의 개수
        while (!queue.isEmpty()) {
            int current = queue.poll();
            count++; // 현재 위치를 방문했으므로 카운트 증가
            // 왼쪽으로 점프
            int leftJump = current - jumps[current];
            if (leftJump >= 1 && !visited[leftJump]) {
                visited[leftJump] = true;
                queue.offer(leftJump);
            }
            // 오른쪽으로 점프
            int rightJump = current + jumps[current];
            if (rightJump <= n && !visited[rightJump]) {
                visited[rightJump] = true;
                queue.offer(rightJump);
            }
        }
        System.out.println(count);
    }
}
