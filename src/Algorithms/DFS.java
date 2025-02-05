package Algorithms;
import Graph.Graph;
import java.util.*;

public class DFS{
    public static List<Integer> dfs(Graph graph, int start, boolean print) {
        List<Integer> dfsResult = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();

            if (!visited.contains(node)) {
                visited.add(node);
                dfsResult.add(node);

                List<Integer> neighbors = new ArrayList<>(graph.getList().get(node).keySet());
                Collections.reverse(neighbors);
                for (int neighbor : neighbors) {
                    if (!visited.contains(neighbor))
                        stack.push(neighbor);
                }
            }
        }

        if (print) {
            System.out.println(dfsResult);
        }
        return dfsResult;
    }

    public static List<Integer> dfs(Graph graph, int start){
        return dfs(graph, start, false);
    }
}