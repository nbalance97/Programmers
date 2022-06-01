import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {

    private static final char BLANK = ' ';

    private boolean check(int m, int n, char[][] board) {
        char base = board[m][n];
        for (int i = m; i < m+2; i++) {
            for (int j = n; j < n+2; j++) {
                if (board[i][j] != base) {
                    return false;
                }
            }
        }
        return true;
    }

    private int destroy(int m, int n, char[][] board) {
        int destroyCount = 0;
        for (int i = m; i < m+2; i++) {
            for (int j = n; j < n+2; j++) {
                if (board[i][j] != BLANK) {
                    destroyCount++;
                }
                board[i][j] = BLANK;
            }
        }

        return destroyCount;
    }

    private void tuning(char[][] board) {
        for (int i = board.length-1; i >= 0; i--) {
            for (int j = 0; j < board.length; j++) {
                for (int k = i+1; k < board.length; k++) {
                    if (board[k][j] == BLANK) {
                        board[k][j] = board[k-1][j];
                        board[k-1][j] = BLANK;
                        continue;
                    }
                    break;
                }
            }
        }
    }

    public int solution(int m, int n, String[] board) {

        int answer = 0;

        List<char[]> temp = Arrays.stream(board)
                .map(String::toCharArray)
                .collect(Collectors.toList());
        char[][] convertBoard = temp.toArray(s -> new char[0][]);

        while (true) {
            List<int[]> candidates = getCandidate(convertBoard);

            if (candidates.size() == 0) {
                break;
            }

            for (int[] candidate : candidates) {
                answer += destroy(candidate[0], candidate[1], convertBoard);
            }
            
            tuning(convertBoard);
        }

        return answer;

    }

    private List<int[]> getCandidate(char[][] board) {
        List<int[]> candidates = new ArrayList<>();
        for (int i = 0; i < board.length - 1; i++) {
            for (int j = 0; j < board[0].length - 1; j++) {
                if (board[i][j] == BLANK) {
                    continue;
                }
                if (check(i, j, board)) {
                    candidates.add(new int[]{i, j});
                }
            }
        }
        return candidates;
    }
}
