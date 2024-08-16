import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private Map<String, Map<String, Double>> graph = new HashMap<>();

    public void addEquation(String A, String B, double value) {
        graph.putIfAbsent(A, new HashMap<>());
        graph.putIfAbsent(B, new HashMap<>());
        graph.get(A).put(B, value);
        graph.get(B).put(A, 1.0 / value);
    }

    public double dfs(String start, String end, double product, Map<String, Boolean> visited) {
        if (!graph.containsKey(start)) return -1.0;
        if (start.equals(end)) return product;

        visited.put(start, true);
        for (String neighbor : graph.get(start).keySet()) {
            if (!visited.getOrDefault(neighbor, false)) {
                double result = dfs(neighbor, end, product * graph.get(start).get(neighbor), visited);
                if (result != -1.0) return result;
            }
        }
        visited.put(start, false);
        return -1.0;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for (int i = 0; i < equations.size(); i++) {
            addEquation(equations.get(i).get(0), equations.get(i).get(1), values[i]);
        }

        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String A = queries.get(i).get(0);
            String B = queries.get(i).get(1);
            results[i] = dfs(A, B, 1.0, new HashMap<>());
        }
        return results;
    }

    public static void main(String[] args) {
        Main eval = new Main();
        List<List<String>> equations = List.of(List.of("a", "b"), List.of("b", "c"));
        double[] values = {2.0, 3.0};
        List<List<String>> queries = List.of(List.of("a", "c"), List.of("b", "a"), List.of("a", "e"), List.of("a", "a"), List.of("x", "x"));

        double[] results = eval.calcEquation(equations, values, queries);
        for (double result : results) {
            System.out.printf("%.5f\n", result);
        }
    }
}
