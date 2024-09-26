class Main {
    int cnt[] = {0, 1, 2, 3, 4, 5, 4, 3, 2, 1};
    int answer = Integer.MAX_VALUE;
    public int solution(int cur) {
        helper(cur, 0);
        return answer;
    }

    public void helper(int cur, int currentClicks) {
        // 종료 조건: 현재 숫자가 10 미만일 때
        if (cur < 10) {
            int extraClick = cur > 5 ? 1 : 0; // 5보다 크면 +1 클릭
            answer = Math.min(cnt[cur] + extraClick + currentClicks, answer); // 최소 클릭 수 업데이트
            return;
        }

        // 마지막 자리 수가 5 이하인 경우
        if (cur % 10 <= 5) {
            helper(cur / 10, cnt[cur % 10] + currentClicks);
        }

        // 마지막 자리 수가 5 이상인 경우
        if (cur % 10 >= 5) {
            helper(cur / 10 + 1, cnt[cur % 10] + currentClicks);
        }
    }

    public static void main(String[] args) {
        Main solution = new Main();
        System.out.println(solution.solution(5554));
        System.out.println(solution.solution(6));
        System.out.println(solution.solution(10));
        System.out.println(solution.solution(20));
        System.out.println(solution.solution(99999999));
        System.out.println(solution.solution(0));
        System.out.println(solution.solution(5));
        System.out.println(solution.solution(45));
    }
}
