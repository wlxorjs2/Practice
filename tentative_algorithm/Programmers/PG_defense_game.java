import java.util.*;

class Main {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for(int i = 0; i<enemy.length;i++){
            if(k>0){
                que.add(enemy[i]);
                k--;
            }else{
                int num = enemy[i];
                if(que.peek() < enemy[i]){
                    num = que.poll();
                    que.add(enemy[i]);
                }
                if(n>=num){
                    n-=num;
                }else break;

            }
            answer++;
        }
        return answer;
    }
}