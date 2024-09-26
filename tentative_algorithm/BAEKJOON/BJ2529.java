import java.util.*;

public class Main {
    static int k;
    static char[] inequalities;
    static List<String> validNumbers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 부등호 개수 입력
        k = scanner.nextInt();
        inequalities = new char[k];

        // 부등호 기호 입력
        for (int i = 0; i < k; i++) {
            inequalities[i] = scanner.next().charAt(0);
        }

        // 가능한 숫자 조합 생성
        boolean[] visited = new boolean[10];
        generateNumbers("", visited);

        // 최대값과 최소값 찾기
        String maxNumber = Collections.max(validNumbers);
        String minNumber = Collections.min(validNumbers);

        // 결과 출력
        System.out.println(maxNumber);
        System.out.println(minNumber);
    }

    private static void generateNumbers(String current, boolean[] visited) {
        if (current.length() == k + 1) {
            if (isValid(current)) {
                validNumbers.add(current);
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!visited[i]) {
                visited[i] = true;
                generateNumbers(current + i, visited);
                visited[i] = false;
            }
        }
    }

    private static boolean isValid(String number) {
        for (int i = 0; i < k; i++) {
            if (inequalities[i] == '<' && number.charAt(i) >= number.charAt(i + 1)) {
                return false;
            }
            if (inequalities[i] == '>' && number.charAt(i) <= number.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
