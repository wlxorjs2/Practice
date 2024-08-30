import java.util.*;

public class Main {
    public static int solution(int[] picks, String[] minerals) {
        int[][] fatigue = {
                {1, 1, 1},
                {5, 1, 1},
                {25, 5, 1}
        };

        List<Integer> totalFatigue = new ArrayList<>();

        // 광물 5개씩 그룹으로 나누기
        for (int i = 0; i < minerals.length; i += 5) {
            int diamondCount = 0, ironCount = 0, stoneCount = 0;
            for (int j = i; j < Math.min(i + 5, minerals.length); j++) {
                if (minerals[j].equals("diamond")) diamondCount++;
                else if (minerals[j].equals("iron")) ironCount++;
                else if (minerals[j].equals("stone")) stoneCount++;
            }
            totalFatigue.add(diamondCount);
            totalFatigue.add(ironCount);
            totalFatigue.add(stoneCount);
        }

        // 곡괭이 사용 가능한 조합으로 최소 피로도 계산
        int minFatigue = Integer.MAX_VALUE;
        int[] pickCounts = new int[3];
        System.arraycopy(picks, 0, pickCounts, 0, picks.length);

        minFatigue = dfs(pickCounts, totalFatigue, 0, 0, minFatigue, fatigue);

        return minFatigue;
    }

    private static int dfs(int[] picks, List<Integer> totalFatigue, int index, int currentFatigue, int minFatigue, int[][] fatigue) {
        if (index >= totalFatigue.size() || (picks[0] == 0 && picks[1] == 0 && picks[2] == 0)) {
            return Math.min(minFatigue, currentFatigue);
        }

        for (int i = 0; i < 3; i++) {
            if (picks[i] > 0) {
                int[] newPicks = Arrays.copyOf(picks, picks.length);
                newPicks[i]--;

                int newFatigue = currentFatigue;
                if (index < totalFatigue.size()) {
                    newFatigue += totalFatigue.get(index) * fatigue[i][0] +
                            totalFatigue.get(index + 1) * fatigue[i][1] +
                            totalFatigue.get(index + 2) * fatigue[i][2];
                }

                minFatigue = dfs(newPicks, totalFatigue, index + 3, newFatigue, minFatigue, fatigue);
            }
        }

        return minFatigue;
    }

    public static void main(String[] args) {
        int[] picks1 = {1, 3, 2};
        String[] minerals1 = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
        System.out.println(solution(picks1, minerals1)); // 12

        int[] picks2 = {0, 1, 1};
        String[] minerals2 = {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"};
        System.out.println(solution(picks2, minerals2)); // 50
    }
}
