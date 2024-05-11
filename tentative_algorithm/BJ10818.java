import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        System.out.println(arr[0]+" "+arr[arr.length-1]);
    }
}
//Arrays.sort : 배열 오름차순 정렬
//그리고 배열의 0번째 인덱스와 마지막 인덱스를 추출
//BJ10818