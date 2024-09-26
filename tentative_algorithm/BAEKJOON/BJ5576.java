import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] W = new int[10];
        int[] K = new int[10];
        for (int i = 0; i < W.length; i++) {
            W[i] = sc.nextInt();
        }
        for (int i = 0; i < K.length; i++) {
            K[i] = sc.nextInt();
        }
        Arrays.sort(W);
        Arrays.sort(K);
        int wSum = W[W.length - 1] + W[W.length - 2] + W[W.length - 3];
        int kSum = K[K.length - 1] + K[K.length - 2] + K[K.length - 3];
        System.out.println(wSum+" "+kSum);
    }
}
//Arrays.sort : 배열 오름차순 정렬
//그리고 배열의 마지막 인덱스로 부터 3개의 값을 추출
//BJ5576