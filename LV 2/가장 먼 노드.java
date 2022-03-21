import java.util.*;

class Node implements Comparable<Node>{

    int node;
    int distance;

    public Node(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.node, ((Node)o).node);
    }
}

class Solution {

    public static final int DISTANCE_MAX = 1000000;

    public int[] dijkstra(int n, Map<Integer, Set<Integer>> connection) {
        int[] distance = new int[n+1];
        Arrays.fill(distance, DISTANCE_MAX);
        PriorityQueue<Node> heap = new PriorityQueue<Node>();
        distance[1] = 0;
        heap.add(new Node(1, 0));

        while (!heap.isEmpty()) {
            Node currentNode = heap.poll();
            if (distance[currentNode.node] != currentNode.distance) {
                continue;
            }

            for (int nextNode : connection.get(currentNode.node)) {
                pushIfSatisfied(distance, heap, currentNode, nextNode);
            }
        }

        return distance;
    }

    private void pushIfSatisfied(int[] distance, PriorityQueue<Node> heap, Node currentNode, int nextNode) {
        if (distance[nextNode] > distance[currentNode.node] + 1) {
            distance[nextNode] = distance[currentNode.node] + 1;
            heap.offer(new Node(nextNode, distance[nextNode]));
        }
    }

    public int solution(int n, int[][] edge) {
        
        Map<Integer, Set<Integer>> connection = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            connection.put(i, new HashSet<>());
        }

        for (int i = 0; i < edge.length; i++) {
            connection.get(edge[i][0]).add(edge[i][1]);
            connection.get(edge[i][1]).add(edge[i][0]);
        }

        int[] distance = dijkstra(n, connection);
        int maxValue = Arrays.stream(distance)
                .filter(value -> value != DISTANCE_MAX)
                .max()
                .getAsInt();

        return (int) Arrays.stream(distance)
                .filter(value -> value == maxValue)
                .count();
    }
}
