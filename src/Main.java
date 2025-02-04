public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(5, false);

        // Unweighted edges (default weight = 1)
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        // Weighted edges
        graph.addEdge(3, 4, 7);
        graph.addEdge(3, 4, 7);

        // Print the graphs
        graph.printAdjacencyList();
        graph.printAdjacencyMatrix();
    }
}
