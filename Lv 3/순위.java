import java.util.*;


class Solution {

    public int bfs(List<Set<Integer>> graph, int start) {
        boolean[] visited = new boolean[graph.size()];
        int count = 1;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : graph.get(current)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    count++;
                }
            }
        }

        return count;
    }

    public int solution(int n, int[][] results) {
        int answer = 0;
        List<Set<Integer>> winGraph = new ArrayList<>();
        List<Set<Integer>> loseGraph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            winGraph.add(new HashSet<>());
            loseGraph.add(new HashSet<>());
        }

        for (int[] result : results) {
            winGraph.get(result[0]).add(result[1]);
            loseGraph.get(result[1]).add(result[0]);
        }

        for (int i = 1; i <= n; i++) {
            int count = bfs(loseGraph, i) + bfs(winGraph, i);
            if (count == n+1) {
                answer += 1;
            }
        }

        return answer;
    }
}
