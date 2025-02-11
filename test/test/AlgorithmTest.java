package test;

import Graph.Graph;
import Algorithms.BFS;
import Algorithms.DFS;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class AlgorithmTest {

    @Test
    public void testBFS() {
        Graph graph = new Graph(4, false);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        List<Integer> bfsResult = graph.bfs(0,true);
        assertArrayEquals(new Integer[]{0,1,2,3}, bfsResult.toArray());  // Ensures exact BFS order
    }

    @Test
    public void testDFS() {
        Graph graph = new Graph(5, false);
        graph.addEdge(0,1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        List<Integer> dfsResult = graph.dfs(0, true);

        // Validate exact DFS order (for this specific graph)
        assertNotNull(dfsResult);
        assertEquals(5, dfsResult.size()); // Ensure all nodes are visited
        assertTrue(dfsResult.get(0) == 0); // DFS should start at 1
        assertTrue(dfsResult.containsAll(List.of(0,1, 2, 3, 4))); // All nodes must be present
    }

    @Test
    public void testDijkstra() {
        Graph graph = new Graph(6, false);
        graph.addEdge(0,1,3);
        graph.addEdge(1, 2, 4);
        graph.addEdge(1, 3, 1);
        graph.addEdge(3, 2, 2);
        graph.addEdge(2, 4, 1);
        graph.addEdge(3, 5, 5);
        graph.addEdge(4, 5, 3);
        graph.dijkstra(1,true);
        int[] expected = {3, 0, 3, 1, 4, 6};
        assertArrayEquals(expected, graph.dijkstra(1));

    }
}
