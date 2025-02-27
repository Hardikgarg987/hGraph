
package Graph;

import java.util.*;
import Algorithms.BFS;
import Algorithms.DFS;
import Algorithms.Dijkstra;

public class Graph {
    //Number of vertices
    private int vertices;
    //To handle directed/ undirected graph
    private boolean isDirected;

    //For adjacency list
    private Map<Integer, Map<Integer, Integer>> adjacencyList;

    //For adjacency matrix
    private int[][] adjacencyMatrix;

    //Constructor
    public Graph(int vertices, boolean isDirected) {
        this.vertices = vertices;
        this.isDirected = isDirected;

        //Initialize adjacency list
        adjacencyList = new HashMap<>();
        for(int i = 0;i<vertices;i++){
            adjacencyList.put(i, new HashMap<>());
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
        adjacencyList.get(src).put(dest, weight);
        if(!isDirected) {
            adjacencyList.get(dest).put(src, weight);
        }
    
        //add edge to adjacency matrix
        adjacencyMatrix[src][dest] = weight;
        if(!isDirected) {
            adjacencyMatrix[dest][src] = weight;
        }
    }

    // Print adjacency list
    public void printAdjacencyList() {
        System.out.println("Weighted Adjacency List:");
        for (var entry : adjacencyList.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            for (var neighbor : entry.getValue().entrySet()) {
                System.out.print("(" + neighbor.getKey() + ", " + neighbor.getValue() + ") ");
            }
            System.out.println();
        }
    }

    //Print adjacency Matrix
    public void printAdjacencyMatrix() {
        System.out.println("Weighted Adjacency Matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (adjacencyMatrix[i][j] == Integer.MAX_VALUE)
                    System.out.print("0 ");
                else
                    System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public Map<Integer, Map<Integer, Integer>> getList() {
        return adjacencyList;
    }

    public int[][] getMatrix() {
        return adjacencyMatrix;
    }

    public List<Integer> bfs(int start){
        return BFS.bfs(this, start);
    }

    public List<Integer> bfs(int start, boolean print){
        return BFS.bfs(this, start, print);
    }

    public List<Integer> dfs(int start){
        return DFS.dfs(this, start);
    }

    public List<Integer> dfs(int start, boolean print) {
       return DFS.dfs(this, start, print);
    }

    // Call Dijkstra from Graph
    public int[] dijkstra(int start) {
        return Dijkstra.dijkstra(this, start);
    }

    public void dijkstra(int start, boolean print) {
        Dijkstra.dijkstra(this, start, print);
    }
}



