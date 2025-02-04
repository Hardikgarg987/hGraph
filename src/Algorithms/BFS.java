package Algorithms;

import Graph.Graph;
import java.util.*;

public class BFS {
    public static void printBFS(Graph graph, int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.getMatrix().length];

        queue.offer(start);
        visited[start] = true;

        System.out.println("BFS Traversal:");
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int neighbor : graph.getList().get(node).keySet()) {
                if (!visited[neighbor]) {
                    queue.offer(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
        System.out.println();
    }
    public static List getBFS(Graph graph, int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.getMatrix().length];
        List<Integer> bfs = new ArrayList<>();

        queue.offer(start);
        visited[start] = true;
        bfs.add(start);

        System.out.println("BFS Traversal:");
        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : graph.getList().get(node).keySet()) {
                if (!visited[neighbor]) {
                    queue.offer(neighbor);
                    visited[neighbor] = true;
                    bfs.add(neighbor);
                }
            }
        }
        return bfs;
    }
}


