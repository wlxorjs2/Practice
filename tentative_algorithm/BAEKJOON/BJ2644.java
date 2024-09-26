import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int personA = scanner.nextInt();
        int personB = scanner.nextInt();
        int m = scanner.nextInt();
        int[] parents = new int[n + 1];
        Arrays.fill(parents, -1);
        for (int i = 0; i < m; i++) {
            int parent = scanner.nextInt();
            int child = scanner.nextInt();
            parents[child] = parent;
        }
        int relation = calculateRelation(personA, personB, parents);
        System.out.println(relation);
    }
    private static int calculateRelation(int a, int b, int[] parents) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[parents.length];
        int level = 0;
        queue.add(new int[]{a, level});
        visited[a] = true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int person = current[0];
            level = current[1];
            if (parents[person] != -1 && !visited[parents[person]]) {
                if (parents[person] == b) {
                    return level + 1;
                }
                queue.add(new int[]{parents[person], level + 1});
                visited[parents[person]] = true;
            }
            for (int i = 1; i < parents.length; i++) {
                if (parents[i] == person && !visited[i]) {
                    if (i == b) {
                        return level + 1;
                    }
                    queue.add(new int[]{i, level + 1});
                    visited[i] = true;
                }
            }
        }
        return -1;
    }
}