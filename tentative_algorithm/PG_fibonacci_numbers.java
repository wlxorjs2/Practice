public class Main {
    public int solution(int n) {
        int MOD = 1234567; // 나머지로 사용할 값
        int[] fib = new int[n + 1]; // 피보나치 수를 저장할 배열

        // 초기값 설정
        fib[0] = 0;
        fib[1] = 1;

        // 피보나치 수 계산
        for (int i = 2; i <= n; i++) {
            fib[i] = (fib[i - 1] + fib[i - 2]) % MOD; // 모듈러 연산을 사용하여 계산
        }

        return fib[n]; // n번째 피보나치 수 반환
    }

    public static void main(String[] args) {
        Main solution = new Main();

        System.out.println(solution.solution(3)); // 출력: 2
        System.out.println(solution.solution(5)); // 출력: 5
        System.out.println(solution.solution(10)); // 출력: 55
        System.out.println(solution.solution(100000)); // 더 큰 값 테스트
    }
}
