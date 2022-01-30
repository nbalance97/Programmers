import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] makeArray(int rows, int columns) {
        int[][] arr = new int[rows][columns];
        int idx = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = idx++;
            }
        }

        return arr;
    }

    public int movement(int[][] arr, int[] query) {
        int startRow = query[0] - 1, startCol = query[1] - 1;
        int finishRow = query[2] - 1, finishCol = query[3] - 1;

        int lastValue = arr[startRow][startCol];
        int minValue = 10005;
        // 왼쪽
        for (int i = startRow; i < finishRow; i++) {
            arr[i][startCol] = arr[i+1][startCol];
            minValue = Math.min(minValue, arr[i][startCol]);
        }

        // 아래
        for (int i = startCol; i < finishCol; i++) {
            arr[finishRow][i] = arr[finishRow][i+1];
            minValue = Math.min(minValue, arr[finishRow][i]);
        }

        // 오른쪽
        for (int i = finishRow; i > startRow; i--) {
            arr[i][finishCol] = arr[i-1][finishCol];
            minValue = Math.min(minValue, arr[i][finishCol]);
        }

        // 위
        for (int i = finishCol; i > startCol; i--) {
            arr[startRow][i] = arr[startRow][i-1];
            minValue = Math.min(minValue, arr[startRow][i-1]);
        }
        
        arr[startRow][startCol+1] = lastValue;
        return Math.min(minValue, lastValue);
    }

    public int[] solution(int rows, int columns, int[][] queries) {
        List<Integer> list = new ArrayList<>();
        int[][] arr = makeArray(rows, columns);
        for (int[] query : queries) {
            int minValue = movement(arr, query);
            list.add(minValue);
        }
        return list.stream().mapToInt(i->i).toArray();
    }
}
