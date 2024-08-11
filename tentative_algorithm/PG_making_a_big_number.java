public class Main {
    public String solution(String number, int k) {
        StringBuilder result = new StringBuilder();
        int len = number.length();
        int toRemove = k; // 제거할 숫자의 개수

        for (int i = 0; i < len; i++) {
            char current = number.charAt(i);
            while (toRemove > 0 && result.length() > 0 && result.charAt(result.length() - 1) < current) {
                result.deleteCharAt(result.length() - 1);
                toRemove--;
            }
            result.append(current);
        }

        if (toRemove > 0) {
            result.delete(result.length() - toRemove, result.length());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Main solution = new Main();

        System.out.println(solution.solution("1924", 2));
        System.out.println(solution.solution("1231234", 3));
        System.out.println(solution.solution("4177252841", 4));
    }
}
