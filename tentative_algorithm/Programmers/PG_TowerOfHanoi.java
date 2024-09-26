import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<List<Integer>> solution(int n) {
        List<List<Integer>> moves = new ArrayList<>();

        // n개의 원판을 1번 기둥에서 3번 기둥으로 옮기는 로직
        hanoi(n, 1, 3, 2, moves);

        return moves;
    }

    private static void hanoi(int n, int from, int to, int aux, List<List<Integer>> moves) {
        if (n == 1) {
            List<Integer> move = new ArrayList<>();
            move.add(from);
            move.add(to);
            moves.add(move); // 원판을 옮기는 이동 기록
        } else {
            hanoi(n - 1, from, aux, to, moves); // n-1개의 원판을 보조 기둥으로 이동
            List<Integer> move = new ArrayList<>();
            move.add(from);
            move.add(to);
            moves.add(move); // 가장 큰 원판을 목적 기둥으로 이동
            hanoi(n - 1, aux, to, from, moves); // 보조 기둥에서 목적 기둥으로 이동
        }
    }

    public static void main(String[] args) {
        // 테스트용 코드
        List<List<Integer>> result = solution(2); // 원판 개수 2개
        System.out.println(result); // 각 이동을 출력
    }
}
