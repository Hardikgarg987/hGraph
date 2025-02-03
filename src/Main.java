public class Main {
    public static void main(String[] args) {
        // Create a graph with 5 vertices, directed
        Graph graph = new Graph(5, true);

        // Add edges using adjacency list
        graph.addEdgeList(0, 1);
        graph.addEdgeList(0, 4);
        graph.addEdgeList(1, 2);
        graph.addEdgeList(1, 3);
        graph.addEdgeList(1, 4);

        // Add edges using adjacency matrix
        graph.addEdgeMatrix(0, 1);
        graph.addEdgeMatrix(0, 4);
        graph.addEdgeMatrix(1, 2);
        graph.addEdgeMatrix(1, 3);
        graph.addEdgeMatrix(1, 4);

        // Print both representations
        graph.printAdjacencyList();
        graph.printAdjacencyMatrix();
    }
}
