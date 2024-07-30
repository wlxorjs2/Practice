import java.util.PriorityQueue;

public class Main {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> first = new PriorityQueue<>();

        for (int s : scoville) {
            first.offer(s);
        }

        int mixCount = 0;

        while (first.size() > 1 && first.peek() < K) {
            int newScoville = first.poll() + (first.poll() * 2);
            first.offer(newScoville);
            mixCount++;
        }

        return first.peek() >= K ? mixCount : -1;
    }

    public static void main(String[] args) {
        Main sol = new Main();

        System.out.println(sol.solution(new int[]{1, 2, 3, 9, 10, 12}, 7)); // 2
        System.out.println(sol.solution(new int[]{1, 2, 3, 4, 5}, 11)); // -1
    }
}