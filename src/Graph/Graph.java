package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private HashMap<String, ArrayList<String>> adjacencyList;

    public Graph(){
        adjacencyList = new HashMap<>();
    }

    // Add a new vertex to the graph.
    public boolean addVertex(String vertex) {
        if(adjacencyList.containsKey(vertex))
            return false;
        adjacencyList.put(vertex, new ArrayList<>());
        return  true;
    }


    // Remove a vertex from the graph.
    public boolean removeVertex(String vertex){
        if(adjacencyList.get(vertex) == null)
            return false;
        for(String otherVertex : adjacencyList.get(vertex)){
            adjacencyList.get(otherVertex).remove(vertex);
        }
        adjacencyList.remove(vertex);
        return true;
        /*
        * if (!adjacencyList.containsKey(vertex)) {
            return;
        }
        adjacencyList.remove(vertex);
        for (List<Integer> neighbors : adjacencyList.values()) {
            neighbors.removeIf(v -> v == vertex);
        }
        * */
    }


    // Add an edge between two vertices.
    public boolean addEdge(String vertex1, String vertex2){
        if(!(adjacencyList.containsKey(vertex1) || adjacencyList.containsKey(vertex2)))
            return false;
        adjacencyList.get(vertex1).add(vertex2);
        adjacencyList.get(vertex2).add(vertex1);
        return  true;

        /*
         adjacencyList.computeIfAbsent(vertex1, k -> new ArrayList<>()).add(vertex2);
        adjacencyList.computeIfAbsent(vertex2, k -> new ArrayList<>()).add(vertex1);
        * */
    }


    // Remove an edge between two vertices.
    public void removeEdge(String vertex1, String vertex2){
        adjacencyList.get(vertex1).remove(vertex2);
        adjacencyList.get(vertex2).remove(vertex1);
        /*
        *  adjacencyList.get(vertex1).removeIf(v -> v == vertex2);
        adjacencyList.get(vertex2).removeIf(v -> v == vertex1);
        * */
    }


    // Get a list of all vertices.
    public ArrayList<String> getVertices(){
        ArrayList<String> vertices = new ArrayList<>();
        for(Map.Entry<String,ArrayList<String>> entry : adjacencyList.entrySet()){
            vertices.add(entry.getKey());
        }
        return vertices;
    }


    // Check if two vertices are adjacent.
    public boolean isAdjacent(String vertex1, String vertex2){
        List<String> neighbors = adjacencyList.getOrDefault(vertex1, new ArrayList<>());
        return neighbors.contains(vertex2);
    }


    // Get the total number of vertices.
    public int getVertexCount(){
        return adjacencyList.size();
    }


    // Get the total number of edges.
    public int getEdgeCount(){
        int count = 0;
        for (List<String> neighbors : adjacencyList.values()) {
            count += neighbors.size();
        }
        return count/2;
    }


   // public ArrayList<Pair<Integer, Integer>> getEdges(){}
    // Get a list of all edges.

    // Get a list of neighbors of a given vertex.
    public ArrayList<String> getNeighbors(String vertex){
        return  adjacencyList.getOrDefault(vertex,new ArrayList<>());
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        //graph.addVertex("F");
        graph.addEdge("A", "B");
        graph.addEdge("A","C");
        graph.addEdge("A", "D");
        graph.addEdge("B","E");
        graph.addEdge("C","D");
        graph.addEdge("C","B");
        graph.addEdge("C","E");





        System.out.print("Vertices: ");
        for (String vertex : graph.getVertices()) {
            System.out.print(vertex + " ");
        }
        System.out.println();

       /* System.out.print("Edges: ");
        for (Pair<Integer, Integer> edge : graph.getEdges()) {
            System.out.print("(" + edge.getFirst() + ", " + edge.getSecond() + ") ");
        }
        System.out.println();*/

        System.out.print("Neighbors of vertex A: ");
        for (String neighbor : graph.getNeighbors("A")) {
            System.out.print(neighbor + " ");
        }
        System.out.println();

        System.out.println("Is vertex A adjacent to vertex D? " + graph.isAdjacent("A", "D"));

        graph.removeEdge("A","D");
        System.out.println("Is vertex A adjacent to vertex D? " + graph.isAdjacent("A", "D"));

        graph.removeVertex("D");

        System.out.println("After removing some edges and vertices:");

        System.out.print("Vertices: ");
        for (String vertex : graph.getVertices()) {
            System.out.print(vertex + " ");
        }
        System.out.println();

//        System.out.print("Edges: ");
//        for (Pair<Integer, Integer> edge : graph.getEdges()) {
//            System.out.print("(" + edge.getFirst() + ", " + edge.getSecond() + ") ");
//        }
//        System.out.println();
    }

}
