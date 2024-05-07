import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char a = sc.next().charAt(0);
        int b = a;
        System.out.println(b);
    }
}
// charAt()으로 한글자만 가져오기, toCharArray()로 모든 글자 char배열에 넣기
// 아스키 코드 변환 방법 : char의 글자를 int 형으로 반환
//BJ11654