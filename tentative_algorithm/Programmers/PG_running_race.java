import java.util.HashMap;

public class Main {
    public static String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> playerIndexMap = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            playerIndexMap.put(players[i], i);
        }
        // 추월 처리
        for (String calling : callings) {
            int currentIndex = playerIndexMap.get(calling);
            int newIndex = currentIndex - 1; // 한 칸 위로 이동
            if (newIndex >= 0) {
                String playerAbove = players[newIndex]; // 추월당하는 선수
                // 현재 선수와 추월당하는 선수의 인덱스 업데이트
                players[currentIndex] = playerAbove;
                players[newIndex] = calling;

                // 인덱스 맵도 업데이트
                playerIndexMap.put(calling, newIndex);
                playerIndexMap.put(playerAbove, currentIndex);
            }
        }
        return players;
    }
    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        String[] result = solution(players, callings);
        for (String player : result) {
            System.out.print(player + " ");
        }
    }
}
