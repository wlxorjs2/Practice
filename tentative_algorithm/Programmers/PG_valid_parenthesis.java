import java.util.Stack;

public class Main {

    public static int solution(String s) {
        int validCount = 0;
        int n = s.length();

        // 문자열을 n번 회전하면서 올바른 괄호 문자열인지 확인
        for (int i = 0; i < n; i++) {
            if (isValidParenthesis(s)) {
                validCount++;
            }
            // 문자열을 왼쪽으로 1칸 회전
            s = s.substring(1) + s.charAt(0);
        }
        return validCount;
    }

    private static boolean isValidParenthesis(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c); // 여는 괄호는 스택에 추가
            } else {
                if (stack.isEmpty()) {
                    return false; // 닫는 괄호가 먼저 나오면 잘못된 문자열
                }
                char top = stack.pop();
                // 여는 괄호와 닫는 괄호가 일치하는지 확인
                if ((c == ')' && top != '(') ||
                        (c == ']' && top != '[') ||
                        (c == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty(); // 모든 여는 괄호가 짝이 맞으면 스택이 비어있어야 함
    }
    public static void main(String[] args) {
        String s1 = "[](){}";
        String s2 = "}]()[{";
        String s3 = "[)(]";
        String s4 = "}}}";
        System.out.println(solution(s1)); // 3
        System.out.println(solution(s2)); // 2
        System.out.println(solution(s3)); // 0
        System.out.println(solution(s4)); // 0
    }
}
