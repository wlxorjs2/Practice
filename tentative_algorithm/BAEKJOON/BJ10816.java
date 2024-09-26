import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        HashMap<Integer, Integer> cardCountMap = new HashMap<>();
        String[] cards = reader.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            int card = Integer.parseInt(cards[i]);
            cardCountMap.put(card, cardCountMap.getOrDefault(card, 0) + 1);
        }
        int M = Integer.parseInt(reader.readLine());
        String[] queries = reader.readLine().split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int query = Integer.parseInt(queries[i]);
            result.append(cardCountMap.getOrDefault(query, 0)).append(" ");
        }
        System.out.println(result.toString().trim());
    }
}