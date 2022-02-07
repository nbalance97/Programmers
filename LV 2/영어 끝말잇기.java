import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        int turn = 0;
        int sequence = 0;
        String lastWord = "";
        Set<String> alreadySaidWords = new HashSet<>();

        for (String word : words) {
            if (turn == 0) {
                sequence += 1;
            }

            if (lastWord.length() != 0 && (alreadySaidWords.contains(word)
                    || word.charAt(0) != lastWord.charAt(lastWord.length()-1)
                    || word.length() == 1)) {
                answer[0] = turn + 1;
                answer[1] = sequence;
                break;
            }

            lastWord = word;
            alreadySaidWords.add(word);
            turn = (turn + 1) % n;
        }

        return answer;
    }
}
