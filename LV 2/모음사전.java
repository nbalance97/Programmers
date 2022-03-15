import java.util.*;

class Solution {

    private StringBuilder sb = new StringBuilder();
    private String[] words = {"", "A", "E", "I", "O", "U"};
    private Set<String> madeWords = new HashSet<>();

    private void calculateAllCase(int step) {
        if (step == 6) {
            madeWords.add(sb.toString());
            return;
        }

        for (String word : words) {
            sb.append(word);
            calculateAllCase(step + 1);
            if (word == "") {
                continue;
            }
            sb.delete(sb.length()-1, sb.length());
        }
    }

    public int solution(String word) {
        int answer = 0;
        calculateAllCase(1);
        List<String> list = new ArrayList<>(madeWords);
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(word)) {
                return i;
            }
        }
        return -1;
    }
}
