import java.util.PriorityQueue;

public class Main {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (String operation : operations) {
            String[] parts = operation.split(" ");
            String command = parts[0];
            int number = Integer.parseInt(parts[1]);

            if (command.equals("I")) {
                minHeap.offer(number);
                maxHeap.offer(number);
            } else if (command.equals("D")) {
                if (number == 1 && !maxHeap.isEmpty()) {
                    int maxValue = maxHeap.poll();
                    minHeap.remove(maxValue);
                } else if (number == -1 && !minHeap.isEmpty()) {
                    int minValue = minHeap.poll();
                    maxHeap.remove(minValue);
                }
            }
        }

        return minHeap.isEmpty() ? new int[]{0, 0} : new int[]{maxHeap.peek(), minHeap.peek()};
    }

    public static void main(String[] args) {
        Main sol = new Main();

        // 테스트 케이스 출력
        System.out.println("Result 1: [" + sol.solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"})[0] +
                ", " + sol.solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"})[1] + "]");
        System.out.println("Result 2: [" + sol.solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"})[0] +
                ", " + sol.solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"})[1] + "]");
    }
}
