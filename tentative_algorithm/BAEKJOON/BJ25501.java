import java.util.Scanner;

public class Main{
    static Scanner sc = new Scanner(System.in);
    static int sum = 0;
    static String S = "";

    public static int recursion(String s, int l, int r){
        sum ++ ;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }
    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }
    public static void main(String[] args){
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            S = sc.next();
            System.out.print(isPalindrome(S));
            System.out.println(" "+sum);
            sum = 0;
        }
    }
}