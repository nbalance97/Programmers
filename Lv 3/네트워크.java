import java.util.Arrays;

class Solution {

    public void union(int[] parent, int p1, int p2) {
        int parent1 = find(parent, p1);
        int parent2 = find(parent, p2);

        parent[parent1] = parent2;
    }

    public int find(int[] parent, int idx) {
        if (parent[idx] != idx) {
            parent[idx] = find(parent, parent[idx]);
        }

        return parent[idx];
    }

    public int solution(int n, int[][] computers) {
        int[] parent = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (computers[i][j] == 1) {
                    union(parent, i, j);
                }
            }
        }

        int answer = (int) Arrays.stream(parent)
                .map(i -> find(parent, i))
                .distinct()
                .count();

        return answer;
    }
}
