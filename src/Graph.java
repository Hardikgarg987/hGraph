import java.util.*;

public class Graph {
    //Number of vertices
    private int vertices;
    //To handle directed/ undirected graph
    private boolean isDirected;

    //For adjacency list
    private Map<Integer, List<Pair>> adjacencyList;

    //For adjacency matrix
    private int[][] adjacencyMatrix;

    class Pair {
        int node, weight;
        public Pair(int node, int weight){
            this.node = node;
            this.weight = weight;
        }
    }

    //Constructor
    public Graph(int vertices, boolean isDirected) {
        this.vertices = vertices;
        this.isDirected = isDirected;

        //Initialize adjacency list
        adjacencyList = new HashMap<>();
        for(int i = 0;i<vertices;i++){
            adjacencyList.put(i, new ArrayList<>());
        }

        //Initialize adjacency matrix
        adjacencyMatrix = new int[vertices][vertices];
    }

    //Add edge for weighted adjacency list( default weight = 1 )
    public void addEdgeList(int src, int dest) {
        adjacencyList.get(src).add(new Pair(dest, 1));
        if(!isDirected) {
            adjacencyList.get(dest).add(new Pair(src, 1));
        }
    }

    // Add edge (Adjacency List)
    public void addEdgeList(int src,int dest, int weight){
        adjacencyList.get(src).add(new Pair(dest, weight));
        if(!isDirected) {
            adjacencyList.get(dest).add(new Pair(src, weight));
        }
    }

    //Add edge for weighted Adjacency Matrix (defualt weight = 1)
    public void addEdgeMatrix(int src, int dest) {
        adjacencyMatrix[src][dest] = 1;
        if(!isDirected) {
            adjacencyMatrix[dest][src] = 1;
        }
    }

    // Add edge (Adjacency Matrix)
    public void addEdgeMatrix(int src, int dest, int weight) {
        adjacencyMatrix[src][dest] = weight;
        if(!isDirected) {
            adjacencyMatrix[dest][src] = weight;
        }
    }

    // Print adjacency list
    public void printAdjacencyList() {
        System.out.println("Adjacency List : ");
        for(int node : adjacencyList.keySet()) {
            System.out.println(node + " -> ");
            for(Pair neighbor : adjacencyList.get(node)){
                System.out.print("(" + neighbor.node + ", " + neighbor.weight + ") ");
            }
            System.out.println();
        }
    }

    // Print adjacency matrix
    public void printAdjacencyMatrix() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (adjacencyMatrix[i][j] == Integer.MAX_VALUE)
                    System.out.print("INF ");
                else
                    System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}



