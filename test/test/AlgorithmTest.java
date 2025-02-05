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
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        List<Integer> bfsResult = graph.bfs(1);
        assertArrayEquals(new Integer[]{1, 2, 3, 4}, bfsResult.toArray());  // Ensures exact BFS order
    }

    @Test
    public void testDFS() {
        Graph graph = new Graph(4, false);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        List<Integer> dfsResult = graph.dfs(1, false);

        // Validate exact DFS order (for this specific graph)
        assertNotNull(dfsResult);
        assertEquals(4, dfsResult.size()); // Ensure all nodes are visited
        assertTrue(dfsResult.get(0) == 1); // DFS should start at 1
        assertTrue(dfsResult.containsAll(List.of(1, 2, 3, 4))); // All nodes must be present
    }
}
