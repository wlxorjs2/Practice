import java.util.Arrays;

public class Main {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int hIndex = 0;
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n - i) {
                hIndex = n - i;
                break;
            }
        }
        return hIndex;
    }
    public static void main(String[] args) {
        Main sol = new Main();
        System.out.println(sol.solution(new int[]{3, 0, 6, 1, 5})); // H-Index는 3
        System.out.println(sol.solution(new int[]{1, 3, 1})); // H-Index는 1
    }
}
