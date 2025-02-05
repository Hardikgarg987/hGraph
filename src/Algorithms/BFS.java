package Algorithms;

import Graph.Graph;
import java.util.*;

public class BFS {
    public static List<Integer> bfs(Graph graph, int start) {
        return bfs(graph, start, false);
    }

    public static List<Integer> bfs(Graph graph, int start, boolean print) {
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

        if(print){
            System.out.println(bfs);
        }

        return bfs;
    }
}


