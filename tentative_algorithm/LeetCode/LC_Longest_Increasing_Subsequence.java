import java.util.Arrays;

public class Main {

    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        int length = 0; // 현재 가장 긴 증가하는 부분 수열의 길이

        for (int num : nums) {
            // 이진 탐색을 통해 현재 숫자가 들어갈 위치를 찾음
            int left = 0, right = length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (dp[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            // left는 num이 들어가야 할 위치
            dp[left] = num;
            // 만약 left가 현재 길이와 같다면, 새로운 숫자를 추가한 것
            if (left == length) {
                length++;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] nums2 = {0, 1, 0, 3, 2, 3};
        int[] nums3 = {7, 7, 7, 7, 7, 7, 7};

        System.out.println(lengthOfLIS(nums1)); // 4
        System.out.println(lengthOfLIS(nums2)); // 4
        System.out.println(lengthOfLIS(nums3)); // 1
    }
}
