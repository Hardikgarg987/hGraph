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

        List<Integer> bfsResult = BFS.bfs(graph, 1);
        assertEquals(List.of(1, 2, 3, 4), bfsResult);
    }

    @Test
    public void testDFS() {
        Graph graph = new Graph(4, false);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        List<Integer> dfsResult = DFS.dfs(graph, 1, false);
        assertTrue(dfsResult.contains(1));
        assertTrue(dfsResult.contains(2));
        assertTrue(dfsResult.contains(3));
        assertTrue(dfsResult.contains(4));
    }
}
