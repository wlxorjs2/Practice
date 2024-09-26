import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] dwarf = inputDwarf();
        int sum = heightSum(dwarf);
        findLiar(dwarf, sum);
    }

    private static int[] inputDwarf() {
        Scanner sc = new Scanner(System.in);
        int[] dwarf = new int[9];
        for (int i = 0; i < dwarf.length; i++) {
            dwarf[i] = sc.nextInt();
        }
        return dwarf;
    }

    private static int heightSum(int[] dwarf) {
        int sum = 0;
        for (int height : dwarf) {
            sum += height;
        }
        return sum;
    }

    private static void findLiar(int[] dwarf, int sum) {
        Arrays.sort(dwarf);
        int L1 = 0, L2 = dwarf.length - 1;
        while (L1 < L2) {
            int target = dwarf[L1] + dwarf[L2];
            if (target == sum - 100) {
                printResult(dwarf, L1, L2);
                return;
            } else if (target < sum - 100) {
                L1++;
            } else {
                L2--;
            }
        }
    }

    private static void printResult(int[] dwarf, int Liar1, int Liar2) {
        for (int i = 0; i < dwarf.length; i++) {
            if (i != Liar1 && i != Liar2) {
                System.out.println(dwarf[i]);
            }
        }
    }
}
