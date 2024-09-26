import java.util.ArrayList;
import java.util.List;

public class Main {
    List<String> combinations = new ArrayList<>();

    public int solution(String word) {
        char[] vowels = {'A', 'E', 'I', 'O', 'U'};
        generateCombinations("", vowels, 0);

        // 사전 순으로 정렬된 combinations 리스트에서 word의 인덱스를 찾음
        for (int i = 0; i < combinations.size(); i++) {
            if (combinations.get(i).equals(word)) {
                return i + 1; // 1부터 시작하므로 1을 더함
            }
        }

        return 0; // 단어가 존재하지 않는 경우
    }

    private void generateCombinations(String current, char[] vowels, int depth) {
        // 최대 길이 5까지 조합을 생성
        if (depth > 5) return;

        if (!current.isEmpty()) {
            combinations.add(current); // 현재 조합을 리스트에 추가
        }

        // 재귀적으로 조합 생성
        for (char vowel : vowels) {
            generateCombinations(current + vowel, vowels, depth + 1);
        }
    }
    public static void main(String[] args) {
        Main sol = new Main();
        System.out.println(sol.solution("AAAAE"));
        System.out.println(sol.solution("AAAE"));
        System.out.println(sol.solution("I"));
        System.out.println(sol.solution("EIO"));
    }
}
