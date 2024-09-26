class Solution {
    public static String solution(String s) {
    String[] words = s.split(" ");
    StringBuilder result = new StringBuilder();
    
    for (int i = 0; i < words.length; i++) {
        String word = words[i];
        if(word.length() > 0) {
            String jadenCase = word.substring(0,1).toUpperCase() + word.substring(1).toLowerCase();
            result.append(jadenCase);
        }
        if(i < words.length - 1) {
            result.append(" ");
        }
    }
    if (s.endsWith(" ")) {
        result.append(" ");
    }
    return result.toString();
    }
    public static void main(String[] args) {
        System.out.println(solution("3people unFollowed me")); 
        System.out.println(solution("for the last week"));  
        System.out.println(solution(" a b c "));        
    }
}