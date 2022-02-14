import java.util.stream.IntStream;

class Solution {

    private static final int MAX_VALUE = Integer.MAX_VALUE / 2;

    public int solution(int N, int[][] road, int K) {
        int[][] distanceMatrix = new int[N+1][N+1];
        
        fillValue(distanceMatrix, MAX_VALUE);
        fillRoadDataToMatrix(road, distanceMatrix);
        initializeMatrix(N, distanceMatrix);
        floyd(distanceMatrix);

        return (int) IntStream.range(1, N+1)
                .filter(i -> distanceMatrix[1][i] <= K)
                .count();
    }

    private void initializeMatrix(int N, int[][] distanceMatrix) {
        for (int i = 1; i < N +1; i++) {
            distanceMatrix[i][i] = 0;
        }
    }

    private void fillValue(int[][] distanceMatrix, int value) {
        for (int i = 0; i < distanceMatrix.length; i++) {
            for (int j = 0; j < distanceMatrix[0].length; j++) {
                distanceMatrix[i][j] = value;
            }
        }
    }

    private void floyd(int[][] distanceMatrix) {
        int maxLength = distanceMatrix.length;
        
        for (int i = 1; i < maxLength; i++) {
            for (int j = 1; j < maxLength; j++) {
                for (int k = 1; k < maxLength; k++) {
                    distanceMatrix[j][k] = Math.min(
                            distanceMatrix[j][k],
                            distanceMatrix[j][i] + distanceMatrix[i][k]
                    );
                }
            }
        }
    }

    private void fillRoadDataToMatrix(int[][] road, int[][] distanceMatrix) {
        for (int[] roadData : road) {
            distanceMatrix[roadData[0]][roadData[1]] = Math.min(
                    distanceMatrix[roadData[0]][roadData[1]],
                    roadData[2]
            );
            distanceMatrix[roadData[1]][roadData[0]] = distanceMatrix[roadData[0]][roadData[1]];
        }
    }
}
