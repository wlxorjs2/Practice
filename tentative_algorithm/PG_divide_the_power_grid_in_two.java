import java.util.ArrayList;
import java.util.List;

public class Main {
    private List<List<Integer>> graph;
    private int minDifference = Integer.MAX_VALUE;

    public int solution(int n, int[][] wires) {
        // 그래프 초기화
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 그래프에 전선 정보를 추가
        for (int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }

        // 각 전선에 대해 끊어보며 서브트리의 송전탑 개수 차이를 계산
        for (int[] wire : wires) {
            // 전선 끊기
            graph.get(wire[0]).remove((Integer) wire[1]);
            graph.get(wire[1]).remove((Integer) wire[0]);

            // 서브트리의 송전탑 개수 구하기
            int count = dfs(wire[0], new boolean[n + 1]);
            int difference = Math.abs(n - count - count);
            minDifference = Math.min(minDifference, difference);

            // 전선 복구
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }

        return minDifference;
    }

    private int dfs(int node, boolean[] visited) {
        visited[node] = true;
        int count = 1;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                count += dfs(neighbor, visited);
            }
        }
        return count;
    }
}