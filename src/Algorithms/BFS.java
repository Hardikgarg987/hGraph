package Algorithms;

import Graph.Graph;
import java.util.*;

public class BFS {
    public static List BFS(Graph graph, int start) {
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

    public static void BFS(Graph graph, int start, boolean print) {
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
        System.out.println("BFS : " + bfs);
    }
}


