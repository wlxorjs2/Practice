import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] result = new int[n];

        // 시작 시간을 기준으로 구간을 정렬하고 인덱스를 저장
        int[][] indexedIntervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            indexedIntervals[i][0] = intervals[i][0]; // 시작 시간
            indexedIntervals[i][1] = i; // 원래 인덱스
        }

        // 시작 시간을 기준으로 정렬
        Arrays.sort(indexedIntervals, Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < n; i++) {
            int end = intervals[i][1];
            // 이진 탐색을 통해 시작 시간이 end 이상인 첫 번째 구간 찾기
            int index = binarySearch(indexedIntervals, end);
            result[i] = (index < n) ? indexedIntervals[index][1] : -1; // 인덱스 저장
        }

        return result;
    }

    // 이진 탐색을 통해 시작 시간이 target 이상인 첫 번째 구간의 인덱스를 찾음
    private static int binarySearch(int[][] intervals, int target) {
        int left = 0, right = intervals.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (intervals[mid][0] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left; // 시작 시간이 target 이상인 첫 번째 구간의 인덱스
    }

    public static void main(String[] args) {
        int[][] intervals1 = {{1, 2}};
        int[][] intervals2 = {{3, 4}, {2, 3}, {1, 2}};
        int[][] intervals3 = {{1, 4}, {2, 3}, {3, 4}};

        System.out.println(Arrays.toString(findRightInterval(intervals1))); // [-1]
        System.out.println(Arrays.toString(findRightInterval(intervals2))); // [-1, 0, 1]
        System.out.println(Arrays.toString(findRightInterval(intervals3))); // [-1, 2, -1]
    }
}
