import java.util.*;
import java.io.*;
public class Main {
    static StringBuilder sb = new StringBuilder();
    static String intro = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.";
    static String question = "\"재귀함수가 뭔가요?\"";
    static String repeat1 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n";
    static String repeat2 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n";
    static String repeat3 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
    static String answer = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
    static String end = "라고 답변하였지.";
    static int hope = 0;
    static void sol(int num) {
        StringBuilder hyphen = new StringBuilder();
        for(int i = 0; i < num; i++)
            hyphen.append("____");
        sb.append(hyphen).append(question).append("\n");
        if(num == hope) {
            sb.append(hyphen).append(answer).append("\n");
        } else {
            sb.append(hyphen).append(repeat1);
            sb.append(hyphen).append(repeat2);
            sb.append(hyphen).append(repeat3).append("\n");
            sol(++num);
        }
        sb.append(hyphen).append(end).append("\n");
        return;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        hope = Integer.parseInt(st.nextToken());

        sb.append(intro).append("\n");
        sb.append(question).append("\n");
        sb.append(repeat1).append(repeat2).append(repeat3).append("\n");
        sol(1);
        sb.append(end);
        System.out.println(sb);
    }
}