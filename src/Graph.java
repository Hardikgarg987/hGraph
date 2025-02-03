import java.util.*;

public class Graph {
    //Number of vertices
    private int vertices;
    //To handle directed/ undirected graph
    private boolean isDirected;

    //For adjacency list
    private Map<Integer, List<Integer>> adjacencyList;

    //For adjacency matrix
    private int[][] adjacencyMatrix;

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

    // Add edge (Adjacency List)
    public void addEdgeList(int src,int dest){
        adjacencyList.get(src).add(dest);
        if(!isDirected) {
            adjacencyList.get(dest).add(src);
        }
    }

    // Add edge (Adjacency Matrix)
    public void addEdgeMatrix(int src, int dest) {
        adjacencyMatrix[src][dest] = 1;
        if(!isDirected) {
            adjacencyMatrix[dest][src] = 1;
        }
    }

    // Print adjacency list
    public void printAdjacencyList() {
        System.out.println("Adjacency List : ");
        for(int node : adjacencyList.keySet()) {
            System.out.println(node + " -> ");
            for(int neighbor : adjacencyList.get(node)){
                System.out.println(neighbor + " ");
            }
            System.out.println();
        }
    }

    // Print adjacency matrix
    public void printAdjacencyMatrix() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    
}



