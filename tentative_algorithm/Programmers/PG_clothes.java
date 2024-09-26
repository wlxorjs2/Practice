import java.util.HashMap;
import java.util.Map;

public class Main {
    public static int solution(String[][] clothes) {
        Map<String, Integer> clothesMap = new HashMap<>();

        // 각 의상 종류별 개수 세기
        for (String[] clothe : clothes) {
            String type = clothe[1];
            clothesMap.put(type, clothesMap.getOrDefault(type, 0) + 1);
        }

        int answer = 1;
        // 각 의상 종류별 개수에 1을 더한 뒤 곱셈 수행
        for (int count : clothesMap.values()) {
            answer *= (count + 1);
        }

        // 아무것도 입지 않는 경우를 빼기
        return answer - 1;
    }

    public static void main(String[] args) {
        String[][] clothes1 = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] clothes2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};

        System.out.println(solution(clothes1)); // 5
        System.out.println(solution(clothes2)); // 3
    }
}
