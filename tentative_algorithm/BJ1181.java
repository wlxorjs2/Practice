import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        sc.nextLine();
        for(int i = 0; i < arr.length; i++) {
            String word = sc.nextLine();
            arr[i] = word;
        }
        String[] result = Arrays.stream(arr).distinct().toArray(String[]::new);
        Arrays.sort(result);
        Arrays.sort(result, Comparator.comparingInt(String::length));
        for(int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}