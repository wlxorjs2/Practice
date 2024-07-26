import java.util.Arrays;

public class Main {
    public static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i].length() <= phone_book[i + 1].length() &&
                    phone_book[i].equals(phone_book[i + 1].substring(0, phone_book[i].length()))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"119", "97674223", "1195524421"}));
        System.out.println(solution(new String[]{"123", "456", "789"}));
        System.out.println(solution(new String[]{"12", "123", "1235", "567", "88"}));
        System.out.println(solution(new String[]{"1234", "123", "12"}));
        System.out.println(solution(new String[]{"1", "2", "3"}));
        System.out.println(solution(new String[]{""}));
    }
}