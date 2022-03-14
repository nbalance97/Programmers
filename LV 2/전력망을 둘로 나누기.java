class Solution {

    public void union(int[] parent, int node1, int node2) {
        int parent1 = find(parent, node1);
        int parent2 = find(parent, node2);

        if (parent1 != parent2) {
            parent[parent1] = parent2;
        }
    }

    public int find(int[] parent, int node) {
        if (parent[node] != node) {
            parent[node] = find(parent, parent[node]);
        }
        return parent[node];
    }

    public int solution(int n, int[][] wires) {
        int answer = n;
        for (int skipWireIndex = 0; skipWireIndex < wires.length; skipWireIndex++) {
            answer = Integer.min(answer, getDifference(wires, n, skipWireIndex));
        }
        return answer;
    }

    private int getDifference(int[][] wires, int n, int skipWireIndex) {
        int[] parent = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < wires.length; i++) {
            if (i == skipWireIndex) {
                continue;
            }
            if (find(parent, wires[i][0]) != find(parent, wires[i][1])) {
                union(parent, wires[i][0], wires[i][1]);
            }
        }

        int[] count = new int[2];
        int town = find(parent, 1);
        for (int i = 1; i < n+1; i++) {
            if (find(parent, i) == town) {
                count[0] += 1;
                continue;
            }
            count[1] += 1;
        }

        return Math.abs(count[1] - count[0]);
    }
}
