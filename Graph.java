import java.util.*;
public class Graph {
    HashMap<Integer,HashMap<Integer,Integer>> graph;
    public  Graph(int Nodes){
        graph= new HashMap<>();
        for (int  i = 1;i<=Nodes;i++){
            graph.put(i,new HashMap<Integer,Integer>());
        }
        
    }
    public void addEdge(int v1, int v2, int w){
        if(!graph.containsKey(v1)){
            graph.put(v1,new HashMap<Integer,Integer>());
        }
        if(!graph.containsKey(v2)){
            graph.put(v2,new HashMap<Integer,Integer>());
        }
        graph.get(v1).put(v2,w);
        graph.get(v2).put(v1,w);
    }
    public boolean hashedge(int v1,int v2){
        return graph.get(v1).containsKey(v2);
    }
    public void removeEdge(int v1, int v2) {
    
        if (graph.containsKey(v1) && graph.containsKey(v2) && hashedge(v1,v2)) {
            
            graph.get(v1).remove(v2);
            graph.get(v2).remove(v1);
        }
    }
    public void removeVertex(int v) {
        if (graph.containsKey(v)) {
        
            for (int k : new ArrayList<>(graph.get(v).keySet())) {
                graph.get(k).remove(v);
            }
            graph.remove(v);
        }
    }
    public int findEdge() {
        int size = 0;
        for (int key : graph.keySet()) {
            size += graph.get(key).size();
        }
        return size / 2;
    }

    //find path between two vertex using recursion and backtracking !!!
    


    public static void main(String[] args) {
        Graph graph = new Graph(7);

        // Adding edges
        graph.addEdge(1, 2, 30);
        graph.addEdge(1, 4, 20);
        graph.addEdge(2, 3, 30);
        graph.addEdge(3, 4, 10);
        graph.addEdge(4, 5, 40);
        graph.addEdge(5, 6, 12);
        graph.addEdge(5, 7, 50);
        graph.addEdge(6, 7, 5);

        // Displaying graph edges
        System.out.println("Graph edges:");
        for (int i = 1; i <= 7; i++) {
            System.out.println("Node " + i + " connections: " + graph.graph.get(i));
        }

        // Checking if an edge exists
        System.out.println("\nEdge between 1 and 2 exists: " + graph.hashedge(1, 2));
        System.out.println("Edge between 2 and 4 exists: " + graph.hashedge(2, 4));

        // Removing an edge
        graph.removeEdge(1, 2);
        System.out.println("\nGraph edges after removing edge between 1 and 2:");
        for (int i = 1; i <= 7; i++) {
            System.out.println("Node " + i + " connections: " + graph.graph.get(i));
        }

        // Removing a vertex
        graph.removeVertex(5);
        System.out.println("\nGraph edges after removing vertex 5:");
        for (int i = 1; i <= 7; i++) {
            System.out.println("Node " + i + " connections: " + graph.graph.get(i));
        }

        // Finding total edges
        System.out.println("\nTotal edges in the graph: " + graph.findEdge());
    }
}

