import java.util.HashMap;

public class Main {
    private HashMap<String, Integer> wordMap;

    public Main(String[] words) {
        wordMap = new HashMap<>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            String word = words[i];
            for (int j = 0; j <= word.length(); j++) {
                for (int k = 0; k <= word.length(); k++) {
                    String prefix = word.substring(0, j);
                    String suffix = word.substring(word.length() - k);
                    wordMap.put(prefix + "#" + suffix, i);
                }
            }
        }
    }
    public int f(String pref, String suff) {
        return wordMap.getOrDefault(pref + "#" + suff, -1);
    }
    public static void main(String[] args) {
        Main wordFilter = new Main(new String[]{"apple"});
        System.out.println(wordFilter.f("a", "e"));
        System.out.println(wordFilter.f("a", "x"));
        System.out.println(wordFilter.f("b", "e"));
        System.out.println(wordFilter.f("app", "le"));
    }
}
