import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] num1 = new int[t];
        int[] num2 = new int[t];
        for (int i = 0; i < t; i++) {
            num1[i] = sc.nextInt();
            num2[i] = sc.nextInt();
            System.out.println(num1[i] + num2[i]);
        }
    }
}
// ArrayIndexOutOfBoundsException 에러 :
// num1, num2의 배열크기가 반복하는 t와 같아야 오류가 안생김
//BJ10950