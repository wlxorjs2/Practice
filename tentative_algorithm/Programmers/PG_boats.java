import java.util.Arrays;

public class Main {
    public int solution(int[] people, int limit) {
        // 사람들의 몸무게를 정렬합니다.
        Arrays.sort(people);

        int left = 0; // 가장 가벼운 사람의 인덱스
        int right = people.length - 1; // 가장 무거운 사람의 인덱스
        int boats = 0; // 필요한 구명보트 개수

        // left가 right보다 작거나 같을 때까지 반복
        while (left <= right) {
            // 가장 가벼운 사람과 가장 무거운 사람의 무게를 확인
            if (people[left] + people[right] <= limit) {
                // 두 사람을 같이 태울 수 있는 경우
                left++; // 가벼운 사람의 인덱스를 증가시킵니다.
            }
            // 무거운 사람은 항상 태워야 하므로 인덱스를 감소시킵니다.
            right--;
            boats++; // 구명보트 개수 증가
        }

        return boats; // 필요한 구명보트 개수를 반환합니다.
    }

    public static void main(String[] args) {
        Main solution = new Main();

        int[] people = {70, 50, 80, 50};
        int limit = 100;

        int result = solution.solution(people, limit);
        System.out.println(result);
    }
}
