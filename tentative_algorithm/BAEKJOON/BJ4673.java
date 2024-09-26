public class Main {
    public static void main(String[] args) {
        boolean[] isSelfNumber = new boolean[10001]; // 1부터 10000까지의 boolean 배열 생성

        for (int i = 1; i <= 10000; i++) {
            int selfNumber = getSelfNumber(i);
            if (selfNumber <= 10000) {
                isSelfNumber[selfNumber] = true;
            }
        }

        for (int i = 1; i <= 10000; i++) {
            if (!isSelfNumber[i]) {
                System.out.println(i);
            }
        }
    }

    public static int getSelfNumber(int number) {
        int selfNumber = number;
        while (number > 0) {
            selfNumber += number % 10;
            number /= 10;
        }
        return selfNumber;
    }
}