import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class Main {
    public static void main(String[] args) {
        int[] student = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};
        int[] none = new int[student.length];
        Set<Integer> dup = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 28; i++) {
            int a = sc.nextInt();
            if (!dup.contains(a)) {
                none[a-1] = a;
                //ex : 1-1=0 번째 인덱스에 1 저장
                //ex : 30-1=29 번째 인덱스에 30 저장 (인덱스는 0~29까지 총 30)
                dup.add(a);
            }
        }
        for (int i = 0; i < student.length; i++) {
            if (student[i] != none[i]) {
                System.out.println(student[i]); //비교하여 없는 값 출력
            }
        }
    }
}
//HashSet : 중복을 허용하지 않는 자바 클래스
//Arrays.equals : 두 배열을 비교하여 내용이 동일한지 확인하는 메서드
//배열의 인덱스는 0부터 시작하므로, a에서 1을 빼주어 맞춰줌
//BJ5597