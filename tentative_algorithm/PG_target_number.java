public class Main {
    public int solution(int[] numbers, int target) {
        return findTarget(numbers, target, 0, 0);
    }

    private int findTarget(int[] numbers, int target, int index, int currentSum) {
        // 모든 숫자를 사용한 경우
        if (index == numbers.length) {
            // 현재 합이 타겟과 같으면 1 반환, 아니면 0 반환
            return currentSum == target ? 1 : 0;
        }

        // 현재 숫자를 더하거나 빼는 경우를 재귀적으로 계산
        int add = findTarget(numbers, target, index + 1, currentSum + numbers[index]);
        int subtract = findTarget(numbers, target, index + 1, currentSum - numbers[index]);

        // 두 경우의 합을 반환
        return add + subtract;
    }

    public static void main(String[] args) {
        Main sol = new Main();
        int[] numbers1 = {1, 1, 1, 1, 1};
        int target1 = 3;
        System.out.println(sol.solution(numbers1, target1)); // 출력: 5

        int[] numbers2 = {4, 1, 2, 1};
        int target2 = 4;
        System.out.println(sol.solution(numbers2, target2)); // 출력: 2
    }
}
