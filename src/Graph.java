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

        //Initialize adjacency matrix with a large value (infinity for non-existing edges)
        for (int i = 0; i < vertices; i++) {
            Arrays.fill(adjacencyMatrix[i], Integer.MAX_VALUE);
            adjacencyMatrix[i][i] = 0; // Distance to itself is 0
        }
    }

    //Add unweighted edge( default weight = 1 )
    public void addEdge(int src, int dest) {
        addEdge(src,dest,1);
    }

    // Add weighted edge
    public void addEdge(int src,int dest, int weight){

        //chec if the source and destinition are in the correct range
        if (src >= vertices || dest >= vertices || src < 0 || dest < 0) {
            throw new IllegalArgumentException("Invalid node index");
        }

        //add edge to adjacency list
        adjacencyList.get(src).add(new Pair(dest, weight));
        if(!isDirected) {
            adjacencyList.get(dest).add(new Pair(src, weight));
        }
    
        //add edge to adjacency matrix
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
                    System.out.print(0 + " ");
                else
                    System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}



