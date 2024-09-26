import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] s = sc.next().toCharArray();
        int n = sc.nextInt();
        System.out.println(s[n-1]);
    }
}
// 배열은 0부터 시작하므로 n-1을 해야 사람이 보기에 입력한 순서의 글자가 출력
//BJ27866