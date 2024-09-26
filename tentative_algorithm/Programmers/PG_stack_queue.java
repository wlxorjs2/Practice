import java.util.ArrayList;
import java.util.List;

public class Main {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int n = progresses.length;

        int Maxdays = 0;
        int count = 1;
        for(int i = 0; i < n; i++) {
            int SuccessDays = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            if(i == 0) {
                Maxdays = SuccessDays;
            }
            else if(SuccessDays <= Maxdays) {
                count++;
            } else {
                answer.add(count);
                Maxdays = SuccessDays;
                count = 1;
            }
        }
        answer.add(count);
        return answer;
    }

    public static void main(String[] args) {
        Main sol = new Main();

        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        System.out.println(sol.solution(progresses,speeds));
    }
}