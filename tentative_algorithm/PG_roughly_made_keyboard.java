import java.util.HashMap;
import java.util.Map;

class Main {
    public int[] solution(String[] keymap, String[] targets) {
        // 각 문자의 최소 입력 횟수를 저장하는 맵
        Map<Character, Integer> charPressCount = new HashMap<>();

        // keymap을 순회하여 문자와 해당 문자에 대한 최소 입력 횟수를 계산
        for (String keys : keymap) {
            for (int i = 0; i < keys.length(); i++) {
                char ch = keys.charAt(i);
                // 해당 문자의 최소 클릭 수를 업데이트
                charPressCount.put(ch, Math.min(charPressCount.getOrDefault(ch, Integer.MAX_VALUE), i + 1));
            }
        }

        // 결과 배열 초기화
        int[] result = new int[targets.length];

        // targets를 순회하여 각 문자열의 입력 횟수를 계산
        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int totalPresses = 0;
            boolean canConstruct = true;

            for (char ch : target.toCharArray()) {
                if (charPressCount.containsKey(ch)) {
                    totalPresses += charPressCount.get(ch);
                } else {
                    // 해당 문자를 입력할 수 없는 경우
                    canConstruct = false;
                    break;
                }
            }

            // 결과 배열에 값을 저장
            result[i] = canConstruct ? totalPresses : -1;
        }

        return result;
    }

    public static void main(String[] args) {
        Main solution = new Main();

        // 테스트 케이스
        String[] keymap1 = {"ABACD", "BCEFD"};
        String[] targets1 = {"ABCD", "AABB"};
        int[] result1 = solution.solution(keymap1, targets1);
        System.out.println(java.util.Arrays.toString(result1)); // [9, 4]

        String[] keymap2 = {"AA"};
        String[] targets2 = {"B"};
        int[] result2 = solution.solution(keymap2, targets2);
        System.out.println(java.util.Arrays.toString(result2)); // [-1]

        String[] keymap3 = {"AGZ", "BSSS"};
        String[] targets3 = {"ASA", "BGZ"};
        int[] result3 = solution.solution(keymap3, targets3);
        System.out.println(java.util.Arrays.toString(result3)); // [4, 6]
    }
}
