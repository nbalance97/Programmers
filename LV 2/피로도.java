import java.util.ArrayList;
import java.util.List;

class Solution {
    boolean[] visited = new boolean[9];
    List<String> sequences = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public void makeSequences(int order, int maxLength) {
        if (order == maxLength) {
            sequences.add(sb.toString());
            return;
        }

        for (int i = 0; i < maxLength; i++) {
            if (!visited[i]) {
                sb.append(i);
                visited[i] = true;
                makeSequences(order+1, maxLength);
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }
        }

    }

    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        makeSequences(0, dungeons.length);
        for (String sequence : sequences) {
            int dungeonCount = getDungeonCount(k, dungeons, sequence);
            answer = Math.max(answer, dungeonCount);
        }
        return answer;
    }

    private int getDungeonCount(int k, int[][] dungeons, String sequence) {
        int dungeonCount = 0;
        int currentBored = k;
        for (char ch : sequence.toCharArray()) {
            int number = Character.digit(ch, 10);
            if (dungeons[number][0] > currentBored) {
                break;
            }
            currentBored -= dungeons[number][1];
            dungeonCount += 1;
        }
        return dungeonCount;
    }

}
