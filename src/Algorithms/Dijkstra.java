package Algorithms;

import java.util.*;
import Graph.Graph;

// Custom Pair Class for Priority Queue
class Pair {
    int distance;
    int node;

    Pair(int distance, int node) {
        this.distance = distance;
        this.node = node;
    }
}

public class Dijkstra {

    public static int[] dijkstra(Graph graph, int start, boolean print) {
        int v = graph.getMatrix().length;
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.distance));
        int[] dist = new int[v];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.offer(new Pair(0, start));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int node = p.node;
            int distance = p.distance;

            // Process Neighbors
            for (Map.Entry<Integer, Integer> neighbor : graph.getList().get(node).entrySet()) {
                int adjNode = neighbor.getKey();
                int weight = neighbor.getValue();
                int newDist = distance + weight;

                if (newDist < dist[adjNode]) {
                    dist[adjNode] = newDist;
                    pq.offer(new Pair(newDist, adjNode));
                }
            }
        }

        if (print) {
            System.out.println("Shortest distances from node " + start + ": " + Arrays.toString(dist));
        }

        return dist;
    }

    public static int[] dijkstra(Graph graph, int start) {
        return dijkstra(graph, start, false);
    }
}
