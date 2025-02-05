package test;

import Graph.Graph;
import org.junit.Test;
import static org.junit.Assert.*;

public class GraphTest {

    @Test
    public void testAddEdge() {
        Graph graph = new Graph(5, false);
        graph.addEdge(1, 2);
        assertTrue(graph.getList().get(1).containsKey(2));
        assertTrue(graph.getList().get(2).containsKey(1)); // Undirected graph
    }
}
