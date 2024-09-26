import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        System.out.println(a.nextLong()+a.nextLong()+a.nextLong());
    }
}
// 런타임 에러 :
// 문제 10의12승까지 저장할 수 있어야 하므로 정수형 long형으로 작성
//BJ11382