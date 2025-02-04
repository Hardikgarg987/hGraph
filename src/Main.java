public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(5, false);

        // Unweighted edges (default weight = 1)
        graph.addEdgeList(0, 1);
        graph.addEdgeList(1, 2);
        graph.addEdgeList(2, 3);

        graph.addEdgeMatrix(0, 1);
        graph.addEdgeMatrix(1, 2);
        graph.addEdgeMatrix(2, 3);

        // Weighted edges
        graph.addEdgeList(3, 4, 7);
        graph.addEdgeMatrix(3, 4, 7);

        // Print the graphs
        graph.printAdjacencyList();
        graph.printAdjacencyMatrix();
    }
}
