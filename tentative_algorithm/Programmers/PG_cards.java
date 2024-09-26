public class Main {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int i = 0, j = 0;
        for (String word : goal) {
            if (i < cards1.length && cards1[i].equals(word)) {
                i++;
            }
            else if (j < cards2.length && cards2[j].equals(word)) {
                j++;
            }
            else {
                return "No";
            }
        }
        return "Yes";
    }
    public static void main(String[] args) {
        Main sol = new Main();
        System.out.println(sol.solution(new String[]{"i", "drink", "water"}, new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"})); // "Yes"
        System.out.println(sol.solution(new String[]{"i", "drink"}, new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"})); // "No"
    }
}